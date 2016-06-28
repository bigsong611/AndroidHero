package com.bigsong.androidhero.chapter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bigsong.androidhero.R;
import com.bigsong.androidhero.chapter2.adapter.ViewHolderAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigSong on 16/6/26.
 */
public class ViewHolderTest extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = ViewHolderTest.class.getSimpleName();

    private ListView viewHolderListView;
    private ViewHolderAdapter adapter;
    private Button btnAdd, btnRemove;
    private List<String> data;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewholdertest);
        viewHolderListView = (ListView) findViewById(R.id.list_viewholdertest);
        btnAdd = (Button) findViewById(R.id.btn_listview_add);
        btnRemove = (Button) findViewById(R.id.btn_listview_remove);
        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        init();
        adapter = new ViewHolderAdapter(this, data);
        viewHolderListView.setAdapter(adapter);
        /**
         * 用来设置listview显示在第几项,
         */
//        viewHolderListView.setSelection(50);
//        viewHolderListView.smoothScrollBy(500,100);
//        viewHolderListView.smoothScrollByOffset(20);
//        viewHolderListView.smoothScrollToPosition(5000);
        viewHolderListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG,"ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG,"ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG,"ACTION_UP");
                        break;
                }
                return false;
            }
        });

        viewHolderListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /**
             * 滑动状态改变,停止,正在滚动,用力滑动
             * @param view
             * @param scrollState
             */
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        Log.d(TAG,"SCROLL_STATE_IDLE");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        Log.d(TAG,"SCROLL_STATE_TOUCH_SCROLL");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        Log.d(TAG,"SCROLL_STATE_FLING");
                        break;
                }
            }

            /**
             * 滚动时会一直回调
             * @param view
             * @param firstVisibleItem
             * @param visibleItemCount
             * @param totalItemCount
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d(TAG,"onScroll");
            }
        });
    }

    private void init() {
        data = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            data.add(i + "号晚上没睡好");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listview_add:
                data.add("new");
                adapter.notifyDataSetChanged();
                viewHolderListView.setSelection(data.size() - 1);
                break;
            case R.id.btn_listview_remove:
                View view = viewHolderListView.getChildAt(i);
                TextView tv = (TextView) view.findViewById(R.id.tv_item);
                tv.setText("rrrrrrrrrr");
                i++;
                break;
            default:
        }
    }
}
