package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.ViewGroup;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MySection;
import com.chad.library.adapter.base.ExBaseViewHolder;

/**
 * Created by wangw on 2018/8/2.
 */

public class SetionHeaderVH extends ExBaseViewHolder<MySection> {
    public SetionHeaderVH(ViewGroup parent) {
        super(parent, R.layout.def_section_head);
    }

    @Override
    protected void onBindData(MySection item) {
        setText(R.id.header, item.getTitle());
        setVisible(R.id.more, item.isMore());
        addOnClickListener(R.id.more);

    }
}
