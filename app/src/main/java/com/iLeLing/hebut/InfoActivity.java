package com.iLeLing.hebut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qmuiteam.qmui.widget.QMUITopBar;

public class InfoActivity extends AppCompatActivity {
    QMUITopBar topbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        topbar.setTitle("护工信息");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*补充代码，跳回去*/
            }
        });
    }
    public void initView(){
        topbar=findViewById(R.id.topbar);
    }
}
