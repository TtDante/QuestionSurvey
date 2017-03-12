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

public class Main11Activity extends AppCompatActivity {
    String choice[]={"","","","",""};
    String FileName="Data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        //声明控件
        CheckBox Box1,Box2,Box3,Box4,Box5;
        Box1=(CheckBox)findViewById(R.id.checkBox10_1);
        Box2=(CheckBox)findViewById(R.id.checkBox10_2);
        Box3=(CheckBox)findViewById(R.id.checkBox10_3);
        Box4=(CheckBox)findViewById(R.id.checkBox10_4);

        Button nextbutton10=(Button)findViewById(R.id.button10_2);
        Button  previousbutton10=(Button)findViewById(R.id.button10_1);

        nextbutton10.setOnClickListener(listener);
        previousbutton10.setOnClickListener(listener);
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
    //nextbutton监听器
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button view=(Button)v;
            switch (view.getId()){
                case R.id.button10_2:
                    next10();
                    break;
                case
                        R.id.button10_1:
                    previous10();
                    break;
            }
        }
    };
    protected void next10()
    {
        //保存
        try {
            FileOutputStream outputStream=openFileOutput(FileName,Main11Activity.MODE_PRIVATE);
            for (int boxnum=0;boxnum<4;boxnum++)
            {
                outputStream.write(choice[boxnum].getBytes());
                outputStream.flush();
                outputStream.close();}
        }catch (FileNotFoundException e){e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace();}
        //跳转
        Intent intent = new Intent();
        intent.setClass(Main11Activity.this,Main12Activity.class);
        Main11Activity.this.startActivity(intent);
    }

    protected void previous10()
    {
        Intent intent = new Intent();
        intent.setClass(Main11Activity.this,Main10Activity.class);
        Main11Activity.this.startActivity(intent);
    }
}
