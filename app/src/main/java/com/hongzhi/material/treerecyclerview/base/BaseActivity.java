package com.hongzhi.material.treerecyclerview.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 11:55
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initData();
        initView();
        start();
        initListener();
    }

    /**
     * 加载布局
     */
    abstract int layoutId();

    /**
     * 初始化数据
     */
    abstract void initData();

    /**
     * 初始化View
     */
    abstract void initView();

    /**
     * 开始请求
     */
    abstract void start();

    private void initListener() {

    }

    /**
     * 打卡软键盘
     */
    public void openKeyBord(EditText mEditText , Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     */
    public void closeKeyBord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
