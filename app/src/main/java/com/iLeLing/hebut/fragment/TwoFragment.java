package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iLeLing.hebut.R;

public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }

    // Content View Elements
    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_two;

    // End Of Content View Elements
    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_two = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_two);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
        mTopbar_two.setTitle("第二页");
    }
}
