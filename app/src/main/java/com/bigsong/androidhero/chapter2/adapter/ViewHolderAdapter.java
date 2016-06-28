package com.bigsong.androidhero.chapter2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigsong.androidhero.R;

import java.util.List;


/**
 * Created by BigSong on 16/6/26.
 */
public class ViewHolderAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<String> mData;

    public ViewHolderAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * viewHolder可以充分利用listview的视图缓存机制,避免了每次调用getview()的时候
     * 都通过findviewbyid来实例化控件
     * convertView判断是否缓存,没有的话通过LayoutInflator加载,然后setTag
     * 如果有缓存,直接getTag获取viewHolder
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.viewholder_item, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_item);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(mData.get(position));
        return convertView;
    }

    public final class ViewHolder {
        public ImageView img;
        public TextView title;
    }
}
