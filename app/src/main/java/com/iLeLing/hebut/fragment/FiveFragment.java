package com.iLeLing.hebut.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iLeLing.hebut.InfoActivity;
import com.iLeLing.hebut.R;
import com.iLeLing.hebut.Util.Fruit;
import com.iLeLing.hebut.Util.FruitAdapter;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FiveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiveFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private QMUITopBar f5_topbar;
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FiveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FiveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FiveFragment newInstance(String param1, String param2) {
        FiveFragment fragment = new FiveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
       f5_topbar.setTitle("个人中心");
       f5_topbar.addRightImageButton(R.drawable.phone, QMUIViewHelper.generateViewId()).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_DIAL);
               intent.setData(Uri.parse("tel:" + 10086));
               startActivity(intent);
           }
       });
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(getActivity(), R.layout.fruit_item, fruitList);
        ListView listView = getActivity().findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
public void bindViews(){
        f5_topbar=getActivity().findViewById(R.id.f5_topbar);
}
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void initFruits() {
        Fruit apple = new Fruit("已报名活动", R.drawable.l1);
        fruitList.add(apple);
        Fruit banana = new Fruit("已签到活动", R.drawable.l2);
        fruitList.add(banana);
        Fruit orange = new Fruit("加入的组织", R.drawable.l3);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("我的评论", R.drawable.l4);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("敬请期待", R.drawable.l1);
        fruitList.add(pear);
        Fruit grape = new Fruit("敬请期待", R.drawable.l2);
        fruitList.add(grape);
//        Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
//        fruitList.add(pineapple);
//        Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
//        fruitList.add(strawberry);
//        Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
//        fruitList.add(cherry);
//        Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
//        fruitList.add(mango);
    }
}

