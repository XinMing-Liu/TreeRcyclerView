package com.hongzhi.material.treerecyclerview.item.city;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.base.ViewHolder;
import com.hongzhi.material.treerecyclerview.demo.city.ProvinceBean;
import com.hongzhi.material.treerecyclerview.item.TreeItem;

/**
 */
public class AreaItem extends TreeItem<ProvinceBean.CityBean.AreasBean> {

    @Override
    public int getLayoutId() {
        return R.layout.item_three;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder) {
        holder.setText(R.id.tv_content, data.getAreaName());
    }

    @Override
    public int getSpanSize(int maxSpan) {
        return maxSpan / 6;
    }

    @Override
    public void onClick(ViewHolder viewHolder) {
        super.onClick(viewHolder);

    }
    @Override
    public void getItemOffsets(@NonNull Rect outRect, RecyclerView.LayoutParams layoutParams, int position) {
        super.getItemOffsets(outRect, layoutParams, position);
        outRect.top = 1;
        if (position == 0) {
            outRect.top = 0;
        }
    }
}
