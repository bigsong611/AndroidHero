package com.bigsong.androidhero.chapter2;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bigsong.androidhero.R;

/**
 * Created by BigSong on 16/7/3.
 */
public class ScrollHideListViewActivity extends Activity {

    public static final String TAG = ScrollHideListViewActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private ListView mListView;
    private String[] mData = new String[20];
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;

    View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (Math.abs(mCurrentY - mFirstY) > mTouchSlop) {
                        if (mCurrentY > mFirstY) {
                            direction = 0;
                        } else if (mCurrentY < mFirstY) {
                            direction = 1;
                        }
                    }
//                    if (mCurrentY - mFirstY > mTouchSlop) {
//                        direction = 0;//down
//                    } else if (mCurrentY - mFirstY < mTouchSlop) {
//                        direction = 1;//up
//                    }
                    //0向下显示,1向上隐藏
//                    Log.d(TAG, "mCurrentY:" + mCurrentY + ";mFirstY:" + mFirstY + ";mTouchSlop:" + mTouchSlop);
                    Log.d(TAG, "direction:" + direction + " ; mShow:" + mShow);
                    if (direction == 1) {
                        if (mListView.getFirstVisiblePosition() > 0 && mShow) {
                            toolBarAnim(1);
                            mShow = false;
                        }
                    } else if (direction == 0) {

                        if (mListView.getFirstVisiblePosition() == 0 && !mShow) {
                            toolBarAnim(0);
                            mShow = true;
                        }

                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollhide);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (ListView) findViewById(R.id.lv_scrollhide);
        for (int i = 0; i < 20; i++) {
            mData[i] = "item" + i;
        }
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(android.support.v7.appcompat.R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mData));
        mListView.setOnTouchListener(mTouchListener);
    }

    private void toolBarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(), -mToolbar.getHeight());
        }
        mAnimator.start();
    }
}
