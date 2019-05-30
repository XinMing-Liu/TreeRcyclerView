package com.hongzhi.material.treerecyclerview.demo.Sort;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.bean.sort.TraceBackTreelItem;
import com.hongzhi.treerecyclerviewlib.base.ViewHolder;
import com.hongzhi.treerecyclerviewlib.item.TreeItem;

import static android.content.ContentValues.TAG;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 9:48
 */
public class SortChildItem extends TreeItem<TraceBackTreelItem> {
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder) {
        viewHolder.setText(R.id.tv_item_name, data.getMaterialsname());
        viewHolder.setText(R.id.tv_item_code, data.getBarcode());
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_sort_child;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, RecyclerView.LayoutParams layoutParams, int position) {
        super.getItemOffsets(outRect, layoutParams, position);
        outRect.top = 1;
    }

    @Override
    public void onClick(ViewHolder viewHolder) {
        super.onClick(viewHolder);
        Log.e(TAG, "onClick: " + viewHolder.getTextView(R.id.tv_item_name).getText() + getData().getBarcode());
    }
}
