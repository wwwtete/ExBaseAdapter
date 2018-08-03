package com.chad.library.adapter.base;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.chad.library.adapter.base.entity.ISection;

import java.util.List;

/**
 * Created by wangw on 2018/8/2.
 */

public class ExBaseSectionAdapter<T extends ISection> extends ExBaseAdapter<T> {
    protected static final int SECTION_HEADER_VIEW = 0x00000444;
    protected Class<? extends ExBaseViewHolder> mHeaderClz;
    public ExBaseSectionAdapter(Class<? extends ExBaseViewHolder> clz, Class<? extends ExBaseViewHolder> headerClz, @Nullable List<T> data) {
        super(clz, data);
        mHeaderClz = headerClz;
    }

    public ExBaseSectionAdapter(Class<? extends ExBaseViewHolder> clz, Class<? extends ExBaseViewHolder> headerClz) {
        super(clz);
        mHeaderClz = headerClz;
    }

    @Override
    protected int getDefItemViewType(int position) {
        return mData.get(position).isHeader() ? SECTION_HEADER_VIEW : 0;
    }

    @Override
    protected ExBaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SECTION_HEADER_VIEW)
            return createBaseViewHolder(parent,mHeaderClz);
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected boolean isFixedViewType(int type) {
        return super.isFixedViewType(type) || type == SECTION_HEADER_VIEW;
    }

    @Override
    public void onBindViewHolder(ExBaseViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case SECTION_HEADER_VIEW:
                setFullSpan(holder);
                convertHead(holder, getItem(position - getHeaderLayoutCount()));
                break;
            default:
                super.onBindViewHolder(holder, position);
                break;
        }
    }

    protected void convertHead(ExBaseViewHolder helper, T item){
        helper.onBindData(item);
    }


}
