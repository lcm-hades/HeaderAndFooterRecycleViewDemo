package com.demo.hades.headerandfooterrecycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hades on 2016/8/25.
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdaptor {

    private Context mContext;
    private List<String> mListData;

    public RecyclerViewAdapter(Context context, List<String> list){
        mListData = list;
        mContext = context;
    }

    @Override
    protected RecyclerView.ViewHolder onCreate(ViewGroup viewGroup, int itemtype) {
        ViewHolder holder = ViewHolder.createViewHolder(mContext, viewGroup, R.layout.data_item);

        return holder;
    }

    @Override
    protected void onRealBindViewHolder(RecyclerView.ViewHolder viewHolder, int pos) {
        TextView tv = ((ViewHolder)viewHolder).getView(R.id.tv);
        tv.setText("aaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Override
    protected int getRealItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    protected int getRealItemViewType(int pos) {
        return 0;
    }



}
