package com.chad.baserecyclerviewadapterhelper.viewholder;

import androidx.cardview.widget.CardView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MySection;
import com.chad.baserecyclerviewadapterhelper.entity.Video;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/2.
 */

public class SetionItemVH extends BaseVH<MySection> {

    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.card_view)
    CardView mCardView;

    public SetionItemVH(ViewGroup parent) {
        super(parent, R.layout.item_section_content);
    }

    @Override
    protected void onBindData(MySection item) {
        Video video = (Video) item.getData();
        switch (getLayoutPosition() %
                2) {
            case 0:
                mIv.setImageResource(R.mipmap.m_img1);
                break;
            case 1:
                mIv.setImageResource(R.mipmap.m_img2);
                break;

        }
        mTv.setText(video.getName());
    }
}
