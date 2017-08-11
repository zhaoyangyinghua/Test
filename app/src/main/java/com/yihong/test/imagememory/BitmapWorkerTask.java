package com.yihong.test.imagememory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by len on 2017/8/10.
 */

public class BitmapWorkerTask extends AsyncTask<Integer,Integer,Bitmap> {
    private WeakReference imageViewReference;
    private int data = 0;
    private Context context;

    public BitmapWorkerTask(ImageView imageView,Context context){
        imageViewReference = new WeakReference(imageView);
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(Integer[] params) {
        data = params[0];
        return ImageMemoryActivity.decodeSampledBitmapFromResource(context.getResources(), data, 100, 100);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(imageViewReference != null && bitmap != null){
            ImageView imageView = (ImageView) imageViewReference.get();
            if(imageView != null){
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
