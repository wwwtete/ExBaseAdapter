package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Level0Item;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class Level0VH extends BaseVH<MultiItemEntity> {
    private static final String TAG = "Level0VH";
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.sub_title)
    TextView mSubTitle;
    @BindView(R.id.iv)
    ImageView mIv;

    public Level0VH(ViewGroup parent) {
        super(parent, R.layout.item_expandable_lv0);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                Log.d(TAG, "Level 0 item pos: " + pos);
                final Level0Item lv0 = (Level0Item) mData;
                if (lv0.isExpanded()) {
                    mAdapter.collapse(pos);
                } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                    mAdapter.expand(pos);
//                            }
                }
            }
        });
    }

    @Override
    protected void onBindData(MultiItemEntity item) {
        switch (getLayoutPosition() %
                3) {
            case 0:
                mIvHead.setImageResource(R.mipmap.head_img0);
                break;
            case 1:
                mIvHead.setImageResource( R.mipmap.head_img1);
                break;
            case 2:
                mIvHead.setImageResource(R.mipmap.head_img2);
                break;
        }
        final Level0Item lv0 = (Level0Item) mData;
        mTitle.setText(lv0.title);
                mSubTitle.setText( lv0.subTitle);
                mIv.setImageResource(lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);

    }
}
