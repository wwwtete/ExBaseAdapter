package com.chad.library.adapter.base.entity;

/**
 * 分组接口
 * Created by wangw on 2018/8/3.
 */

public interface ISection<T> {

    /**
     * 是否为Header
     * @return
     */
    boolean isHeader();

    /**
     * header标题
     * @return
     */
    String getTitle();

    /**
     * Item数据
     * @return
     */
    T getData();

}
