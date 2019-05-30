package com.hongzhi.material.treerecyclerview.persenter;

import android.content.Context;
import com.hongzhi.material.treerecyclerview.demo.Sort.SortActivity;
import com.hongzhi.material.treerecyclerview.bean.MainItemBean;
import com.hongzhi.material.treerecyclerview.demo.city.CityActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 13:45
 */
public class MainPersenter {

    public MainPersenter(Context context) {

    }

    /**
     * 获取 显示列表
     * @return
     */
    public List getInitDataList() {
         List<MainItemBean> dataList = new ArrayList();
         dataList.add(new MainItemBean("两级索引页", SortActivity.class));
         dataList.add(new MainItemBean("三级列表城市列表", CityActivity.class));
         return dataList;
    }
}
