package com.bigsong.androidhero.chapter2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigsong.androidhero.R;
import com.bigsong.androidhero.chapter2.bean.ChatItemListViewBean;

import java.util.List;

/**
 * Created by BigSong on 16/7/3.
 */
public class ChatItemListViewAdapter extends BaseAdapter {

    private List<ChatItemListViewBean> mDatas;
    private LayoutInflater mLayoutInflater;

    public ChatItemListViewAdapter(Context context,List<ChatItemListViewBean> data) {
        this.mDatas = data;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDatas.size();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemListViewBean bean = mDatas.get(position);
        return bean.getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            if (getItemViewType(position) == 0){
                holder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_chat_in,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon_in);
                holder.text = (TextView) convertView.findViewById(R.id.text_in);
            }else if (getItemViewType(position) == 1){
                holder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_chat_out,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon_out);
                holder.text = (TextView) convertView.findViewById(R.id.text_out);
            }
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageBitmap(mDatas.get(position).getIcon());
        holder.text.setText(mDatas.get(position).getText());
        return convertView;
    }

    public final class ViewHolder{
        public ImageView icon;
        public TextView text;
    }
}
