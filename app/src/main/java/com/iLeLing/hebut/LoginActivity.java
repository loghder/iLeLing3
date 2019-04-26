package com.iLeLing.hebut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;

public class LoginActivity extends AppCompatActivity {

    // Content View Elements

    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_login;
    private ImageView mImageView;
    private TextView mTextView;
    private EditText mEditText;
    private com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton mQMUIRoundButton;
    private android.support.constraint.Guideline mGuideline;

    // End Of Content View Elements

    private void bindViews() {
        mFrameLayout = (android.support.constraint.ConstraintLayout) findViewById(R.id.frameLayout);
        mTopbar_login = (com.qmuiteam.qmui.widget.QMUITopBar) findViewById(R.id.Topbar_login);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        mQMUIRoundButton = (com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton) findViewById(R.id.QMUIRoundButton);
        mGuideline = (android.support.constraint.Guideline) findViewById(R.id.guideline);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        QMUIStatusBarHelper.translucent(this);
        bindViews();
        mTopbar_login.setTitle("");
        Button b=mTopbar_login.addRightTextButton("注册", QMUIViewHelper.generateViewId());
        b.setTextColor(getResources().getColor(R.color.white));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mQMUIRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
