package com.iLeLing.hebut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iLeLing.hebut.Util.TimeHolder;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import cn.qqtheme.framework.picker.DateTimePicker;

public class ReservationActivity extends AppCompatActivity {
    private TextView mTimeStart;
    private TextView mTimeEnd;
    private LinearLayout mFrameLayout;
    QMUIRoundButton submit;
    int hours;
    private com.qmuiteam.qmui.widget.QMUITopBar mTopbar_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        bindView();
        Time t=new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
        t.setToNow(); // 取得系统时间。
        int year = t.year;
        int month = t.month+1;
        int day = t.monthDay;
        int hour = t.hour; // 0-23
        int minute = t.minute;
        mTimeStart.setText(year + "-" + month + "-" + day + "  "
                + hour + ":" + minute);
        mTimeEnd.setText(year + "-" + month + "-" + day + "  "
                + hour + ":" + minute);



        mTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTimePicker picker = new DateTimePicker(ReservationActivity.this, DateTimePicker.HOUR_24);//24小时值
                picker.setDateRangeStart(2019, 4, 1);//日期起点
                picker.setDateRangeEnd(2020, 1,1);//日期终点
                picker.setTimeRangeStart(0, 0);//时间范围起点
                picker.setTimeRangeEnd(23, 59);//时间范围终点
                picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
                    @Override
                    public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                        //year:年，month:月，day:日，hour:时，minute:分
                        mTimeStart.setText(year + "-" + month + "-" + day + "  "
                                + hour + ":" + minute);
                        TimeHolder.timeFirst =Double.parseDouble(hour);
                    }
                });
                picker.show();
            }
        });

        mTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTimePicker picker = new DateTimePicker(ReservationActivity.this, DateTimePicker.HOUR_24);//24小时值
                picker.setDateRangeStart(2019, 4, 1);//日期起点
                picker.setDateRangeEnd(2020, 1,1);//日期终点
                picker.setTimeRangeStart(0, 0);//时间范围起点
                picker.setTimeRangeEnd(23, 59);//时间范围终点
                picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
                    @Override
                    public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                        //year:年，month:月，day:日，hour:时，minute:分
                        mTimeEnd.setText(year + "-" + month + "-" + day + "  "
                                + hour + ":" + minute);
                        TimeHolder.timeSecond =Double.parseDouble(hour);
//                        Toast.setText(""+(TimeHolder.timeSecond-TimeHolder.timeFirst)*25);
                        hours=(int)(TimeHolder.timeSecond-TimeHolder.timeFirst);

                    }
                });
                picker.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReservationActivity.this,"预约时长："+hours+" 分钟",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void bindView(){
        mTimeStart=findViewById(R.id.timeS);
        mTimeEnd=findViewById(R.id.timeE);
        mFrameLayout=findViewById(R.id.layout);
        submit=findViewById(R.id.submit);
    }
}
