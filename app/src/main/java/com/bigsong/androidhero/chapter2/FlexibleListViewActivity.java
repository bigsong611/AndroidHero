package com.bigsong.androidhero.chapter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.bigsong.androidhero.R;

/**
 * Created by BigSong on 16/7/2.
 */
public class FlexibleListViewActivity extends AppCompatActivity {

    private FlexibleListView mFlexibleListView;
    private String[] data = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexiblelistview);
        for (int i = 0; i < 30; i++) {
            data[i] = "" + i;
        }
        mFlexibleListView = (FlexibleListView) findViewById(R.id.lv_flexible);
        mFlexibleListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
    }
}
