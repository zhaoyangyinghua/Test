package com.yihong.test.file;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yihong.test.R;

import java.io.File;

public class FileActivity extends AppCompatActivity {
    private TextView tv_dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        findViews();
        init();
    }

    private void init() {
//        当保存文件到internal storage时，可以通过执行下面两个方法之一来获取合适的目录作为 FILE 的对象：
//        getFilesDir() : 返回一个File，代表了我们app的internal目录。
//        getCacheDir() : 返回一个File，代表了我们app的internal缓存目录。请确保这个目录下的文件能够在一旦不再需要的时候马上被删除，并对其大小进行合理限制，例如1MB 。系统的内部存储空间不够时，会自行选择删除缓存文件。
//        可以使用File() 构造器在那些目录下创建一个新的文件，如下：
        File file = new File(this.getFilesDir(),"lizhenhai");
        File file1 = new File(this.getCacheDir(),"lizhenhai");
        String filename = file.getAbsolutePath() + "   缓存目录是" + file1.getAbsolutePath();
        tv_dir.setText(filename);
    }

    private void findViews() {
        tv_dir = (TextView) findViewById(R.id.tv_dir);
    }
}
