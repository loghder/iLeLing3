package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.iLeLing.hebut.R;
import com.iLeLing.hebut.Util.ConstellationAdapter;
import com.iLeLing.hebut.Util.GirdDropDownAdapter;
import com.iLeLing.hebut.Util.ListDropDownAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;

public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }

    //适配器相关
    class MyItem{
        String title;
        String detail;
        int Imageid;

        MyItem(String title,String detail,int Imageid){
            this.title=title;
            this.detail=detail;
            this.Imageid=Imageid;
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
            ViewHolder viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.fruitImage = (ImageView) view.findViewById (R.id.imageView);
                viewHolder.fruitName = (TextView) view.findViewById (R.id.textView2);
                viewHolder.detail=view.findViewById(R.id.textView5);
                view.setTag(viewHolder); // 将ViewHolder存储在View中
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
            }
            viewHolder.fruitImage.setImageResource(item.getImageid());
            viewHolder.fruitName.setText(item.getTitle());
            viewHolder.detail.setText(item.getDetail());
            return view;
        }

        class ViewHolder {
            ImageView fruitImage;
            TextView fruitName;
            TextView detail;
        }
    }

    ArrayList<MyItem> myItemList;
    ArrayList<MyItem> myItemListBackUp;
    MyAdapter myAdapter;

    // Content View Elements

    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_two;
    private com.yyydjk.library.DropDownMenu mDropDownMenu;
    private ListView mListView;

    // End Of Content View Elements

    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_two = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_two);
        mListView=new ListView(getContext());
        mDropDownMenu=activity.findViewById(R.id.mdropDownMenu);
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
        mTopbar_two.setTitle("任务");
        //listview添加数据
        myItemList=new ArrayList<>();
        myItemListBackUp=new ArrayList<>();
        MyItem m1=new MyItem("天津市北辰区佳园里社区“阳光周末”志愿陪伴养老服务","积分:1.2金币\n" +
                "时长:2-4小时\n" +
                "地址:天津市北辰区佳园里社区        1.2km",R.drawable.article01);
        myItemList.add(m1);
        MyItem m2=new MyItem("天津市北辰区佳欣里社区“夕阳红”游园活动","积分:1.0金币\n" +
                "时长:2-3小时\n" +
                "地址:天津市北辰区佳欣里社区        1.9km",R.drawable.article02);
        myItemList.add(m2);
        MyItem m3=new MyItem("天津市北辰区佳宁里社区“棋牌大赛”志愿者","积分:1.1金币\n" +
                "时长:2-4小时\n" +
                "地址:天津市北辰区佳宁里社区        1.3km",R.drawable.article03);
        myItemList.add(m3);
        MyItem m4=new MyItem("天津市北辰区佳欣里社区“老当益壮”手工制作活动","积分:1.2金币\n" +
                "时长:2-4小时\n" +
                "地址:天津市北辰区佳宁里社区        1.3km",R.drawable.article04);
        myItemList.add(m4);
        myItemListBackUp.addAll(myItemList);
        myAdapter=new MyAdapter(getContext(),R.layout.item_list,myItemList);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
        //筛选菜单
        initView();
    }

    //筛选菜单
    private String headers[] = {"地点", "时长"};
    private List<View> popupViews = new ArrayList<>();

    private GirdDropDownAdapter cityAdapter;
    private ListDropDownAdapter ageAdapter;
    private ListDropDownAdapter sexAdapter;
    private ConstellationAdapter constellationAdapter;

    private String citys[] = {"不限", "佳园里社区", "佳宁里社区", "佳欣里社区"};
    private String ages[] = {"不限", "1小时", "2-4小时", "半天", "全天"};

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

        //init popupViews
        popupViews.add(cityView);
        popupViews.add(ageView);

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
                        myItemList.add(myItemListBackUp.get(2));
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
