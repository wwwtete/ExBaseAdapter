package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class ItemDragVH extends BaseVH<String> {
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.email)
    TextView mEmail;
    @BindView(R.id.iv)
    ImageView mIv;

    public ItemDragVH(ViewGroup parent) {
        super(parent, R.layout.item_draggable_view);
    }

    @Override
    protected void onBindData(String s) {
        switch (getLayoutPosition() %
                3) {
            case 0:
                mIvHead.setImageResource(R.mipmap.head_img0);
                break;
            case 1:
                mIvHead.setImageResource(R.mipmap.head_img1);
                break;
            case 2:
                mIvHead.setImageResource(R.mipmap.head_img2);
                break;
        }
        mTv.setText(s);
    }
}
