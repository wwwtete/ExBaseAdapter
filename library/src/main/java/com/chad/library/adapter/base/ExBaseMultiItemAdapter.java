package com.chad.library.adapter.base;

import android.support.annotation.IntRange;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by wangw on 2018/8/2.
 */
public abstract class ExBaseMultiItemAdapter<T extends MultiItemEntity> extends ExBaseAdapter<T> {

    private SparseArray<Class<? extends ExBaseViewHolder>> mVHs;

    private static final int DEFAULT_VIEW_TYPE = -0xff;
    public static final int TYPE_NOT_FOUND = -404;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExBaseMultiItemAdapter(List<T> data) {
        super(data);
    }

    @Override
    protected int getDefItemViewType(int position) {
        T item = mData.get(position);
        if (item != null) {
            return item.getItemType();
        }
        return DEFAULT_VIEW_TYPE;
    }

    protected void setDefaultViewTypeLayout(Class<? extends ExBaseViewHolder> layoutResId) {
        addItemType(DEFAULT_VIEW_TYPE, layoutResId);
    }

    @Override
    protected ExBaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getVHClass(viewType));
    }

    private Class<? extends ExBaseViewHolder> getVHClass(int viewType) {
        return mVHs.get(viewType, DefaultVH.class);
    }

    protected void addItemType(int type, Class<? extends ExBaseViewHolder> clz) {
        if (mVHs == null) {
            mVHs = new SparseArray<>();
        }
        mVHs.put(type, clz);
    }


    @Override
    public void remove(@IntRange(from = 0L) int position) {
        if (mData == null
                || position < 0
                || position >= mData.size()) return;

        T entity = mData.get(position);
        if (entity instanceof IExpandable) {
            removeAllChild((IExpandable) entity, position);
        }
        removeDataFromParent(entity);
        super.remove(position);
    }

    /**
     * 移除父控件时，若父控件处于展开状态，则先移除其所有的子控件
     *
     * @param parent         父控件实体
     * @param parentPosition 父控件位置
     */
    protected void removeAllChild(IExpandable parent, int parentPosition) {
        if (parent.isExpanded()) {
            List<MultiItemEntity> chidChilds = parent.getSubItems();
            if (chidChilds == null || chidChilds.size() == 0) return;

            int childSize = chidChilds.size();
            for (int i = 0; i < childSize; i++) {
                remove(parentPosition + 1);
            }
        }
    }

    /**
     * 移除子控件时，移除父控件实体类中相关子控件数据，避免关闭后再次展开数据重现
     *
     * @param child 子控件实体
     */
    protected void removeDataFromParent(T child) {
        int position = getParentPosition(child);
        if (position >= 0) {
            IExpandable parent = (IExpandable) mData.get(position);
            parent.getSubItems().remove(child);
        }
    }
}


