package com.chad.baserecyclerviewadapterhelper.viewholder;

import androidx.cardview.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MultipleItem;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class MultipleItemTextImgVH extends BaseVH<MultipleItem> {


    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.card_view)
    CardView mCardView;

    public MultipleItemTextImgVH(ViewGroup parent) {
        super(parent, R.layout.item_img_text_view);

    }

    @Override
    protected void onBindData(MultipleItem item) {
        switch (getLayoutPosition() %
                2) {
            case 0:
                mIv.setImageResource(R.mipmap.animation_img1);
                break;
            case 1:
                mIv.setImageResource(R.mipmap.animation_img2);
                break;

        }
    }
}
