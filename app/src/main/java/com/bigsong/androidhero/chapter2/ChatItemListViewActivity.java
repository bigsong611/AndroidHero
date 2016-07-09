package com.bigsong.androidhero.chapter2;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bigsong.androidhero.R;
import com.bigsong.androidhero.chapter2.adapter.ChatItemListViewAdapter;
import com.bigsong.androidhero.chapter2.bean.ChatItemListViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigSong on 16/7/4.
 */
public class ChatItemListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mListView = (ListView) findViewById(R.id.list_chat);
        ChatItemListViewBean bean1 = new ChatItemListViewBean(0, "Hello How are you?", BitmapFactory.decodeResource(getResources(), R.drawable.icon_in));
        ChatItemListViewBean bean2 = new ChatItemListViewBean(1, "I am fine,And you?", BitmapFactory.decodeResource(getResources(), R.drawable.icon_out));
        ChatItemListViewBean bean3 = new ChatItemListViewBean(0, "I am fine,too", BitmapFactory.decodeResource(getResources(), R.drawable.icon_in));
        ChatItemListViewBean bean4 = new ChatItemListViewBean(1, "Bye bye", BitmapFactory.decodeResource(getResources(), R.drawable.icon_out));

        List<ChatItemListViewBean> mData = new ArrayList<ChatItemListViewBean>();
        mData.add(bean1);
        mData.add(bean2);
        mData.add(bean3);
        mData.add(bean4);
        mListView.setAdapter(new ChatItemListViewAdapter(this, mData));
    }
}
