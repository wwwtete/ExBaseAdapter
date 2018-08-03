package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.ExBaseViewHolder;

import butterknife.ButterKnife;

/**
 * Created by wangw on 2018/8/3.
 */

public abstract class BaseVH<T> extends ExBaseViewHolder<T> {
    public BaseVH(ViewGroup parent, int resId) {
        super(parent, resId);
        ButterKnife.bind(this,itemView);
    }

    public BaseVH(View view) {
        super(view);
        ButterKnife.bind(this,itemView);
    }

    protected Context getContext() {
        return itemView.getContext();
    }
}
