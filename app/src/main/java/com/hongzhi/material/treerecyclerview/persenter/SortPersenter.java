package com.hongzhi.material.treerecyclerview.persenter;

import android.content.Context;
import com.hongzhi.material.treerecyclerview.demo.Sort.TraceBackTreeItemGroup;
import com.hongzhi.material.treerecyclerview.demo.Sort.TraceBackTreelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 16:18
 */
public class SortPersenter {
    private final Context mContext;

    public SortPersenter(Context context) {
        this.mContext = context;
    }

    public List<TraceBackTreeItemGroup> getDataList() {
        TraceBackTreelItem treelItem = new TraceBackTreelItem("16010200051711020051",
                "16010100381711020031",
                "1601010038",
                "大拉光面丝",
                "1.30HT",
                "大拉",
                "三车间");
        ArrayList<TraceBackTreelItem> treelItems = new ArrayList<>();
        treelItems.add(treelItem);
        treelItems.add(treelItem);
        treelItems.add(treelItem);

        ArrayList<TraceBackTreeItemGroup> treeItemGroups = new ArrayList<>();
        treeItemGroups.add(new TraceBackTreeItemGroup("16010200051711020051",
                "16010100381711020031",
                "1601010038",
                "大拉光面丝",
                "1.30HT",
                "大拉",
                "三车间",treelItems));
        treeItemGroups.add(new TraceBackTreeItemGroup("16010200051711020051",
                "16010100381711020031",
                "1601010038",
                "大拉光面丝",
                "1.30HT",
                "大拉",
                "三车间",treelItems));
        treeItemGroups.add(new TraceBackTreeItemGroup("16010200051711020051",
                "16010100381711020031",
                "1601010038",
                "大拉光面丝",
                "1.30HT",
                "大拉",
                "三车间",treelItems));
        return treeItemGroups;
    }

//    public
}
