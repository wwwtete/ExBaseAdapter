package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;

/**
 * Created by wangw on 2018/8/3.
 */

public class LongClickViewVH extends BaseVH<ClickEntity> {

    public LongClickViewVH(ViewGroup parent) {
        super(parent, R.layout.item_long_click_view);
        addOnLongClickListener(R.id.btn);
    }

    @Override
    protected void onBindData(ClickEntity clickEntity) {

    }
}
