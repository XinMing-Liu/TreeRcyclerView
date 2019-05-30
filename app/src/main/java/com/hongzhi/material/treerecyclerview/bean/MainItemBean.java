package com.hongzhi.material.treerecyclerview.bean;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 14:11
 */
public class MainItemBean {
    private String  name="";
    private Class aClass;

    public String getName() {
        return name;
    }

    public MainItemBean(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
