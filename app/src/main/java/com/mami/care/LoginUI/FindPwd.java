package com.mami.care.LoginUI;

/**
 * Created by cc on 2019/3/29 0029.
 */

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.QMUITopBar;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.mami.care.R.*;

public class FindPwd extends Activity {

    Button findButton;
    Button getcodeButton;
    private EditText pwdText1;                            //密码编辑
    private EditText pwdText2;                       //密码编辑
    private EditText codeText;
    private EditText phoneText;
    QMUITopBar mTopBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.decision_findpwd);
        //状态栏设置
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(color.qmui_config_color_blue));

        mTopBar = findViewById(id.Topbar);
        mTopBar.setTitle("找回密码");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getcodeButton = (Button) findViewById(id.register_btn_getcode);
        findButton = (Button) findViewById(id.findpwd_btn_register);
        getcodeButton.setOnClickListener(clickListener);      //注册界面两个按钮的监听事件
        findButton.setOnClickListener(clickListener);
        pwdText1 = (EditText) findViewById(id.findpwd_edit_pwd1);
        pwdText2 = (EditText) findViewById(id.findpwd_edit_pwd2);
        phoneText = (EditText) findViewById(id.findpwd_edit_phone);
        codeText = (EditText) findViewById(id.findpwd_edit_verify);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  //左上角返回
        finish();
        return true;
    }
    View.OnClickListener clickListener = new View.OnClickListener() {    //不同按钮按下的监听事件选择
        public void onClick(View v) {
            switch (v.getId()) {
                case id.register_btn_getcode:                       //获取验证码按钮的监听事件
                    if(isPhoneValid()) {
                        new TimeCounter(60000, 1000, getcodeButton).start();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                sendCode();
                            }
                        }).start();
                    }
                    break;
                case id.findpwd_btn_register:                     //找回按钮的监听事件,由注册界面返回登录界面
                    find_check();
                    break;
            }
        }
    };
    public void find_check(){//获取密码
        String phone=phoneText.getText().toString();
        String pw=pwdText1.getText().toString();

        if (isPhoneValid()&&isUserNameAndPwdValid()&&isVerifyCodedValid()) {
            Toast.makeText(this,"修改成功", Toast.LENGTH_SHORT).show();
            /*Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);*/
            finish();
        }
    }

    public boolean isUserNameAndPwdValid() {
        if (pwdText1.getText().toString().trim().equals("")) {
            return false;
        } else if (pwdText2.getText().toString().trim().equals("")) {
            return false;
        } else if (pwdText1.getText().toString().trim() .equals( pwdText2.getText().toString().trim())==false){

            return false;
        }
        return true;
    }
    public boolean isVerifyCodedValid() {                        //验证码判断
        if(codeText.getText().toString().trim().equals("")){
            Toast.makeText(this,"请输入验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(vertifyCode()==true)
            return true;
        else {
            Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean isPhoneValid() {                        //手机号判断

        return true;
    }
    void sendCode(){
        String phone=phoneText.getText().toString();
        //获取验证码
        try {
            String issend=new vertifyCode().send(phone);
        } catch (Exception e) {}
    }
    boolean vertifyCode(){
        String phone=phoneText.getText().toString();
        String code=codeText.getText().toString();
        String isTrue="0";
        vertifyCode vertifycode=new vertifyCode();
        vertifyCode.Vertify vertify=vertifycode.new Vertify(phone,code);
        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<String> result = new FutureTask<>(vertify);
        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            isTrue = result.get();  //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if(isTrue.equals("1"))
            return true;
        else
            return false;
    }
}