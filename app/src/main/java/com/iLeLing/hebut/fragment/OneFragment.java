package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.iLeLing.hebut.R;
import com.iLeLing.hebut.SworkerActivity;

public class OneFragment extends Fragment {
    private ImageView imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    private View.OnClickListener onClickListener;
    public OneFragment() {
        // Required empty public constructor
    }

    // Content View Elements
    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_one;

    // End Of Content View Elements
    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_one = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_one);
        imageView4=activity.findViewById(R.id.imageView4);
        imageView4.setOnClickListener(onClickListener);
        imageView5=activity.findViewById(R.id.imageView5);
        imageView5.setOnClickListener(onClickListener);
        imageView6=activity.findViewById(R.id.imageView6);
        imageView6.setOnClickListener(onClickListener);
        imageView7=activity.findViewById(R.id.imageView7);
        imageView7.setOnClickListener(onClickListener);
        imageView8=activity.findViewById(R.id.imageView8);
        imageView8.setOnClickListener(onClickListener);
        imageView9=activity.findViewById(R.id.imageView9);
        imageView9.setOnClickListener(onClickListener);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                Intent intent=new Intent(getActivity(), SworkerActivity.class);
                switch(id){
                    case R.id.imageView4://生活照料
                        intent.putExtra("title","生活照料");
                        startActivity(intent);
                        break;
                    case R.id.imageView5://上门体检
                        break;
                    case R.id.imageView6://短时陪伴
                        break;
                    case R.id.imageView7://康复保健
                        break;
                    case R.id.imageView8://志愿服务
                        break;
                    case R.id.imageView9://更多
                        Toast.makeText(getActivity(),"更多功能，敬请期待",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        bindViews();
        mTopbar_one.setTitle("首页");

    }
}
