package com.hongzhi.material.treerecyclerview.demo.Sort;

import android.support.annotation.NonNull;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.bean.sort.TraceBackTreelItem;
import com.hongzhi.treerecyclerviewlib.base.ViewHolder;
import com.hongzhi.treerecyclerviewlib.item.TreeItem;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 11:11
 */
public class SwipeSortItem extends TreeItem<TraceBackTreelItem> {
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder) {
        viewHolder.setText(R.id.tv_item_name, getData().getMaterialsname());
        viewHolder.setText(R.id.tv_item_code, getData().getBarcode());
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_sort_child;
    }

}
