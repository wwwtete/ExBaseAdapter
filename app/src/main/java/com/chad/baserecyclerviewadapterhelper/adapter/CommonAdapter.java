package com.chad.baserecyclerviewadapterhelper.adapter;

import com.chad.baserecyclerviewadapterhelper.data.DataServer;
import com.chad.baserecyclerviewadapterhelper.entity.Status;
import com.chad.baserecyclerviewadapterhelper.viewholder.AnimationVH;
import com.chad.library.adapter.base.ExBaseAdapter;

/**
 * 如果多个地方用到同一个Adapter和ViewHolder，可以直接在Adapter中构造函数中写死ViewHolder
 * Created by wangw on 2018/8/3.
 */

public class CommonAdapter extends ExBaseAdapter<Status> {
    public CommonAdapter(int dataSize) {
        super(AnimationVH.class, DataServer.getSampleData(dataSize));
    }
}
