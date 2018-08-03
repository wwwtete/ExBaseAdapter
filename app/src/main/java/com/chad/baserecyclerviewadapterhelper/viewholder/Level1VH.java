package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Level1Item;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class Level1VH extends BaseVH<MultiItemEntity> {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.sub_title)
    TextView mSubTitle;
    @BindView(R.id.iv)
    ImageView mIv;

    public Level1VH(ViewGroup parent) {
        super(parent, R.layout.item_expandable_lv1);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                final Level1Item lv1 = (Level1Item) mData;
                if (lv1.isExpanded()) {
                    mAdapter.collapse(pos, false);
                } else {
                    mAdapter.expand(pos, false);
                }
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = getAdapterPosition();
                mAdapter.remove(pos);
                return true;
            }
        });
    }

    @Override
    protected void onBindData(MultiItemEntity item) {
        final Level1Item lv1 = (Level1Item) item;
        mTitle.setText(lv1.title);
                mSubTitle.setText(lv1.subTitle);
                mIv.setImageResource( lv1.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);


    }
}
