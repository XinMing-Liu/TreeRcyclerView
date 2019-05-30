package com.hongzhi.material.treerecyclerview.bean.sort;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.demo.Sort.SortChildItem;
import com.hongzhi.treerecyclerviewlib.base.ViewHolder;
import com.hongzhi.treerecyclerviewlib.item.SwipeItem;
import com.hongzhi.treerecyclerviewlib.widget.swipe.SwipeItemMangerInterface;
import com.hongzhi.treerecyclerviewlib.widget.swipe.SwipeLayout;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 9:47
 */
public class SwipeSortItem extends SortChildItem implements SwipeItem {
    @Override
    public int getSwipeLayoutId() {
        return R.layout.layout_delete;
    }

    @Override
    public SwipeLayout.DragEdge getDragEdge() {
        return SwipeLayout.DragEdge.Right;
    }

    @Override
    public void onBindSwipeView(@NonNull ViewHolder viewHolder, int position, final SwipeItemMangerInterface swipeManger) {
        viewHolder.setOnClickListener(R.id.tv_delete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "删除", Toast.LENGTH_SHORT).show();
                swipeManger.closeAllItems();
            }
        });
    }

    @Override
    public void openCallback() {

    }
    @Override
    public void onClick(ViewHolder viewHolder) {
        super.onClick(viewHolder);
    }
}
