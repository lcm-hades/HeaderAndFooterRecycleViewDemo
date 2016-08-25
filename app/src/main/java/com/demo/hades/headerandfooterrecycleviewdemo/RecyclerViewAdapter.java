package com.demo.hades.headerandfooterrecycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Hades on 2016/8/25.
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdaptor<RecyclerView.ViewHolder> {


    public RecyclerViewAdapter(Context context, RecyclerView.Adapter adapter) {
        super(context, adapter);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
