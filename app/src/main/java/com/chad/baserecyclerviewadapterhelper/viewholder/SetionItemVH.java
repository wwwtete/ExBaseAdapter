package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MySection;
import com.chad.baserecyclerviewadapterhelper.entity.Video;
import com.chad.library.adapter.base.ExBaseViewHolder;

/**
 * Created by wangw on 2018/8/2.
 */

public class SetionItemVH extends ExBaseViewHolder<MySection> {

    public SetionItemVH(ViewGroup parent) {
        super(parent, R.layout.item_section_content);
    }

    @Override
    protected void onBindData(MySection item) {
        Video video = (Video) item.getData();
        switch (getLayoutPosition() %
                2) {
            case 0:
                setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                setImageResource(R.id.iv, R.mipmap.m_img2);
                break;

        }
        setText(R.id.tv, video.getName());
    }
}
