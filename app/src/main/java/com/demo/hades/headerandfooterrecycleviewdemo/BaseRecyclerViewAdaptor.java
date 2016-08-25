package com.demo.hades.headerandfooterrecycleviewdemo;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hades on 2016/8/24.
 */
public abstract class BaseRecyclerViewAdaptor<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected static final int ITEM_NORMAL = 0;
    protected static final int ITEM_HEADER = 1000;
    protected static final int ITEM_FOOTER = 2000;



    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();

    private RecyclerView.Adapter mInnerAdapter;

    private boolean isHeaderViewPos(int position){
        return position < getHeadersCount();
    }

    private boolean isFooterViewPos(int position){
        return position >= getFootersCount();
    }

    public void addHeaderView(View view){
        mHeaderViews.put(mHeaderViews.size() + ITEM_HEADER, view);
    }

    public void addFooterView(View view){
        mFooterViews.put(mFooterViews.size() + ITEM_FOOTER, view);
    }

    public int getHeadersCount(){
        return mHeaderViews.size();
    }

    public int getFootersCount(){
        return mFooterViews.size();
    }


    protected abstract RecyclerView.ViewHolder onCreate(ViewGroup viewGroup, int itemtype);
    protected abstract void onRealBindViewHolder(RecyclerView.ViewHolder viewHolder, int pos);
    protected abstract int getRealItemCount();
    protected abstract int getRealItemViewType(int pos);

    /**
     *
     * @param viewGroup
     * @param i itemtype
     * @return
     */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        if (mHeaderViews.get(i) != null){
            ViewHolder holder = ViewHolder.createViewHolder(viewGroup.getContext(), mHeaderViews.get(i));
            return holder;
        }else if (mFooterViews.get(i) != null){
            ViewHolder holder = ViewHolder.createViewHolder(viewGroup.getContext(), mFooterViews.get(i));
            return holder;
        }

        return onCreate(viewGroup, i);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderViewPos(position)){
            return mHeaderViews.keyAt(position);
        }else if (isFooterViewPos(position)){
            return mFooterViews.keyAt(position - getHeadersCount() -getRealItemCount());
        }

        return getRealItemViewType(position - getHeadersCount());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isHeaderViewPos(i) || isFooterViewPos(i)){
            return;
        }
        onRealBindViewHolder(viewHolder, i - getHeadersCount());
    }

    @Override
    public int getItemCount() {
        return getHeadersCount() + getFootersCount() + getRealItemCount();
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

        if (layoutManager instanceof GridLayoutManager){
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup oldLookup = gridLayoutManager.getSpanSizeLookup();

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    if (mHeaderViews.get(viewType) != null){
                        return gridLayoutManager.getSpanCount();
                    }else if (mFooterViews.get(viewType) != null){
                        return gridLayoutManager.getSpanCount();
                    }
                    if (oldLookup != null){
                        return oldLookup.getSpanSize(position);
                    }
                    return 1;
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position = holder.getLayoutPosition();
        if (isHeaderViewPos(position) || isFooterViewPos(position))
        {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp != null
                    && lp instanceof StaggeredGridLayoutManager.LayoutParams)
            {
                StaggeredGridLayoutManager.LayoutParams p =
                        (StaggeredGridLayoutManager.LayoutParams) lp;
                p.setFullSpan(true);
            }
        }
    }
}
