package com.chad.baserecyclerviewadapterhelper;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity;
import com.chad.baserecyclerviewadapterhelper.viewholder.ClickChildVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.ClickViewVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.LongClickChildVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.LongClickViewVH;
import com.chad.baserecyclerviewadapterhelper.viewholder.NestClickVH;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.ExBaseMultiItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemClickActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ExBaseMultiItemAdapter<ClickEntity> adapter;
    private static final int PAGE_SIZE = 10;
    private static String TAG = "ItemClickActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("ItemClickActivity Activity");
        setContentView(R.layout.activity_item_click);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
/**
 * you can also use this way to solve your click Event
 */
//        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
//            /**
//             * Callback method to be invoked when an item in this AdapterView has
//             * been clicked.
//             *
//             * @param view     The view within the AdapterView that was clicked (this
//             *                 will be a view provided by the mAdapter)
//             * @param position The position of the view in the mAdapter.
//             */
//            @Override
//            public void onSimpleItemClick(final BaseQuickAdapter mAdapter, final View view, final int position) {
//                Log.d(TAG, "SimpleOnItemClick: ");
//
//            }
//            /**
//             * callback method to be invoked when an chidview in this view has been
//             * click and held
//             *
//             * @param view     The view whihin the AbsListView that was clicked
//             * @param position The position of the view int the mAdapter
//             * @return true if the callback consumed the long click ,false otherwise
//             */
//            @Override
//            public void onItemChildClick(BaseQuickAdapter mAdapter, View view, int position) {
//                Logger.d("onItemChildClick "+position+" be click");
//                Toast.makeText(ItemClickActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
//
//            }
//
//            /**
//             * Callback method to be invoked when an item in this view has been clicked and held.
//             * @param mAdapter
//             * @param view
//             * @param position
//             */
//            @Override
//            public void onItemLongClick(final BaseQuickAdapter mAdapter, final View view, final int position) {
//                Toast.makeText(ItemClickActivity.this, "onItemLongClick" + position, Toast.LENGTH_SHORT).show();
//            }
//            /**
//             * Callback method to be invoked when an itemchild in this view has been clicked and held.
//             * @param mAdapter
//             * @param view
//             * @param position
//             */
//            @Override
//            public void onItemChildLongClick(final BaseQuickAdapter mAdapter, final View view, final int position) {
//                Toast.makeText(ItemClickActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    private void initAdapter() {
        List<ClickEntity> data = new ArrayList<>();
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW));

        adapter = new ExBaseMultiItemAdapter<>(data);
        adapter.addItemType(ClickEntity.CLICK_ITEM_VIEW, ClickViewVH.class);
        adapter.addItemType(ClickEntity.CLICK_ITEM_CHILD_VIEW, ClickChildVH.class);
        adapter.addItemType(ClickEntity.LONG_CLICK_ITEM_VIEW, LongClickViewVH.class);
        adapter.addItemType(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, LongClickChildVH.class);
        adapter.addItemType(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, NestClickVH.class);


        adapter.openLoadAnimation();
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

}
