package com.bigsong.androidhero.chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bigsong.androidhero.R;

/**
 * Created by BigSong on 16/6/26.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter02_main);
    }

    public void onClick_btnViewHolder(View view) {
        startActivity(new Intent(MainActivity.this, ViewHolderTest.class));
    }
}
