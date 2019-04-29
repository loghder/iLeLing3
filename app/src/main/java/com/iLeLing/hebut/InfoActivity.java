package com.iLeLing.hebut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;

public class InfoActivity extends AppCompatActivity {
    QMUITopBar topbar;
    Button purchase,contact;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String lv=intent.getStringExtra("lv");
        String location=intent.getStringExtra("location");
        info.setText("姓名："+name+"\n"+"年龄："+42+"\n类型:"+lv+"\nlocation:"+location);
        topbar.setTitle("护工信息");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*补充代码，跳回去*/
            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InfoActivity.this,MaigugongActivity.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(InfoActivity.this,ContactActivity.class);
                startActivity(intt);
            }
        });
    }
    public void initView(){
        topbar=findViewById(R.id.topbar);
        purchase=findViewById(R.id.purchase);
        contact=findViewById(R.id.contact);
        info=findViewById(R.id.info);
    }
}
