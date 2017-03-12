package com.example.a13456.questionsurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main13Activity extends AppCompatActivity {
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        edittext=(EditText)findViewById(R.id.editText);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        Button nextbutton12=(Button)findViewById(R.id.button12_2);
        nextbutton12.setOnClickListener(listener);
    }
    //nextbutton监听器
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button view=(Button)v;
            switch (view.getId()){
                case R.id.button12_2:
                    next12();
                    break;
            }
        }
    };
    public void next12()
    {

        //保存
        File targetFile = new File("sdcard/" + "answer.txt");
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(targetFile, true));
           buf.append(edittext.getText().toString());
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //跳转
        Intent intent = new Intent();
        intent.setClass(Main13Activity.this,MainActivity_end.class);
        Main13Activity.this.startActivity(intent);
    }

    public void previous12(View view)
    {
        Intent intent = new Intent();
        intent.setClass(Main13Activity.this,Main12Activity.class);
        Main13Activity.this.startActivity(intent);
    }
}
