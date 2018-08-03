package com.chad.library.adapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 抽象的ViewHolder，子类必须实现这个类，不能直接使用抽象类来使用
 *
 * 注意：子类必须有一个 <init>(ViewGroup parent) 的构造函数
 * 注意：子类必须有一个 <init>(ViewGroup parent) 的构造函数
 * 注意：子类必须有一个 <init>(ViewGroup parent) 的构造函数
 *
 * Created by wangw on 2018/8/2.
 */

public abstract class ExBaseViewHolder<T> extends BaseViewHolder {

    protected T mData;

    public ExBaseViewHolder(ViewGroup parent, int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId,parent,false));
    }

    public ExBaseViewHolder(View view) {
        super(view);
    }

    public final void bindData(T t){
        mData = t;
        onBindData(t);
    }

    protected abstract void onBindData(T t);


}
