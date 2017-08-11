package com.yihong.test.imagememory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.yihong.test.R;

public class ImageMemoryActivity extends AppCompatActivity {
    private TextView tv_info;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_memory);

        findViews();
        
        init();
    }

    private void findViews() {
        tv_info = (TextView) findViewById(R.id.tv_info);
        image = (ImageView) findViewById(R.id.img);
    }

    private void init() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.mipmap.bg,options);
        int img_height = options.outHeight;
        int img_width = options.outWidth;
        String img_type = options.outMimeType;

        tv_info.setText("img_height=" + img_height + "  img_width=" + img_width + "  img_type=" + img_type);
//        image.setImageBitmap(decodeSampledBitmapFromResource(getResources(),R.mipmap.bg,100,100));
        BitmapWorkerTask task = new BitmapWorkerTask(image,this);
        task.execute(R.mipmap.bg);
    }

    /**
     *计算图片加载到屏幕需要缩小的倍数
     * @param options
     * @param reqWidth   实际加载时候的宽度
     * @param reqHeight  实际加载时候的高度
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;

        if(height > reqHeight || width > reqWidth){
            int halHeight = height / 2;
            int halWidth = width / 2;
            while ((halHeight/inSampleSize)>reqHeight && (halWidth/inSampleSize)>reqWidth){
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);

        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res,resId,options);

    }


}
