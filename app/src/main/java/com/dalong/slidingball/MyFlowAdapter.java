package com.dalong.slidingball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


import com.dalong.francyconverflow.FlowGallery;
import com.dalong.francyconverflow.FlowAdapter;

import java.util.List;


public class MyFlowAdapter extends FlowAdapter {
    private Context mContext;

    public List<FlowItem> list;

    public MyFlowAdapter(Context context, List<FlowItem> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public View getCoverFlowItem(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gallery_item, null);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            convertView.setLayoutParams(new FlowGallery.LayoutParams(width / 3, width / 2));//FlowGallery.LayoutParams.WRAP_CONTENT));
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final FlowItem item = getItem(position);
        holder.textView.setText(item.getName());
        return convertView;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public FlowItem getItem(int i) {
        return list.get(i % list.size());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        TextView textView;
    }
}
