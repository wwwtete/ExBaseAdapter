package com.chad.library.adapter.base.util;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.chad.library.adapter.base.ExBaseViewHolder;
import com.chad.library.adapter.base.DefaultVH;

import java.util.List;

import static com.chad.library.adapter.base.BaseMultiItemQuickAdapter.TYPE_NOT_FOUND;

/**
 * help you to achieve multi type easily
 * <p>
 * Created by tysheng
 * Date: 2017/4/6 08:41.
 * Email: tyshengsx@gmail.com
 * <p>
 * <p>
 * more information: https://github.com/CymChad/BaseRecyclerViewAdapterHelper/issues/968
 */

public abstract class MultiTypeDelegate<T> {

    private static final int DEFAULT_VIEW_TYPE = -0xff;
    private SparseIntArray layouts;
    private SparseArray<Class<? extends ExBaseViewHolder>> mVHs;
    private boolean autoMode, selfMode;

    public MultiTypeDelegate(SparseIntArray layouts) {
        this.layouts = layouts;
    }

    public MultiTypeDelegate(SparseArray<Class<? extends ExBaseViewHolder>> vhs) {
        mVHs = vhs;
    }

    public MultiTypeDelegate() {
    }

    public final int getDefItemViewType(List<T> data, int position) {
        T item = data.get(position);
        return item != null ? getItemType(item) : DEFAULT_VIEW_TYPE;
    }

    /**
     * get the item type from specific entity.
     *
     * @param t entity
     * @return item type
     */
    protected abstract int getItemType(T t);

    public final int getLayoutId(int viewType) {
        return this.layouts.get(viewType, TYPE_NOT_FOUND);
    }

    public final Class<? extends ExBaseViewHolder> getVHClass(int viewType) {
        if (mVHs != null)
            return this.mVHs.get(viewType,DefaultVH.class);
        return null;
    }

    private void addItemType(int type, @LayoutRes int layoutResId) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(type, layoutResId);
    }

    private void addItemType(int type, Class<? extends ExBaseViewHolder> clz) {
        if (this.mVHs == null) {
            this.mVHs = new SparseArray<>();
        }
        this.mVHs.put(type, clz);
    }

    /**
     * auto increase type vale, start from 0.
     *
     * @param layoutResIds layout id arrays
     * @return MultiTypeDelegate
     */
    @Deprecated
    public MultiTypeDelegate registerItemTypeAutoIncrease(@LayoutRes int... layoutResIds) {
        autoMode = true;
        checkMode(selfMode);
        for (int i = 0; i < layoutResIds.length; i++) {
            addItemType(i, layoutResIds[i]);
        }
        return this;
    }

    public MultiTypeDelegate registerItemTypeAutoIncrease(Class<? extends ExBaseViewHolder>... clzs) {
        autoMode = true;
        checkMode(selfMode);
        for (int i = 0; i < clzs.length; i++) {
            addItemType(i, clzs[i]);
        }
        return this;
    }

    /**
     * set your own type one by one.
     *
     * @param type        type value
     * @param layoutResId layout id
     * @return MultiTypeDelegate
     */
    @Deprecated
    public MultiTypeDelegate registerItemType(int type, @LayoutRes int layoutResId) {
        selfMode = true;
        checkMode(autoMode);
        addItemType(type, layoutResId);
        return this;
    }

    public MultiTypeDelegate registerItemType(int type, Class<? extends ExBaseViewHolder> clz) {
        selfMode = true;
        checkMode(autoMode);
        addItemType(type, clz);
        return this;
    }

    private void checkMode(boolean mode) {
        if (mode) {
            throw new RuntimeException("Don't mess two register mode");
        }
    }
}
