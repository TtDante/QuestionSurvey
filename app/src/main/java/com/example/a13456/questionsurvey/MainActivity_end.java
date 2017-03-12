package com.example.a13456.questionsurvey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity_end extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_end);
    }

    /**
     * Created by 13456 on 2017/3/12.
     */

    public static class Selection {
            private String S_answer_content;
            private String S_answerId;
            public String getS_answer_content(){
                return S_answer_content;
            }
            public String getS_answerId(){
                return S_answerId;
            }
            public void setS_answer_content(){
                this.S_answer_content=S_answer_content;
            }
            public void setS_answerId(){
                this.S_answerId=S_answerId;
            }
    }
}
