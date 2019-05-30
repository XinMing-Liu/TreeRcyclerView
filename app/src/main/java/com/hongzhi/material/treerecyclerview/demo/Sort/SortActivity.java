package com.hongzhi.material.treerecyclerview.demo.Sort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.hongzhi.material.treerecyclerview.item.sort.IndexBar;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.TreeRecyclerType;
import com.hongzhi.material.treerecyclerview.item.TreeItem;
import com.hongzhi.material.treerecyclerview.item.sort.SortGroupItem;
import com.hongzhi.material.treerecyclerview.widget.TreeSortAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 多级目录
 */
public class SortActivity extends AppCompatActivity {

    private TreeSortAdapter treeSortAdapter = new TreeSortAdapter(TreeRecyclerType.SHOW_DEFAULT);
    private LinearLayoutManager mLinearLayoutManager;

    private static final String[] LETTERS = new String[]{"#","A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        RecyclerView rv_content = findViewById(R.id.rv_content);

        TextView tv_index = findViewById(R.id.tv_index);
        IndexBar indexBar = (IndexBar) findViewById(R.id.qb_sort);
        indexBar.setOnIndexChangedListener(new IndexBar.OnIndexChangedListener() {
            @Override
            public void onIndexChanged(String letter) {
                int sortItem = treeSortAdapter.getSortIndex(letter);
                mLinearLayoutManager.scrollToPositionWithOffset(sortItem, 0);
            }
        });
        indexBar.setIndexs(LETTERS);
        indexBar.setSelectedIndexTextView(tv_index);


        mLinearLayoutManager = new LinearLayoutManager(this);
        rv_content.setLayoutManager(mLinearLayoutManager);
        rv_content.setAdapter(treeSortAdapter);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        List<TreeItem> groupItems = new ArrayList<>();
        for (String str : LETTERS) {
            SortGroupItem sortGroupItem = new SortGroupItem();
            TraceBackTreeItemGroup traceBackTreeItemGroup = new TraceBackTreeItemGroup("16010200051711020051",
                    "16010100381711020031",
                    "1601010038",
                    "大拉光面丝",
                    "1.30HT",
                    "大拉",
                    "三车间", null);
            sortGroupItem.setData(traceBackTreeItemGroup);
            sortGroupItem.setSortKey(str);
//            sortGroupItem.setExpand(true);
            groupItems.add(sortGroupItem);
        }
        treeSortAdapter.getItemManager().replaceAllItem(groupItems);
        treeSortAdapter.getItemManager().setOpenAnim(true);//设置是否显示打开动画

    }
}
