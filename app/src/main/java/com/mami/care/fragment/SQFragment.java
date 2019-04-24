package com.mami.care.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mami.care.R;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

/**
 * A simple {@link Fragment} subclass.
 */
public class SQFragment extends Fragment {


    public SQFragment() {
        // Required empty public constructor
    }

    QMUITopBar mTopBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sq, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity=getActivity();
        mTopBar=activity.findViewById(R.id.Topbar_sq);
        mTopBar.setTitle("社区");
        int temp= QMUIViewHelper.generateViewId();
        mTopBar.addRightImageButton(R.drawable.add,temp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new QMUIBottomSheet.BottomListSheetBuilder(getContext())
                        .addItem("添加群聊")
                        .addItem("新建群聊")
                        .build().show();
            }
        });
    }
}
