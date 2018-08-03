package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.entity.Person;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class PersonVH extends BaseVH<MultiItemEntity> {
    @BindView(R.id.tv)
    TextView mTv;

    public PersonVH(ViewGroup parent) {
        super(parent, R.layout.item_expandable_lv2);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                mAdapter.remove(pos);
            }
        });
    }

    @Override
    protected void onBindData(MultiItemEntity multiItemEntity) {
        Person person = (Person) multiItemEntity;
        mTv.setText(person.name + " parent pos: " + mAdapter.getParentPosition(person));

    }
}
