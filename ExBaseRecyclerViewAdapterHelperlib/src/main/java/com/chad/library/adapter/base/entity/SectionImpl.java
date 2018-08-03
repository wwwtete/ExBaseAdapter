package com.chad.library.adapter.base.entity;

/**
 * 分组接口的包装类
 * Created by wangw on 2018/8/3.
 */

public class SectionImpl<T> implements ISection<T> {

    protected String mTitle;
    protected T mData;
    protected boolean mIsHeader = false;

    public SectionImpl(boolean isHeader,String title) {
        mTitle = title;
        mIsHeader = isHeader;
    }

    public SectionImpl(T data) {
        mData = data;
    }

    @Override
    public boolean isHeader() {
        return mIsHeader;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public T getData() {
        return mData;
    }
}
