package com.chad.baserecyclerviewadapterhelper.viewholder;

import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.MySection;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/2.
 */

public class SetionHeaderVH extends BaseVH<MySection> {

    @BindView(R.id.header)
    TextView mHeader;
    @BindView(R.id.more)
    TextView mMore;
    @BindView(R.id.card_view)
    CardView mCardView;

    public SetionHeaderVH(ViewGroup parent) {
        super(parent, R.layout.def_section_head);
        addOnClickListener(R.id.more);
    }

    @Override
    protected void onBindData(MySection item) {
        mHeader.setText(item.getTitle());
        mMore.setVisibility(item.isMore() ? View.VISIBLE : View.INVISIBLE);
    }
}
