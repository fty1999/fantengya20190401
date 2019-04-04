package com.bawei.com.a20190404moniyk.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.com.a20190404moniyk.R;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 10:54:17
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setSelfView());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int setSelfView();
}
