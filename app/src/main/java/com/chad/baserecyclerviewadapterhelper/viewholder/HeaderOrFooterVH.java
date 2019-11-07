package com.chad.baserecyclerviewadapterhelper.viewholder;

import androidx.cardview.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Status;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class HeaderOrFooterVH extends BaseVH<Status> {
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.card_view)
    CardView mCardView;

    public HeaderOrFooterVH(ViewGroup parent) {
        super(parent, R.layout.item_header_and_footer);
    }

    @Override
    protected void onBindData(Status status) {
        switch (getLayoutPosition()%
                3){
            case 0:
                mIv.setImageResource(R.mipmap.animation_img1);
                break;
            case 1:
                mIv.setImageResource(R.mipmap.animation_img2);
                break;
            case 2:
                mIv.setImageResource(R.mipmap.animation_img3);
                break;
        }
    }
}
