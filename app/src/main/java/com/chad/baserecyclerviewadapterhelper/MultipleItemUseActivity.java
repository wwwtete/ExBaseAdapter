package com.chad.baserecyclerviewadapterhelper;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.data.DataServer;
import com.chad.baserecyclerviewadapterhelper.entity.MultipleItem;
import com.chad.baserecyclerviewadapterhelper.viewholder.MultipleItemTextImgVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.MultipleItemImgVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.MultipleItemTextVH;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.ExBaseMultiItemAdapter;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 * modify by AllenCoder
 */
public class MultipleItemUseActivity extends BaseActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        setTitle("MultipleItem Use");
        setBackBtn();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        final ExBaseMultiItemAdapter<MultipleItem> multipleItemAdapter = new ExBaseMultiItemAdapter<MultipleItem>(data);

        //添加多类型支持
        multipleItemAdapter.addItemType(MultipleItem.TEXT, MultipleItemTextVH.class);
        multipleItemAdapter.addItemType(MultipleItem.IMG, MultipleItemImgVH.class);
        multipleItemAdapter.addItemType(MultipleItem.IMG_TEXT, MultipleItemTextImgVH.class);

        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }


}
