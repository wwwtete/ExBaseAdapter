package com.chad.baserecyclerviewadapterhelper.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.data.DataServer;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.chad.baserecyclerviewadapterhelper.entity.Status;
import com.chad.baserecyclerviewadapterhelper.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.ExBaseAdapter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 * Created by wangw on 2018/8/3.
 */

public class NestClickVH extends BaseVH<ClickEntity> implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.nest_list)
    RecyclerView mNestList;
    @BindView(R.id.item_click)
    RelativeLayout mItemClick;

    public NestClickVH(ViewGroup parent) {
        super(parent, R.layout.item_nest_click);
        setNestView(R.id.item_click); // u can set nestview id
        mNestList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mNestList.setHasFixedSize(true);

        ExBaseAdapter<Status> nestAdapter = new ExBaseAdapter<Status>(NestVH.class, DataServer.getSampleData(20));
        nestAdapter.setOnItemClickListener(this);
        nestAdapter.setOnItemChildClickListener(this);
        mNestList.setAdapter(nestAdapter);
    }

    @Override
    protected void onBindData(ClickEntity clickEntity) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(Utils.getContext(), "childView click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Logger.d("嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次");
        Toast.makeText(Utils.getContext(), "嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次", Toast.LENGTH_SHORT).show();
    }
}
