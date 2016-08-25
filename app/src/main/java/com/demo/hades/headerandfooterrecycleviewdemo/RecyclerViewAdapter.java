package com.demo.hades.headerandfooterrecycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Hades on 2016/8/25.
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdaptor {


    @Override
    protected RecyclerView.ViewHolder onCreate(ViewGroup viewGroup, int itemtype) {

        return null;
    }

    @Override
    protected void onRealBindViewHolder(RecyclerView.ViewHolder viewHolder, int pos) {

    }

    @Override
    protected int getRealItemCount() {
        return 0;
    }

    @Override
    protected int getRealItemViewType(int pos) {
        return 0;
    }

}
