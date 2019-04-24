package com.mami.care.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class MyListView extends ListView
{
    public MyListView(Context context)
    {
        super(context);
    }
    public MyListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,    MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}