package com.chad.library.adapter.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.R;

/**
 * Created by wangw on 2018/8/2.
 */

public class DefaultVH extends ExBaseViewHolder<Object> {

    public DefaultVH(ViewGroup group) {
        super(group);
    }

    public DefaultVH(ViewGroup group,Exception error) {
        super(group, R.layout.item_default_vh);
        if (error != null) {
            TextView tv = itemView.findViewById(R.id.tv_hint);
            tv.setText(tv.getText()+error.toString());
        }
    }

    @Override
    protected void onBindData(Object o) {
    }
}
