package com.iLeLing.hebut;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.qmuiteam.qmui.util.QMUIViewHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MworkerActivity extends AppCompatActivity {
    //适配器相关
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mworker);
        bindViews();
        mTopbar_three.setTitle("康复保健---护工信息");
        mTopbar_three.addRightImageButton(R.drawable.icon_map, QMUIViewHelper.generateViewId()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mTopbar_three.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MworkerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //listview添加数据
        myItemList=new ArrayList<>();
        myItemListBackUp=new ArrayList<>();
        final String[] name={"高素雅","唐姗","王丽梦","吴小如","赵雪","文枝花"};
        final String[] lv={"中医","西医 ","中医","中医","西医 ","中医"};
        final String[] location={"天津市北辰区佳园里","天津市北辰区佳宁里","天津市北辰区佳欣里","天津市北辰区佳园里","天津市北辰区佳宁里","天津市北辰区佳欣里"};
        MworkerActivity.MyItem[] myItem=new MworkerActivity.MyItem[name.length];
        //添加两次，让数据显得多一点
        for (int i = 0; i < name.length; i++) {
            myItem[i]=new MworkerActivity.MyItem(name[i],lv[i],location[i],R.drawable.icon7);
            myItemList.add(myItem[i]);
        }
        for (int i = 0; i < name.length; i++) {
            myItem[i]=new MworkerActivity.MyItem(name[i],lv[i],location[i],R.drawable.icon7);
            myItemList.add(myItem[i]);
        }
        myItemListBackUp.addAll(myItemList);
        myAdapter=new MworkerActivity.MyAdapter(MworkerActivity.this,R.layout.item_list2,myItemList);
        mListView.setAdapter(myAdapter);

        final Intent intent=new Intent(MworkerActivity.this, InfoActivity.class);
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
                view = LayoutInflater.from(MworkerActivity.this).inflate(resourceId, parent, false);
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

    private LinearLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_three;

    private ListView mListView;

    // End Of Content View Elements

    private void bindViews() {

        mFrameLayout = findViewById(R.id.frameLayout_worker);
        mTopbar_three = findViewById(R.id.Topbar_mworker);
        //mDropDownMenu = (com.yyydjk.library.DropDownMenu) activity.findViewById(R.id.dropDownMenu);
        mListView=findViewById(R.id.listViewhhh_mworker);

    }


}

