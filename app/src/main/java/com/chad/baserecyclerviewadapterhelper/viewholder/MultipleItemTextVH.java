package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MultipleItem;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class MultipleItemTextVH extends BaseVH<MultipleItem> {
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.tv1)
    TextView mTv1;
    @BindView(R.id.card_view)
    CardView mCardView;

    public MultipleItemTextVH(ViewGroup parent) {
        super(parent, R.layout.item_text_view);
    }

    @Override
    protected void onBindData(MultipleItem item) {
        mTv.setText(item.getContent());
    }
}
