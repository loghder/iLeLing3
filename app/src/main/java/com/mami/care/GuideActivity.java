package com.mami.care;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

public class GuideActivity extends AppCompatActivity {

    QMUITopBar qmuiTopBar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences userProjects = getSharedPreferences("Setting", Context.MODE_PRIVATE + Context.MODE_PRIVATE);
        if(userProjects.getBoolean("isGuided",false)) {
            startActivity(new Intent(GuideActivity.this,MainActivity.class));
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        qmuiTopBar=findViewById(R.id.Topbar_guide);
        qmuiTopBar.setTitle("设置状态");
        qmuiTopBar.addRightTextButton("下一步", QMUIViewHelper.generateViewId()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });

        //沉浸状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.modPink));

        SharedPreferences.Editor editor=userProjects.edit();
        editor.putBoolean("isGuided",true);
        editor.commit();
    }
}
