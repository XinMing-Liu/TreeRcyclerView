package com.hongzhi.material.treerecyclerview.bean.city;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.treerecyclerviewlib.base.ViewHolder;
import com.hongzhi.material.treerecyclerview.demo.city.ProvinceBean;
import com.hongzhi.treerecyclerviewlib.factory.ItemHelperFactory;
import com.hongzhi.treerecyclerviewlib.item.TreeItem;
import com.hongzhi.treerecyclerviewlib.item.TreeItemGroup;
import com.hongzhi.treerecyclerviewlib.manager.ItemManager;


import java.util.List;

/**
 * Created by baozi on 2016/12/8.
 *
 */
public class ProvinceItemParent extends TreeItemGroup<ProvinceBean> {


    @Override
    public List<TreeItem> initChildList(ProvinceBean data) {
        return ItemHelperFactory.createTreeItemList(data.getCitys(),CountyItemParent.class, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.itme_one;
    }

    @Override
    protected void onExpand() {
        ItemManager itemManager = getItemManager();
        if (itemManager != null) {
            int itemPosition = itemManager.getItemPosition(this);
            List datas = itemManager.getAdapter().getDatas();
            datas.addAll(itemPosition + 1, getExpandChild());
            itemManager.getAdapter().notifyItemRangeInserted(itemPosition + 1, getExpandChild().size());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder) {
        holder.setText(R.id.tv_content, data.getProvinceName());
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
