package com.hongzhi.material.treerecyclerview.item.city;

import android.graphics.Rect;
import android.support.annotation.NonNull;


import android.support.v7.widget.RecyclerView;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.base.ViewHolder;
import com.hongzhi.material.treerecyclerview.demo.city.ProvinceBean;
import com.hongzhi.material.treerecyclerview.factory.ItemHelperFactory;
import com.hongzhi.material.treerecyclerview.item.TreeItem;
import com.hongzhi.material.treerecyclerview.item.TreeItemGroup;

import java.util.List;

/**
 */
public class CountyItemParent extends TreeItemGroup<ProvinceBean.CityBean> {

    @Override
    public List<TreeItem> initChildList(ProvinceBean.CityBean data) {
        return ItemHelperFactory.createItems(data.getAreas(),  this);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_two;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder) {
        holder.setText(R.id.tv_content, data.getCityName());
    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, RecyclerView.LayoutParams layoutParams, int position) {
        super.getItemOffsets(outRect, layoutParams, position);
        outRect.top = 5;
        if (position == 0) {
            outRect.top = 0;
        }
    }
}
