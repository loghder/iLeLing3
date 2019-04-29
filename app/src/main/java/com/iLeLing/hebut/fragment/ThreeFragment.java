package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.iLeLing.hebut.InfoActivity;
import com.iLeLing.hebut.LoginActivity;
import com.iLeLing.hebut.MaigugongActivity;
import com.iLeLing.hebut.MainActivity;
import com.iLeLing.hebut.R;
import com.iLeLing.hebut.Util.ConstellationAdapter;
import com.iLeLing.hebut.Util.GirdDropDownAdapter;
import com.iLeLing.hebut.Util.ListDropDownAdapter;
import com.qmuiteam.qmui.util.QMUIViewHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }

    //适配器相关
    class MyItem{
        String title;
        String lv;
        String detail;
        int Imageid;
        double score;
        double[] sc={4.7,4.85,4.9};

        MyItem(String title,String lv,String detail,int Imageid){
            this.title=title;
            this.detail=detail;
            this.Imageid=Imageid;
            this.score=sc[new Random().nextInt(3)];
            this.lv=lv;
        }

        public int getImageid() {
            return Imageid;
        }

        public String getDetail() {
            return detail;
        }

        public String getTitle() {
            return title;
        }

        public String getLv() {
            return lv;
        }

        public double getScore() {
            return score;
        }
    }

    class MyAdapter extends ArrayAdapter<MyItem> {
        int resourceId;

        public MyAdapter(Context context, int textViewResourceId,
                         List<MyItem> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyItem item = getItem(position);
            View view;
            MyAdapter.ViewHolder viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
                viewHolder = new MyAdapter.ViewHolder();
                viewHolder.fruitImage = (ImageView) view.findViewById (R.id.imageView);
                viewHolder.fruitName = (TextView) view.findViewById (R.id.textView2);
                viewHolder.lvv=view.findViewById(R.id.textView7);
                viewHolder.detail=view.findViewById(R.id.textView5);
                viewHolder.score=view.findViewById(R.id.textView6);
                view.setTag(viewHolder); // 将ViewHolder存储在View中
            } else {
                view = convertView;
                viewHolder = (MyAdapter.ViewHolder) view.getTag(); // 重新获取ViewHolder
            }
            viewHolder.fruitImage.setImageResource(item.getImageid());
            viewHolder.fruitName.setText(item.getTitle());
            viewHolder.detail.setText(item.getDetail());
            viewHolder.lvv.setText(item.getLv());
            viewHolder.score.setText(""+item.getScore());
            return view;
        }

        class ViewHolder {
            ImageView fruitImage;
            TextView fruitName;
            TextView detail;
            TextView lvv;
            TextView score;
        }
    }

    ArrayList<MyItem> myItemList;
    ArrayList<MyItem> myItemListBackUp;
    MyAdapter myAdapter;

    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_three;
    private com.yyydjk.library.DropDownMenu mDropDownMenu;
    private ListView mListView;

    // End Of Content View Elements

    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_three = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_three);
        //mDropDownMenu = (com.yyydjk.library.DropDownMenu) activity.findViewById(R.id.dropDownMenu);
        mListView=new ListView(getContext());
        mDropDownMenu=activity.findViewById(R.id.mdropDownMenu2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
        mTopbar_three.setTitle("护工信息");
        mTopbar_three.addRightImageButton(R.drawable.icon_map, QMUIViewHelper.generateViewId()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //listview添加数据
        myItemList=new ArrayList<>();
        myItemListBackUp=new ArrayList<>();
        final String[] name={"高素雅","唐姗","王丽梦"};
        final String[] lv={"高级护工 长期","普通护工 短期","护士 长期"};
        final String[] location={"天津市北辰区佳园里","天津市北辰区佳宁里","天津市北辰区佳欣里"};
        MyItem[] myItem=new MyItem[name.length];
        //添加两次，让数据显得多一点
        for (int i = 0; i < name.length; i++) {
            myItem[i]=new MyItem(name[i],lv[i],location[i],R.drawable.icon7);
            myItemList.add(myItem[i]);
        }
        for (int i = 0; i < name.length; i++) {
            myItem[i]=new MyItem(name[i],lv[i],location[i],R.drawable.icon7);
            myItemList.add(myItem[i]);
        }
        myItemListBackUp.addAll(myItemList);
        myAdapter=new MyAdapter(getContext(),R.layout.item_list2,myItemList);
        mListView.setAdapter(myAdapter);
        final Activity activity=getActivity();
        final Intent intent=new Intent(getContext(), InfoActivity.class);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:

                        intent.putExtra("name",name[i]);
                        intent.putExtra("lv",lv[i]);
                        intent.putExtra("location",location[i]);
                        startActivity(intent);
                        break;
                    case 1:

                        intent.putExtra("name",name[i]);
                        intent.putExtra("lv",lv[i]);
                        intent.putExtra("location",location[i]);
                        startActivity(intent);
                        break;
                    case 2:

                        intent.putExtra("name",name[i]);
                        intent.putExtra("lv",lv[i]);
                        intent.putExtra("location",location[i]);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("name",name[i]);
                        intent.putExtra("lv",lv[i]);
                        intent.putExtra("location",location[i]);
                        startActivity(intent);
                        break;
                        default:
                            intent.putExtra("name",name[i]);
                            intent.putExtra("lv",lv[i]);
                            intent.putExtra("location",location[i]);
                            startActivity(intent);
                            break;
                }
            }
        });
        //筛选菜单
        initView();

    }

    //筛选菜单
    private String headers[] = {"级别", "类型","评分"};
    private List<View> popupViews = new ArrayList<>();

    private GirdDropDownAdapter cityAdapter;
    private ListDropDownAdapter ageAdapter;
    private ListDropDownAdapter nearbyAdapter;

    private String citys[] = {"不限","高级护工","普通护工","护士"};
    private String ages[] = {"不限", "短期",  "长期"};
    private String nearby[] = {"从高到低", "从低到高"};

    private int constellationPosition = 0;
    private void initView() {
        //init city menu
        Context mContext=getContext();
        final ListView cityView = new ListView(mContext);
        cityAdapter = new GirdDropDownAdapter(mContext, Arrays.asList(citys));
        cityView.setDividerHeight(0);
        cityView.setAdapter(cityAdapter);

        //init age menu
        final ListView ageView = new ListView(mContext);
        ageView.setDividerHeight(0);
        ageAdapter = new ListDropDownAdapter(mContext, Arrays.asList(ages));
        ageView.setAdapter(ageAdapter);

        final ListView nearbyView = new ListView(mContext);
        nearbyView.setDividerHeight(0);
        nearbyAdapter = new ListDropDownAdapter(mContext, Arrays.asList(nearby));
        nearbyView.setAdapter(nearbyAdapter);

        //init popupViews
        popupViews.add(cityView);
        popupViews.add(ageView);
        popupViews.add(nearbyView);

        //筛选框点击事件
        cityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cityAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[0] : citys[position]);
                switch (position){
                    case 0:
                        myItemList.clear();
                        myItemList.addAll(myItemListBackUp);
                        myAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        myItemList.clear();
                        myItemList.add(myItemListBackUp.get(1));
                        myAdapter.notifyDataSetChanged();
                        break;
                }
                mDropDownMenu.closeMenu();
            }
        });

        ageView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ageAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : ages[position]);
                mDropDownMenu.closeMenu();
            }
        });


        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, mListView);
    }

    @Override
    public void onDestroyView() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onDestroyView();
        }
    }
}
