package com.gui.ggtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gui.ggtest.R;
import com.gui.ggtest.activity.ChooseCityActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GGG on 2017/10/11.
 */

public class CityChooseRecyclerAdapter extends RecyclerView.Adapter{

    public static final int ITEM_HEAD = 0;
    public static final int ITEM_CONTENT = 1;


    private LayoutInflater mInflater;
    public Context mContext;
    public List<Map<String,String>> dataList = new ArrayList<>();
    public List<Integer> numList = new ArrayList<>();
    public List<String> indexList = new ArrayList<>();

    public CityChooseRecyclerAdapter(Context context, Map<String, Object> datas){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        List<String> indexList = new ArrayList(datas.keySet());
        for (String string : indexList) {
            numList.add(dataList.size());
            Map<String,String> headMap = new HashMap<>();
            headMap.put("type","head");
            headMap.put("name",string);
            dataList.add(headMap);
            List<Map<String, String>> templist = (List<Map<String, String>>) datas.get(string);
            dataList.addAll(templist);
        }
        this.indexList = indexList;
    }

    @Override
    public int getItemViewType(int position) {
        Map<String,String> item = dataList.get(position);
        if (TextUtils.isEmpty(item.get("type"))){
            return ITEM_CONTENT;
        }else if ("head".equals(item.get("type"))){
            return ITEM_HEAD;
        }else{
            return ITEM_CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case ITEM_HEAD:
                viewHolder = new CityChooseGridRViewHolder(mInflater.inflate(R.layout.item_grid_title, null,false));
                break;
            case ITEM_CONTENT:
                viewHolder = new CityChooseGridRViewHolder(mInflater.inflate(R.layout.item_grid_textvie, null,false));
                break;
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CityChooseGridRViewHolder cityChooseViewHolder = (CityChooseGridRViewHolder)holder;
        final Map<String,String> item = dataList.get(position);
        cityChooseViewHolder.tv_name.setText(item.get("name"));
        cityChooseViewHolder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItemViewType(position)==ITEM_CONTENT){
                    ((ChooseCityActivity)mContext).selectCity(item.get("id"),item.get("name"));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    private class CityChooseGridRViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_name;
        public CityChooseGridRViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public int getIndexPosition(String s){
        try{
            return numList.get(indexList.indexOf(s));
        }catch (Exception e){
            return 0;
        }
    }
}
