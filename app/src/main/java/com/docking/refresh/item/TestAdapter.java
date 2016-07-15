package com.docking.refresh.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by docking on 16/7/14 09:15.
 */
public class TestAdapter extends BaseAdapter {

    // 当前选中
    private int selectPostion = 0;

    private Holder mPreHolder = null;
    private Context mContext = null;
    private List<TestEntity> mList = null;

    public TestAdapter(Context context, List<TestEntity> list) {
        mContext = context;
        mList = list;
    }

    public void setSelectPostion(int postion) {
        selectPostion = postion;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return (null == mList ? null : mList.get(i));
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        if(null == view) {
            view = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout, null);
            holder = new Holder(view);
        } else {
            holder = (Holder) view.getTag();
        }

        onBindData(holder, position);

        return view;
    }

    private void onBindData(Holder holder, int position) {
        if(selectPostion == position) {
            mPreHolder = holder;
            holder.title.setSelected(true);
            holder.desc.setSelected(true);
        } else {
            holder.title.setSelected(false);
            holder.desc.setSelected(false);
        }
        TestEntity entity = mList.get(position);
        if(null != entity) {
            holder.title.setText("title = " + entity.getTitle());
            holder.desc.setText("title = " + entity.getDesc());
        }
    }

    /**
     * 重置View
     */
    private void resetView() {
        if(null != mPreHolder) {
            mPreHolder.title.setSelected(false);
            mPreHolder.desc.setSelected(false);
        }
    }

    /**
     * 刷新单个Item
     */
    public void refreshView(View view) {
        resetView();
        Holder holder = (Holder) view.getTag();
        if (null != holder) {
            mPreHolder = holder;
            holder.title.setSelected(true);
            holder.desc.setSelected(true);
        }
    }

    public static class Holder {
        ImageView iv;
        TextView title;
        TextView desc;
        public Holder(View view) {
            iv = (ImageView) view.findViewById(R.id.listview_item_iv);
            title = (TextView) view.findViewById(R.id.listview_item_title);
            desc = (TextView) view.findViewById(R.id.listview_item_desc);
            view.setTag(this);
        }
    }
}
