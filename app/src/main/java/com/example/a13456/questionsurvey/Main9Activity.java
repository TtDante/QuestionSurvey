package com.example.a13456.questionsurvey;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.app.AlertDialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class Main9Activity extends AppCompatActivity {
    //Selection mSelection;
    Button btn_ele;
    ListView lv;
    List<Selection> selection = new ArrayList<Selection>();
    Context mContext;
    MyListAdapter adapter;
    List<Integer> listItemID = new ArrayList<Integer>();
    String answer;
    HashMap<Integer, View> map = new HashMap<Integer, View>();
    //选项内容
    String[] options = {"教师", "警察", "医生",
            "表演家", "演员", "运动员", "航天员"
            , "歌唱家","画家", "音乐家", "公务员",
            "探险家", "自由职业", "保险公司人员", "营销员"
            , "作家","导演", "教授", "程序员"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        mContext = getApplicationContext();
        btn_ele = (Button) findViewById(R.id.button8_2);
        lv = (ListView) findViewById(R.id.lvperson);
        initSelectionData();
        adapter = new MyListAdapter(selection);
        lv.setAdapter(adapter);

        btn_ele.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listItemID.clear();
                for (int i = 0; i < adapter.mChecked.size(); i++) {
                    if (adapter.mChecked.get(i)) {
                        listItemID.add(i);
                    }
                }

                if (listItemID.size() == 0) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Main9Activity.this);
                    builder1.setMessage("没有选中任何记录");
                    builder1.show();
                } else {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb_text = new StringBuilder();
                    for (int i = 0; i < listItemID.size(); i++) {
                        sb.append("The choice:" + listItemID.get(i) + " . ");
                        sb_text.append(options[listItemID.get(i)] + ",");
                    }
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(Main9Activity.this);
                    builder2.setMessage(sb.toString());
                    builder2.show();
                    //跳转
                    Intent intent1 = new Intent();
                    intent1.setClass(Main9Activity.this, Main10Activity.class);
                    startActivity(intent1);
                    answer = sb_text.toString();
                    write(answer);
                }

            }
        });

    }

    //写入操作
    private void write(String content) {

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
            buf.append(content);
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSelectionData() {
        Selection mSelection;

        mSelection = new Selection();
        for (int i = 0; i<19; i++) {
            mSelection = new Selection();
            mSelection.setS_answer_content(options[i]);
            selection.add(mSelection);
        }

    }

    //自定义ListView适配器
    class MyListAdapter extends BaseAdapter {
        List<Boolean> mChecked;
        List<Selection> listSelction;
        HashMap<Integer, View> map = new HashMap<Integer, View>();

        public MyListAdapter(List<Selection> list) {
            listSelction = new ArrayList<Selection>();
            listSelction = list;

            mChecked = new ArrayList<Boolean>();
            for (int i = 0; i < list.size(); i++) {
                mChecked.add(false);
            }
        }

        @Override
        public int getCount() {
            return listSelction.size();
        }

        @Override
        public Object getItem(int position) {
            return listSelction.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder = null;


        if (map.get(position) == null) {

            Log.e("Main9Activity", "position1 = " + position);
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.layoutitem, null);
            holder = new ViewHolder();
            holder.selected = (CheckBox) view.findViewById(R.id.Checkbutton);
            holder.context = (TextView) view.findViewById(R.id.Contexts);
            //holder.address = (TextView) view.findViewById(R.id.list_address);
            final int p = position;
            map.put(position, view);
            holder.selected.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    mChecked.set(p, cb.isChecked());
                }
            });
            view.setTag(holder);
        } else {
            Log.e("Main9Activity", "position2 = " + position);
            view = map.get(position);
            holder = (ViewHolder) view.getTag();
        }

            holder.selected.setChecked(mChecked.get(position));
            holder.context.setText(selection.get(position).getS_answer_content());
            return view;
        }
    }
        class ViewHolder {
            CheckBox selected;
            TextView context;
        }
    }



