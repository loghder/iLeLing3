package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iLeLing.hebut.R;
import com.iLeLing.hebut.Util.ShapeLX;
import com.qmuiteam.qmui.util.QMUIViewHelper;

public class FourFragment extends Fragment {//给护工端用的


    public FourFragment() {
        // Required empty public constructor
    }

    // Content View Elements
    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_four;
    private ShapeLX shapeLX01,shapeLX02,shapeLX03;

    // End Of Content View Elements
    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_four = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_four);
        /*shapeLX01=activity.findViewById(R.id.shapeLX01);
        shapeLX02=activity.findViewById(R.id.shapeLX02);
        shapeLX03=activity.findViewById(R.id.shapeLX03);
*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
        mTopbar_four.setTitle("");
        mTopbar_four.addRightImageButton(R.drawable.icon_list, QMUIViewHelper.generateViewId()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });/*
        shapeLX01.setTextInf("累计接单","21");
        shapeLX02.setTextInf("进行中","3");
        shapeLX03.setTextInf("已完成","18");*/
    }
}
