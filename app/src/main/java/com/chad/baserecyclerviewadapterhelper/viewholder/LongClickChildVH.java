package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;

/**
 * Created by wangw on 2018/8/3.
 */

public class LongClickChildVH extends BaseVH<ClickEntity> {
    public LongClickChildVH(ViewGroup parent) {
        super(parent, R.layout.item_long_click_childview);
        addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add)
                .addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add);
    }

    @Override
    protected void onBindData(ClickEntity clickEntity) {

    }
}
