package com.hongzhi.material.treerecyclerview.demo.city;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.hongzhi.material.treerecyclerview.R;
import com.hongzhi.material.treerecyclerview.TreeRecyclerAdapter;
import com.hongzhi.material.treerecyclerview.TreeRecyclerType;
import com.hongzhi.material.treerecyclerview.factory.ItemHelperFactory;
import com.hongzhi.material.treerecyclerview.item.TreeItem;
import com.hongzhi.material.treerecyclerview.item.TreeItemGroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class CityActivity extends AppCompatActivity {
    //根据item的状态展示,可折叠
    TreeRecyclerAdapter treeRecyclerAdapter = new TreeRecyclerAdapter(TreeRecyclerType.SHOW_EXPAND);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        RecyclerView recyclerView = findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(treeRecyclerAdapter);
        new Thread() {
            @Override
            public void run() {
                super.run();
                String string = getFromAssets("city.txt");
                Log.i("json", string);
                List<ProvinceBean> cityBeen = JSON.parseArray(string, ProvinceBean.class);
                refresh(cityBeen);
            }
        }.start();
    }
    public String getFromAssets(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            while ((line = bufReader.readLine()) != null)
                result.append(line);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private void refresh(final List<ProvinceBean> cityBeen) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //创建item
                //老的
                //ItemHelperFactory.createTreeItemList(cityBeen, ProvinceItemParent.class, null);
                //新的
                List<TreeItem> items = ItemHelperFactory.createItems(cityBeen, null);
                //遍历设置展开状态
                for (TreeItem item : items) {
                    if (item instanceof TreeItemGroup) {
                        if (((ProvinceBean) ((TreeItemGroup) item).getData()).getProvinceId()==2){
                            ((TreeItemGroup) item).setExpand(true);
                        }else
                        ((TreeItemGroup) item).setExpand(false);
                    }
                }
                //添加到adapter
                treeRecyclerAdapter.getItemManager().replaceAllItem(items);
                treeRecyclerAdapter.getItemManager().setOpenAnim(true);
            }
        });

    }
}
