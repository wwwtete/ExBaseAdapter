package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MultipleItem;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class MultipleItemImgVH extends BaseVH<MultipleItem> {


    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.card_view)
    CardView mCardView;

    public MultipleItemImgVH(ViewGroup parent) {
        super(parent, R.layout.item_image_view);

    }

    @Override
    protected void onBindData(MultipleItem item) {
    }
}
