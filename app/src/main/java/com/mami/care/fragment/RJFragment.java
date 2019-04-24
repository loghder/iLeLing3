package com.mami.care.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.mami.care.R;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RJFragment extends Fragment {


    public RJFragment() {
        // Required empty public constructor
    }

    QMUITopBar mTopBar;
    CalendarPickerView calendarPickerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rj, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Activity activity = getActivity();
        mTopBar = activity.findViewById(R.id.Topbar_rj);
        mTopBar.setTitle("日记");
        int temp = QMUIViewHelper.generateViewId();
        mTopBar.addRightImageButton(R.drawable.add, temp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleBottomSheetGrid();
            }
        });
        calendarPickerView=activity.findViewById(R.id.calendar_view);
        try {
            calendarPickerView.init(stringToDate("2019-04-01","yyyy-MM-dd"),
                    stringToDate("2019-05-01","yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendarPickerView.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
            @Override
            public boolean onCellClicked(Date date) {
                try {
                    String t=dateToString(date, "yyyy-MM-dd");
                    TextView t1,t2,t3,t4;
                    t1=activity.findViewById(R.id.textyp);
                    t2=activity.findViewById(R.id.textypdetail);
                    t3=activity.findViewById(R.id.textMamicare);
                    t4=activity.findViewById(R.id.textMamicaredetail);

                    switch (t) {
                        case "2019-04-20":
                            t1.setVisibility(View.VISIBLE);
                            t2.setVisibility(View.VISIBLE);
                            t3.setVisibility(View.INVISIBLE);
                            t4.setVisibility(View.INVISIBLE);
                            break;
                        case "2019-04-17":
                            t1.setVisibility(View.VISIBLE);
                            t2.setVisibility(View.VISIBLE);
                            t3.setVisibility(View.VISIBLE);
                            t4.setVisibility(View.VISIBLE);
                            break;
                            default:
                                t1.setVisibility(View.INVISIBLE);
                                t2.setVisibility(View.INVISIBLE);
                                t3.setVisibility(View.INVISIBLE);
                                t4.setVisibility(View.INVISIBLE);
                                break;

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }
        });

    }

    Date stringToDate(String dateStr, String format) throws Exception{
        if(dateStr==null||"".equals(dateStr)){
            throw new Exception("stringToDate:要转换的日期参数为空！");
        }
        Date date = null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateStr);
        }catch(Exception e){
            e.printStackTrace();
        }

        return date;
    }

    String dateToString(Date date,String format) throws Exception{
        if(date==null){
            throw new Exception("dateToString:要转换的日期参数为空！");
        }
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateStr = sdf.format(date);
        }catch(Exception e){
            e.printStackTrace();
        }

        return dateStr;
    }


    private void showSimpleBottomSheetGrid() {
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        final int TAG_SHARE_WEIBO = 2;
        final int TAG_SHARE_CHAT = 3;
        QMUIBottomSheet.BottomGridSheetBuilder builder = new QMUIBottomSheet.BottomGridSheetBuilder(getActivity());
        builder.addItem(R.mipmap.icon_more_operation_share_friend, "体重腹围", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_moment, "药品营养剂", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_weibo, "胎动计数", TAG_SHARE_WEIBO, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_chat, "Mamicare", TAG_SHARE_CHAT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        Activity activity=getActivity();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(getActivity());
                                builder.setTitle("添加药品营养剂记录")
                                        .setPlaceholder("例：生物活性肽钙 2片")
                                        .setInputType(InputType.TYPE_CLASS_TEXT)
                                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                                            @Override
                                            public void onClick(QMUIDialog dialog, int index) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .addAction("确定", new QMUIDialogAction.ActionListener() {
                                            @Override
                                            public void onClick(QMUIDialog dialog, int index) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
                                break;
                            case TAG_SHARE_WEIBO:
                                break;
                            case TAG_SHARE_CHAT:
                                TextView t1,t2,t3,t4;
                                t1=activity.findViewById(R.id.textyp);
                                t2=activity.findViewById(R.id.textypdetail);
                                t3=activity.findViewById(R.id.textMamicare);
                                t4=activity.findViewById(R.id.textMamicaredetail);
                                t1.setVisibility(View.GONE);
                                t2.setVisibility(View.GONE);
                                t3.setVisibility(View.VISIBLE);
                                t4.setVisibility(View.VISIBLE);
                                Toast.makeText(getContext(),"Mamicare数据已同步",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).build().show();


    }
}
