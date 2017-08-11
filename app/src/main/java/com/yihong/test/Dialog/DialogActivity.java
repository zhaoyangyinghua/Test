package com.yihong.test.Dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yihong.test.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_dialog;
    /**多选列表 */
    private TextView tv_selectDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViews();
        setListeners();
    }

    private void setListeners() {
        tv_dialog.setOnClickListener(this);
        tv_selectDialog.setOnClickListener(this);
    }

    private void findViews() {
        tv_dialog = (TextView) findViewById(R.id.tv_dialog);
        tv_selectDialog = (TextView) findViewById(R.id.tv_selectdialog);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_dialog:
                //列表对话框
                dialog2();
                break;

            case R.id.tv_selectdialog:
//                多选列表对话框：
                dialog4();
                break;

        }
    }

    private void dialog4(){
        final String items[]={"篮球","足球","排球","羽毛球"};
        final boolean selected[]={true,false,true,false};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        builder.setMultiChoiceItems(items,selected,new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // dialog.dismiss();
                Toast.makeText(DialogActivity.this, items[which]+isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                //android会自动根据你选择的改变selected数组的值。
                for (int i=0;i<selected.length;i++){
                    Log.e("hongliang",""+selected[i]);
                }
            }
        });
        builder.create().show();
    }

    private void dialog2() {
        final String items[]={"张三","李四","王五","李振海"};
        //dialog参数设置
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("提示"); //设置标题
        //builder.setMessage("是否确认退出?"); //设置内容
        builder.setIcon(R.mipmap.weather);//设置图标，图片id即可
        //设置列表显示，注意设置了列表显示就不要设置builder.setMessage()了，否则列表不起作用。
        builder.setItems(items,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, items[which], Toast.LENGTH_SHORT).show();

            }
        });
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
