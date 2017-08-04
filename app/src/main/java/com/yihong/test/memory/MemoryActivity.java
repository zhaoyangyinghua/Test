package com.yihong.test.memory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yihong.test.R;

public class MemoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        init();
    }

    private void init() {
        LeakClass leakClass = new LeakClass();
        leakClass.start();
    }

    class LeakClass extends Thread{
        @Override
        public void run() {
            while (true){
                try{
                    Thread.sleep(60*60*1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
