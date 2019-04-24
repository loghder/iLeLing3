package com.mami.care.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mami.care.LoginUI.Login;
import com.mami.care.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WDFragment extends Fragment {


    public WDFragment() {
        // Required empty public constructor
    }

    QMUITopBar mTopBar;
    QMUIGroupListView mGroupListView;
    QMUICommonListItemView loginButton;
    QMUICollapsingTopBarLayout mCollapsingTopBarLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wd, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Activity activity=getActivity();
        mCollapsingTopBarLayout=activity.findViewById(R.id.collapsing_topbar_layout);
        mCollapsingTopBarLayout.setTitle("设置");

        mGroupListView=activity.findViewById(R.id.groupListView);
        loginButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_person),
                "登陆/注册",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        loginButton.setOrientation(QMUICommonListItemView.VERTICAL);
        final int loginid= QMUIViewHelper.generateViewId();
        loginButton.setId(loginid);
        QMUICommonListItemView aboutButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_about),
                "关于我们",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        aboutButton.setOrientation(QMUICommonListItemView.VERTICAL);
        QMUICommonListItemView historyButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_history),
                "浏览历史",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        historyButton.setOrientation(QMUICommonListItemView.VERTICAL);

        QMUICommonListItemView favouriteButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_favourite),
                "我的收藏",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        favouriteButton.setOrientation(QMUICommonListItemView.VERTICAL);

        QMUICommonListItemView commitButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_commit),
                "我的评论",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        commitButton.setOrientation(QMUICommonListItemView.VERTICAL);

        QMUICommonListItemView kuaButton = mGroupListView.createItemView(
                ContextCompat.getDrawable(getContext(), R.drawable.icon_kua),
                "我赞过的",
                null,
                QMUICommonListItemView.HORIZONTAL,
                QMUICommonListItemView.ACCESSORY_TYPE_NONE);
        kuaButton.setOrientation(QMUICommonListItemView.VERTICAL);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((QMUICommonListItemView) v).getAccessoryType() == QMUICommonListItemView.ACCESSORY_TYPE_SWITCH) {
                    ((QMUICommonListItemView) v).getSwitch().toggle();
                }
                if(v.getId()==loginid){
                    startActivity(new Intent(activity, Login.class));
                }
            }
        };

        int size = QMUIDisplayHelper.dp2px(getContext(), 16);
        QMUIGroupListView.newSection(getContext())
                .setTitle(" ")
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(loginButton, onClickListener)
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setTitle(" ")
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(favouriteButton, onClickListener)
                .addItemView(kuaButton, onClickListener)
                .addItemView(commitButton, onClickListener)
                .addItemView(historyButton, onClickListener)
                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setTitle(" ")
                .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                .addItemView(aboutButton, onClickListener)
                .addTo(mGroupListView);
    }

}
