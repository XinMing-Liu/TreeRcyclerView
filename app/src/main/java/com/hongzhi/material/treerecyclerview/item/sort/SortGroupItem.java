package com.hongzhi.material.treerecyclerview.item.sort;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.base.ViewHolder;
import com.hongzhi.material.treerecyclerview.demo.Sort.TraceBackTreeItemGroup;
import com.hongzhi.material.treerecyclerview.demo.Sort.TraceBackTreelItem;
import com.hongzhi.material.treerecyclerview.item.TreeSortItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 9:46
 */
public class SortGroupItem extends TreeSortItem {
    @Nullable
    @Override
    protected List<SortChildItem> initChildList(Object data) {
        ArrayList<SortChildItem> treeItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SortChildItem treelItem = new SortChildItem();
            TraceBackTreelItem treeItem = new TraceBackTreelItem("16010200051711020051",
                    "16010100381711020031",
                    "1601010038",
                    i + "===大拉光面丝",
                    "1.30HT",
                    "大拉",
                    "三车间");
            treelItem.setData(treeItem);

            treeItems.add(treelItem);

        }
        return treeItems;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_sort_group;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder) {
        if (isExpand()) {
        } else {

        }
        String materialsname = ((TraceBackTreeItemGroup) getData()).getMaterialsname();
        viewHolder.setText(R.id.tv_item_name, ((String) getSortKey())+"_"+materialsname);
    }

    @Override
    public void onClick(ViewHolder viewHolder) {
        super.onClick(viewHolder);
        if (isExpand()) {
//            viewHolder.setImageResource(R.id.iv_right, R.drawable.ic_keyboard_arrow_down_black_24dp);
//        } else {
//            viewHolder.setImageResource(R.id.iv_right, R.drawable.ic_keyboard_arrow_right_black_24dp);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, RecyclerView.LayoutParams layoutParams, int position) {
        super.getItemOffsets(outRect, layoutParams, position);
        outRect.top = 10;
        if (position == 0) {
            outRect.top = 0;
        }
    }
}
