package com.yihong.test.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yihong.test.R;

public class SharedActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_shareText;
    private TextView tv_appointText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        findViews();
        setListeners();
        init();
    }

    private void setListeners() {
        tv_shareText.setOnClickListener(this);
        tv_appointText.setOnClickListener(this);
    }

    private void findViews() {
        tv_shareText = (TextView) findViewById(R.id.tv_sharetext);
        tv_appointText = (TextView) findViewById(R.id.tv_appointsharetext);
    }

    private void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_sharetext:
                //分享文字
                shareText();
                break;

            case R.id.tv_appointsharetext:
                appintShare();
                break;
        }
    }

       private void appintShare() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"This is my text to send");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,getResources().getText(R.string.app_name)));
    }

    private void shareText() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"This is my text to send");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
