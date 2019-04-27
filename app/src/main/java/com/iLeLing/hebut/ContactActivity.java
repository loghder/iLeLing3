package com.iLeLing.hebut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.iLeLing.hebut.Util.Msg;
import com.iLeLing.hebut.Util.MsgAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

        private QMUITopBar info_topbar;
        private ListView msgListView;
        private EditText inputText;
        private Button send;
        private MsgAdapter adapter;

        private List<Msg> msgList = new ArrayList<Msg>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            info_topbar=findViewById(R.id.info_topbar);
            info_topbar.setTitle("联系护工");
            info_topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ContactActivity.this,InfoActivity.class);
                    startActivity(intent);
                }
            });
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_contact);
            initMsgs(); // 初始化消息数据
            adapter = new MsgAdapter(ContactActivity.this, R.layout.msg_item, msgList);
            inputText = (EditText) findViewById(R.id.input_text);
            send = (Button) findViewById(R.id.send);
            msgListView = (ListView) findViewById(R.id.msg_list_view);
            msgListView.setAdapter(adapter);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content = inputText.getText().toString();
                    if (!"".equals(content)) {
                        Msg msg = new Msg(content, Msg.TYPE_SENT);
                        msgList.add(msg);
                        adapter.notifyDataSetChanged(); // 当有新消息时，刷新ListView中的显示
                        msgListView.setSelection(msgList.size()); // 将ListView定位到最后一行
                        inputText.setText(""); // 清空输入框中的内容
                    }
                }
            });
        }

        private void initMsgs() {
            Msg msg1 = new Msg("请问您上午十点的时候有空吗？", Msg.TYPE_RECEIVED);
            msgList.add(msg1);
            Msg msg2 = new Msg("可以的，我早五点到晚六点都有空", Msg.TYPE_SENT);
            msgList.add(msg2);
            Msg msg3 = new Msg("请问您有什么需要吗？",
                    Msg.TYPE_RECEIVED);
            msgList.add(msg3);
        }

}
