package com.example.cjcucsie.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 项目名称：ItemUpdataRecyclerView
 * 创建人：Double2号
 * 创建时间：2016/6/8 11:00
 * 修改备注：
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public ArrayList<String> data;
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView;
        public Button myButton ;
        public ViewHolder(View v)
        {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.tv_item);
            myButton = (Button) v.findViewById(R.id.button);
        }
    }
    public MyAdapter(ArrayList<String>  data){
        this.data=data;
    }
    public void add_new_task(String s)
    {
        data.add(s);
        notifyDataSetChanged();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position)
    {
        holder.mTextView.setText(data.get(position));
        holder.myButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                data.remove(data.get(position));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}