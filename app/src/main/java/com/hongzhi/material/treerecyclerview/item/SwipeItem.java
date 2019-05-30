package com.hongzhi.material.treerecyclerview.item;

import android.support.annotation.NonNull;
import com.hongzhi.material.treerecyclerview.base.ViewHolder;
import com.hongzhi.material.treerecyclerview.widget.swipe.SwipeItemMangerInterface;
import com.hongzhi.material.treerecyclerview.widget.swipe.SwipeLayout;

/**
 *  * 实现该接口,侧滑删除
 * @Author XinMing-Liu
 * @create 2019/5/29 9:54
 */
public interface SwipeItem {
    int getSwipeLayoutId();

    SwipeLayout.DragEdge getDragEdge();

    void onBindSwipeView(@NonNull ViewHolder viewHolder, int position, SwipeItemMangerInterface swipeManger);

    void openCallback();
}

