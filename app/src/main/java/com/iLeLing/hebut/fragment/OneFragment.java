package com.iLeLing.hebut.fragment;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.iLeLing.hebut.MainActivity;
import com.iLeLing.hebut.MworkerActivity;
import com.iLeLing.hebut.PworkerActivity;
import com.iLeLing.hebut.R;
import com.iLeLing.hebut.SworkerActivity;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class OneFragment extends Fragment {
    private ImageView call,record,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    private View.OnClickListener onClickListener;
    MediaRecorder mRecorder;

    public OneFragment() {
        // Required empty public constructor
    }

    // Content View Elements
    private android.support.constraint.ConstraintLayout mFrameLayout;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_one;
    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

            startActivity(intent);

    }

    // End Of Content View Elements
    private void bindViews() {
        Activity activity=getActivity();
        mFrameLayout = (android.support.constraint.ConstraintLayout) activity.findViewById(R.id.frameLayout);
        mTopbar_one = (com.qmuiteam.qmui.widget.QMUITopBar) activity.findViewById(R.id.Topbar_one);
        call=activity.findViewById(R.id.call);
        record=activity.findViewById(R.id.record);
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

                switch(id){
                    case R.id.imageView4://生活照料
                        Intent intent=new Intent(getActivity(), SworkerActivity.class);
                        intent.putExtra("title","生活照料");
                        startActivity(intent);
                        break;
                    case R.id.imageView5://上门体检
                        Intent inent=new Intent(getActivity(), PworkerActivity.class);
                        inent.putExtra("title","上门体检");
                        startActivity(inent);
                        break;
                    case R.id.imageView6://短时陪伴
                        ((MainActivity)getActivity()).getNavigationBar().selectTab(2);
                        break;
                    case R.id.imageView7://康复保健
                        Intent intt=new Intent(getActivity(), MworkerActivity.class);
                        intt.putExtra("title","康复保健");
                        startActivity(intt);
                        break;
                    case R.id.imageView8://志愿服务
                        ((MainActivity)getActivity()).getNavigationBar().selectTab(1);
                        break;
                    case R.id.imageView9://更多
                        Toast.makeText(getActivity(),"更多功能，敬请期待",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        bindViews();
        mTopbar_one.setTitle("首页");
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber("10086");
            }
        });
        record.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }


            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startVoice();
                    break;
                case MotionEvent.ACTION_UP:
                    mRecorder.stop();
                    break;
                default:
                    break;
                }
                return false;
            }

        });

    }
    /** 开始录音 */
    private void startVoice(){
        // 设置录音保存路径
        String mFileName = Environment.getExternalStorageDirectory() + UUID.randomUUID().toString() + ".amr";
        String state = android.os.Environment.getExternalStorageState();
        if (!state.equals(android.os.Environment.MEDIA_MOUNTED)) {
            Log.i("LOG_TAG", "SD Card is not mounted,It is  " + state + ".");
        }
        File directory = new File(mFileName).getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            Log.i("LOG_TAG", "Path to file could not be created");
        }
        Toast.makeText(getActivity(), "开始录音", Toast.LENGTH_LONG).show();
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e("LOG_TAG", "prepare() failed");
        }
        mRecorder.start();
    }
    /** 停止录音 */

}
