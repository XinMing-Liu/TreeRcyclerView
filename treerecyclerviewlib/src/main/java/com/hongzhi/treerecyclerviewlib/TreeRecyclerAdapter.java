package com.hongzhi.treerecyclerviewlib;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.hongzhi.treerecyclerviewlib.base.BaseRecyclerAdapter;
import com.hongzhi.treerecyclerviewlib.base.ViewHolder;
import com.hongzhi.treerecyclerviewlib.factory.ItemHelperFactory;
import com.hongzhi.treerecyclerviewlib.item.TreeItem;
import com.hongzhi.treerecyclerviewlib.item.TreeItemGroup;
import com.hongzhi.treerecyclerviewlib.manager.ItemManager;
import com.hongzhi.treerecyclerviewlib.manager.ItemManagerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XinMing-Liu
 * @create 2019/5/29 8:11
 */
public class TreeRecyclerAdapter extends BaseRecyclerAdapter<TreeItem> {

    private TreeRecyclerType type;
    private ItemManager<TreeItem> mItemManager;

    public TreeRecyclerAdapter() {
        this(null);
    }

    public TreeRecyclerAdapter(TreeRecyclerType treeRecyclerType) {
        this.type = treeRecyclerType == null ? TreeRecyclerType.SHOW_DEFAULT : treeRecyclerType;
    }

    @Override
    public int getLayoutId(int position) {
        TreeItem data = getData(position);
        if (data != null) {
            return data.getLayoutId();
        }
        return 0;
    }

    @Override
    public void onBindViewHolderClick(@NonNull final ViewHolder viewHolder, View view) {
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = viewHolder.getLayoutPosition();
                    //拿到处理后的postion
                    layoutPosition = checkPosition(layoutPosition);
                    //拿到beasItem
                    TreeItem itemGroup = getData(layoutPosition);
                    TreeItemGroup parentItem = itemGroup.getParentItem();
                    //判断上一级是否需要拦截这次事件，只处理当前item的上级，不关心上上级如何处理.
                    if (parentItem != null && parentItem.onInterceptClick(itemGroup)) {
                        return;
                    }

                    //必须是TreeItemGroup才能展开折叠,并且type不能为 TreeRecyclerType.SHOW_ALL
                    if (itemGroup instanceof TreeItemGroup && type != TreeRecyclerType.SHOW_ALL) {
                        TreeItemGroup treeItemGroup = (TreeItemGroup) itemGroup;
                        treeItemGroup.setExpand(!treeItemGroup.isExpand());
                    }
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(viewHolder, layoutPosition);
                    } else {
                        //拿到对应item,回调.
                        itemGroup.onClick(viewHolder);
                    }
                }
            });
        }
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //获得holder的position
                int layoutPosition = viewHolder.getLayoutPosition();
                //检查position是否可以点击
                //检查并得到真实的position
                int itemPosition = checkPosition(layoutPosition);
                if (mOnItemLongClickListener != null) {
                    return mOnItemLongClickListener.onItemLongClick(viewHolder, itemPosition);
                }
                return false;
            }
        });
    }

    @Override
    public void setDatas(List<TreeItem> datas) {
        if (null == datas || datas.isEmpty()) {
            return;
        }
        getDatas().clear();
        assembleItems(datas);
    }

    public void setDatas(TreeItemGroup treeItemGroup) {
        if (null == treeItemGroup) {
            return;
        }
        ArrayList<TreeItem> arrayList = new ArrayList<>();
        arrayList.add(treeItemGroup);
        setDatas(arrayList);
    }

    /**
     * 对初始的一级items进行遍历,将每个item的childs拿出来,进行組合。
     *
     * @param items
     */
    private void assembleItems(List<TreeItem> items) {
        if (type != null) {
            List<TreeItem> datas = getDatas();
            datas.addAll(ItemHelperFactory.getChildItemsWithType(items, type));
        } else {
            super.setDatas(items);
        }
    }

    public ItemManager<TreeItem> getmItemManager() {
        if (null == mItemManager) {
            mItemManager = new TreeItemManageImpl(this);
        }
        return mItemManager;
    }

    public void setmItemManager(ItemManager<TreeItem> mItemManager) {
        this.mItemManager = mItemManager;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TreeItem data = getData(position);
        if (data == null) {
            return;
        }
        checkItemManage(data);
        data.onBindViewHolder(viewHolder);
    }

    private void checkItemManage(TreeItem item) {
        if (item.getItemManager() == null) {
            item.setItemManager(getItemManager());
        }
    }

    /**
     * 分割器
     */
    final RecyclerView.ItemDecoration treeItemDecoration = new RecyclerView.ItemDecoration() {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int i = getItemCount();
            if (getItemCount() == 0) {
                return;
            }
            int checkPosition = checkPosition(viewLayoutPosition);
            if (checkPosition < 0 || checkPosition >= i) {
                return;
            }
            TreeItem data = getData(checkPosition);
            if (data != null) {
                data.getItemOffsets(outRect, layoutParams, checkPosition);
            }
        }
    };
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.removeItemDecoration(treeItemDecoration);
        recyclerView.addItemDecoration(treeItemDecoration);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            TreeSpanSizeLookup treeSpanSizeLookup = new TreeSpanSizeLookup(this, spanCount);
            gridLayoutManager.setSpanSizeLookup(treeSpanSizeLookup);
        }
    }


    @Override
    public int getItemSpanSize(int position, int maxSpan) {
        TreeItem data = getData(position);
        if (data == null) {
            return maxSpan;
        }
        return data.getSpanSize(maxSpan);
    }

    /**
     * 需要设置在setdata之前,否则type不会生效
     *
     * @param type
     */
    @Deprecated
    public void setType(TreeRecyclerType type) {
        this.type = type;
    }
    private class TreeItemManageImpl extends ItemManagerImpl<TreeItem> {

        TreeItemManageImpl(BaseRecyclerAdapter<TreeItem> adapter) {
            super(adapter);
        }

        @Override
        public void addItem(TreeItem item) {
            if (item instanceof TreeItemGroup) {
                ArrayList<TreeItem> childItemsWithType = ItemHelperFactory.getChildItemsWithType((TreeItemGroup) item, type);
                childItemsWithType.add(0, item);
                super.addItems(childItemsWithType);
            } else {
                super.addItem(item);
            }
        }

        @Override
        public void addItems(List<TreeItem> items) {
            ArrayList<TreeItem> childItemsWithType = ItemHelperFactory.getChildItemsWithType(items, type);
            super.addItems(childItemsWithType);
        }

        @Override
        public void addItems(int position, List<TreeItem> items) {
            ArrayList<TreeItem> childItemsWithType = ItemHelperFactory.getChildItemsWithType(items, type);
            super.addItems(position, childItemsWithType);
        }

        @Override
        public void removeItem(TreeItem item) {
            if (item instanceof TreeItemGroup) {
                ArrayList<TreeItem> childItemsWithType = ItemHelperFactory.getChildItemsWithType((TreeItemGroup) item, type);
                childItemsWithType.add(0, item);
//                getDatas().removeAll(childItemsWithType);
                super.removeItems(childItemsWithType);
            } else {
                super.removeItem(item);
            }
        }

        @Override
        public void removeItems(List<TreeItem> items) {
            ArrayList<TreeItem> childItemsWithType = ItemHelperFactory.getChildItemsWithType(items, type);
            super.removeItems(childItemsWithType);
        }


    }


    public final static class TreeSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        private final BaseRecyclerAdapter adapter;
        private final int spanCount;

        public TreeSpanSizeLookup(BaseRecyclerAdapter adapter, int spanCount) {
            this.adapter = adapter;
            this.spanCount = spanCount;
        }

        @Override
        public int getSpanSize(int position) {
            int i = adapter.getItemCount();
            if (i == 0) {
                return spanCount;
            }
            int itemToDataPosition = adapter.getItemManager().itemToDataPosition(position);
            if (itemToDataPosition < 0 || itemToDataPosition >= i) {
                return spanCount;
            }
            int itemSpanSize = adapter.getItemSpanSize(itemToDataPosition, spanCount);//新版本传入总数
            if (itemSpanSize == 0) {
                return spanCount;
            }
            return itemSpanSize;
        }
    }
}
