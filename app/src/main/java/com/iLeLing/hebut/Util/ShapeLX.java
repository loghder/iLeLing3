package com.iLeLing.hebut.Util;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.iLeLing.hebut.R;

public class ShapeLX extends ConstraintLayout {
    ShapeLX(Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.shape_layout, this, true);
        t1=findViewById(R.id.titleLX);
        t2=findViewById(R.id.numLX);
    }

    ShapeLX(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.shape_layout, this, true);
        t1=findViewById(R.id.titleLX);
        t2=findViewById(R.id.numLX);
    }

    ShapeLX(Context context, AttributeSet attrs,int defStyle){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.shape_layout, this, true);
        t1=findViewById(R.id.titleLX);
        t2=findViewById(R.id.numLX);
    }

    ShapeLX(Context context,String title,String num){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.shape_layout, this, true);

    }

    public void setTextInf(String title,String num){
        t1.setText(title);
        t2.setText(num);
    }

    TextView t1,t2;
    ConstraintLayout constraintLayout;

}
