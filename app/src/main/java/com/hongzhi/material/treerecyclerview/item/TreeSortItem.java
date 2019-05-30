package com.hongzhi.material.treerecyclerview.item;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 9:47
 */
public abstract class TreeSortItem<T> extends TreeItemGroup<T> {
    protected Object sortKey;

    public void setSortKey(Object sortKey) {
        this.sortKey = sortKey;
    }

    public Object getSortKey() {
        return sortKey;
    }

}