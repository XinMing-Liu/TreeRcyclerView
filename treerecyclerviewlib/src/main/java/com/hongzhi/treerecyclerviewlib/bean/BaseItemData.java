package com.hongzhi.treerecyclerviewlib.bean;

import android.support.annotation.Keep;

/**
 * javabean继承该类,后台返回的json中可以包含viewItemType,通过解析返回的viewItemType确定item样式
 * @Author XinMing-Liu
 * @create 2019/5/29 9:01
 */
@Keep
@Deprecated
public abstract class BaseItemData {

    private int viewItemType;

    public void setViewItemType(int viewItemType) {
        this.viewItemType = viewItemType;
    }

    public int getViewItemType() {
        return viewItemType;
    }
}

