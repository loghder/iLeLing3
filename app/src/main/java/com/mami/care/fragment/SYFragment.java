package com.mami.care.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mami.care.R;
import com.mami.care.WebActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import github.liusp.rotatelistview.ItemEntity;
import github.liusp.rotatelistview.RotateListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SYFragment extends Fragment {


    public SYFragment() {
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

    class MyAdapter extends ArrayAdapter<MyItem>{
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


    QMUITopBar mTopBar;
    Activity activity;
    ImageView imageView;
    RotateListView rotateListView;
    ScrollView scrollView;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sy, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity=getActivity();
        mTopBar=activity.findViewById(R.id.Topbar_sy);
        mTopBar.setTitle("首页");
        mTopBar.bringToFront();
        CircleImageView circleImageView=activity.findViewById(R.id.CircleImage);
        circleImageView.bringToFront();
        initView();
        //屏蔽外部滚动的触摸事件
        scrollView=activity.findViewById(R.id.scrollView2);
        rotateListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    scrollView.requestDisallowInterceptTouchEvent(false);
                } else {
                    scrollView.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        //设置当前时间
        rotateListView.setTodayIndex(19);
        rotateListView.setChildLayout(19);
        //今天按钮
        Button b=activity.findViewById(R.id.todayButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateListView.setTodayIndex(19);
                rotateListView.setChildLayout(19);
                TextView textView=activity.findViewById(R.id.textView02);
                textView.setText("251天");
                Toast.makeText(getContext(),"已切换到今天",Toast.LENGTH_SHORT).show();
            }
        });
        //listview添加数据
        ArrayList<MyItem> myItemList=new ArrayList<>();
        MyItem m1=new MyItem("怀孕期，这几种水果不适合孕妇多吃","怀孕期，这几种水果不适合孕妇多吃，可能会对宝宝有损伤，别大意",R.drawable.article01);
        myItemList.add(m1);
        MyItem m2=new MyItem("这几种水不适合孕妇，怀孕后尽量别碰","孕期胎儿就处在羊水的包裹当中，羊水若是过少了，会让胎儿很难受。而能够有效补充羊水的最简单的方法就是喝水。",R.drawable.article02);
        myItemList.add(m2);
        MyItem m3=new MyItem("孕妇瑜伽的几个误区 你一定要知道","瑜伽作为一种大众运动，越来越受到了女性的欢迎。一些孕妇也加入到了练习瑜伽的队伍中。她们通过瑜伽不仅缓解了心理压力，也让身体更加柔韧，避免了孕期疾病的发生。",R.drawable.article03);
        myItemList.add(m3);
        listView=activity.findViewById(R.id.listview01);
        listView.setAdapter(new MyAdapter(getContext(),R.layout.item_list,myItemList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        openUrl("https://baijiahao.baidu.com/s?id=1630147680546939170&wfr=spider&for=pc","怀孕期，这几种水果不适合孕妇多吃，可能会对宝宝有损伤，别大意");
                        break;
                    case 1:
                        openUrl("https://baijiahao.baidu.com/s?id=1630698659209313068&wfr=spider&for=pc","孕期多喝水好处多，但这几种水却不适合孕妇，怀孕后尽量别碰");
                        break;
                    case 2:
                        openUrl("https://baijiahao.baidu.com/s?id=1572488102726276&wfr=spider&for=pc","孕妇瑜伽的几个误区 你一定要知道");
                        break;
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    //WebView打开网页
    void openUrl(String url,String title){
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_URL", url);
        bundle.putString("EXTRA_TITLE", title);
        Intent intent=new Intent(activity, WebActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    //转盘
    private void initView() {
        imageView = activity.findViewById(R.id.rotate_listview_bg);
        rotateListView = activity.findViewById(R.id.rotate_listview);
        rotateListView.setOnRotationFinishedListener(new RotateListView.OnRotationFinishedListener() {
            @Override
            public void onRotationFinished(RotateListView.ItemView view) {
                TextView textView=activity.findViewById(R.id.textView02);
                textView.setText(270-view.getIncreaseId()+"天");
            }
        });
        initDisplay();
        if (rotateListView != null)
            rotateListView.setCircleBg(imageView);
        initData();
    }

    private void initDisplay() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w = dm.widthPixels;
        ViewGroup.LayoutParams rotateLP = rotateListView.getLayoutParams();
        rotateLP.height = w;
        rotateListView.setLayoutParams(rotateLP);

        ViewGroup.LayoutParams bgLp = imageView.getLayoutParams();
        bgLp.height = w;
        imageView.setLayoutParams(bgLp);
    }

    private void initData() {
        ArrayList<ItemEntity> list = new ArrayList<>();
        String[] month=new String[30];
        for (int i = 1; i < 31; i++) {
            month[i-1]="4月"+i+"日";
        }
        int temp=0;
        for (int i = 0; i < 38; i++) {
            for (int j = 1; j < 8; j++) {
                ItemEntity entity = new ItemEntity();
                entity.setName(month[temp%30]);
                temp++;
                if(j<7)
                    entity.setSubName(i+"周 + "+j+"天");
                else
                    entity.setSubName(i+1+"周");
                list.add(entity);
            }
        }
        rotateListView.setEntitys(list);
        rotateListView.setChildAngles();
    }
    //转盘结束

}
