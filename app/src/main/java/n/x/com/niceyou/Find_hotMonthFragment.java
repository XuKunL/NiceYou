package n.x.com.niceyou;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Find_hotMonthFragment  extends Fragment {
    public Find_hotMonthFragment() {
        super();
    }

    private List<ChatMessage> list;
    private ListView chat_listview;
    private EditText chat_input;
    private Button chat_send;
    private ChatMessageAdapter chatAdapter;
    private ChatMessage chatMessage = null;

    public static Find_hotMonthFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("发现图片", text);
        Find_hotMonthFragment hotRecommendFragment = new Find_hotMonthFragment();
        hotRecommendFragment.setArguments(bundle);
        return hotRecommendFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month, container, false);

        // 1.初始化
        chat_listview = (ListView) view.findViewById(R.id.chat_listview);
        chat_input = (EditText) view.findViewById(R.id.chat_input_message);
        chat_send = (Button) view.findViewById(R.id.chat_send);

        // 3.初始化数据
        list = new ArrayList<ChatMessage>();
        list.add(new ChatMessage("您好,小薇为您服务!", ChatMessage.Type.INCOUNT, new Date()));
        chatAdapter = new ChatMessageAdapter(list);
        chat_listview.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();

        final Handler handler = new Handler() {

            public void handleMessage(android.os.Message msg) {
                if (msg.what == 0x1) {
                    if (msg.obj != null) {
                        chatMessage = (ChatMessage) msg.obj;
                    }
                    // 添加数据到list中，更新数据
                    list.add(chatMessage);
                    chatAdapter.notifyDataSetChanged();
                }
            }

            ;
        };
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.chat_send:
                        final String send_message = chat_input.getText().toString().trim();
                        if (TextUtils.isEmpty(send_message)) {
                            Toast.makeText(getContext(), "对不起，您还未发送任何消息",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // 2.自己输入的内容也是一条记录，记录刷新
                        ChatMessage sendChatMessage = new ChatMessage();
                        sendChatMessage.setMessage(send_message);
                        sendChatMessage.setData(new Date());
                        sendChatMessage.setType(ChatMessage.Type.OUTCOUNT);
                        list.add(sendChatMessage);
                        chatAdapter.notifyDataSetChanged();
                        chat_input.setText("");

                        // 3.发送你的消息，去服务器端，返回数据
                        new Thread() {
                            public void run() {
                                ChatMessage chat = HttpUtils.sendMessage(send_message);
                                Message message = new Message();
                                message.what = 0x1;
                                message.obj = chat;
                                handler.sendMessage(message);
                            }
                        }.start();
                        break;
                }
            }
        };
        // 2.设置监听事件
        chat_send.setOnClickListener(onClickListener);
        return view;
    }
}