package com.example.a13456.questionsurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OptionalDataException;

public class Main2Activity extends AppCompatActivity {
    //文件保存
    private String FileName ="Data.txt";
    //默认，防止不选发生异常
    String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //声明和绑定控件
        RadioGroup radiogroup=(RadioGroup)findViewById(R.id.radioGroup2);
        Button nextbutton1=(Button)findViewById(R.id.button1_1);
        nextbutton1.setOnClickListener(listener);
        //默认选项，防止不选发生错误
        RadioButton rb1=(RadioButton)Main2Activity.this.findViewById(R.id.Radio1_1);
        choice=rb1.getText().toString();
        //绑定一个RadioBUtton匿名监听器
           radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
               public void onCheckedChanged(RadioGroup arg0, int arg1) {
                   //获取变更后的选中项的ID
                   int radioButtonId = arg0.getCheckedRadioButtonId();
                   //根据ID获取RadioButton的实例
                   RadioButton rb = (RadioButton)Main2Activity.this.findViewById(radioButtonId);
                   //更新文本内容，以符合选中项
                   choice=rb.getText().toString();
               }
           });

    }

    //nextbutton监听器
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button view=(Button)v;
            switch (view.getId()){
                case R.id.button1_1:
                    next1();
                    break;
            }
        }
    };

    protected void next1()
    {
        //保存
        try {
            FileOutputStream outputStream=openFileOutput(FileName,Main2Activity.MODE_PRIVATE);
            outputStream.write(choice.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (FileNotFoundException e){e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace();}
        //跳转
        Intent intent = new Intent();
        intent.setClass(Main2Activity.this,Main3Activity.class);
        Main2Activity.this.startActivity(intent);
    }
}
