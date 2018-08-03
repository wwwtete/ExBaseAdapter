package com.chad.library.adapter.base;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.util.MultiTypeDelegate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by wangw on 2018/8/2.
 */

public class ExBaseAdapter<T> extends BaseQuickAdapter<T,ExBaseViewHolder> {

    protected Class<? extends ExBaseViewHolder> mClz;

    public ExBaseAdapter(Class<? extends ExBaseViewHolder> clz, @Nullable List<T> data) {
        super(0, data);
        mClz = clz;
    }

    public ExBaseAdapter(Class<? extends ExBaseViewHolder> clz) {
        super(null);
        mClz = clz;
    }

    public ExBaseAdapter(MultiTypeDelegate<T> multiTypeDelegate){
        super(null);
        mMultiTypeDelegate = multiTypeDelegate;
    }

    protected ExBaseAdapter(@Nullable List<T> data) {
        super(null);
    }

    @Override
    protected ExBaseViewHolder createBaseViewHolder(View view) {
        return createBaseViewHolder((ViewGroup) view,DefaultVH.class);
    }

    protected ExBaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        Class<? extends ExBaseViewHolder> clz = mClz;
        if (mMultiTypeDelegate != null) {
            clz = mMultiTypeDelegate.getVHClass(viewType);
        }
        return createBaseViewHolder(parent,clz);
    }

    protected ExBaseViewHolder createBaseViewHolder(ViewGroup parent, Class<? extends ExBaseViewHolder> clz) {
        if (clz != null) {
            try {
                Constructor<? extends ExBaseViewHolder> constructor = clz.getDeclaredConstructor(ViewGroup.class);
                constructor.setAccessible(true);
                return constructor.newInstance(parent);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return new DefaultVH(parent);
    }

    @Override
    protected void convert(ExBaseViewHolder helper, T item) {
        helper.bindData(item);
    }
}
