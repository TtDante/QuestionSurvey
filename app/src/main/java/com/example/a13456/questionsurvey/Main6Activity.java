package com.example.a13456.questionsurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main6Activity extends AppCompatActivity {
    String choice[]={"","","","",""};
    String FileName="Data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        //声明控件
        CheckBox Box1,Box2,Box3,Box4,Box5;
        Box1=(CheckBox)findViewById(R.id.checkbox5_1);
        Box2=(CheckBox)findViewById(R.id.checkbox5_2);
        Box3=(CheckBox)findViewById(R.id.checkbox5_3);
        Box4=(CheckBox)findViewById(R.id.checkbox5_4);
        Button nextbutton5=(Button)findViewById(R.id.button5_2);
        Button  previousbutton5=(Button)findViewById(R.id.button5_1);
        //给button设置监听
        nextbutton5.setOnClickListener(listener);
        previousbutton5.setOnClickListener(listener);
        //给每个控件设置监听
        Box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {if(isChecked)
                choice[0]=buttonView.getText().toString();}
        });
        Box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {if(isChecked)
                choice[1]=buttonView.getText().toString();}
        });
        Box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {if(isChecked)
                choice[2]=buttonView.getText().toString();}
        });
        Box4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
            {if(isChecked)
                choice[3]=buttonView.getText().toString();}
        });
    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button view=(Button)v;
            switch (view.getId()){
                case R.id.button5_2:
                    next5();
                    break;
                case
                        R.id.button5_1:
                    previous5();
                    break;
            }
        }
    };
    protected void next5()
    {
        //保存
        try {
            FileOutputStream outputStream=openFileOutput(FileName,Main6Activity.MODE_PRIVATE);
            for (int boxnum=0;boxnum<4;boxnum++)
            {
                outputStream.write(choice[boxnum].getBytes());
                outputStream.flush();
                outputStream.close();}
        }catch (FileNotFoundException e){e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace();}
        //跳转
        Intent intent = new Intent();
        intent.setClass(Main6Activity.this,Main7Activity.class);
        Main6Activity.this.startActivity(intent);
    }

    protected void previous5()
    {
        Intent intent = new Intent();
        intent.setClass(Main6Activity.this,Main5Activity.class);
        Main6Activity.this.startActivity(intent);
    }
}
