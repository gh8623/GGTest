package com.gui.ggtest;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GGG on 2017/9/6.
 */

public class MyAdapter<T> extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    //数据集合
    public Context mContext;
    private List<T> datas;
    public MyAdapter(Context activity) {
        this.mContext = activity;
        this.datas = new ArrayList<T>();
    }
    /**
     * add object into list
     */
    public void addObject(T t) {
        datas.add(t);
    }

    /**
     * reset list
     */
    public void addAll(List<T> list) {
        datas.clear();
        datas.addAll(list);
        System.out.println(list.size());
    }

    /**
     * remove item
     */
    public void remove(int position) {
        datas.remove(position);
    }

    /**
     * get item by position
     */
    public T getObject(int position) {
        return datas.get(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.recycleview_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.tv.setText((String)datas.get(position));
    }


    @Override
    public int getItemCount()
    {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }
}