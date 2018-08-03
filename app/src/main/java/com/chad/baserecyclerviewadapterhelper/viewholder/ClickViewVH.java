package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;

/**
 * Created by wangw on 2018/8/3.
 */

public class ClickViewVH extends BaseVH<ClickEntity> {
    public ClickViewVH(ViewGroup parent) {
        super(parent, R.layout.item_click_view);
        addOnClickListener(R.id.btn);
    }

    @Override
    protected void onBindData(ClickEntity clickEntity) {

    }
}
