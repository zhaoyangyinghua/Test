package com.yihong.test;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yihong.test.Dialog.DialogActivity;
import com.yihong.test.actioinbar.ActionbarActivity;
import com.yihong.test.animator.AnimatorActivity;
import com.yihong.test.file.FileActivity;
import com.yihong.test.imagememory.ImageMemoryActivity;
import com.yihong.test.listView.ListViewActivity;
import com.yihong.test.memory.MemoryActivity;
import com.yihong.test.share.SharedActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_animator;
    private TextView tv_heap;
    private TextView tv_momory;
    private TextView tv_listView;
    private TextView tv_dialog;
    private TextView tv_actionbar;
    private TextView tv_file;
    private TextView tv_share;
    private TextView tv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        init();
        setListeners();
    }

    private void findViews() {
        tv_animator = (TextView) findViewById(R.id.tv_animatorTest);
        tv_heap = (TextView) findViewById(R.id.tv_heap);
        tv_momory = (TextView) findViewById(R.id.tv_memory);
        tv_listView = (TextView) findViewById(R.id.tv_listView);
        tv_dialog = (TextView) findViewById(R.id.tv_dialog);
        tv_actionbar = (TextView) findViewById(R.id.tv_actionbar);
        tv_file = (TextView) findViewById(R.id.tv_file);
        tv_share = (TextView) findViewById(R.id.tv_share);
        tv_img = (TextView) findViewById(R.id.tv_imagememory);
    }

    private void init(){
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        int heapSize = manager.getMemoryClass();
        tv_heap.setText("堆内存大小是" + heapSize + "");
    }

    private void setListeners() {
        tv_animator.setOnClickListener(this);
        tv_momory.setOnClickListener(this);
        tv_listView.setOnClickListener(this);
        tv_dialog.setOnClickListener(this);
        tv_actionbar.setOnClickListener(this);
        tv_file.setOnClickListener(this);
        tv_share.setOnClickListener(this);
        tv_img.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_animatorTest:
                startActivity(new Intent(MainActivity.this, AnimatorActivity.class));
                break;

            case R.id.tv_memory:
               startActivity(new Intent(MainActivity.this, MemoryActivity.class));
                break;

            case R.id.tv_listView:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;

            case R.id.tv_dialog:
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
                break;

            case R.id.tv_actionbar:
                startActivity(new Intent(MainActivity.this, ActionbarActivity.class));
                break;

            case R.id.tv_file:
                startActivity(new Intent(MainActivity.this, FileActivity.class));
                break;

            case R.id.tv_share:
                startActivity(new Intent(MainActivity.this, SharedActivity.class));
                break;

            case R.id.tv_imagememory:
                startActivity(new Intent(MainActivity.this, ImageMemoryActivity.class));
                break;
        }
    }
}
