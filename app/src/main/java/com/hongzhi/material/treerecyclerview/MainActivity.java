package com.hongzhi.material.treerecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.hongzhi.material.treerecyclerview.bean.MainItemBean;
import com.hongzhi.material.treerecyclerview.persenter.MainPersenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MainItemBean> dataList = new ArrayList();
    private MainPersenter mainPersenter;
    private CommonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPersenter = new MainPersenter(this);

        RecyclerView rv_content = (RecyclerView)findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        adapter = getAdapter();
        rv_content.setAdapter(adapter);
        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        dataList.addAll(mainPersenter.getInitDataList());
        adapter.notifyDataSetChanged();
    }

    private CommonAdapter getAdapter() {
        return new CommonAdapter<MainItemBean>(this, R.layout.item_activity_main, dataList) {
            @Override
            protected void convert(ViewHolder holder, final MainItemBean pair, int position) {
                holder.setText(R.id.tv_item_name, pair.getName());
                holder.setOnClickListener(R.id.item_list, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startAc(pair.getaClass());
                    }
                });
            }
        };
    }

    private void startAc(Class<?> second) {
        startActivity(new Intent(this,second));
    }
}
