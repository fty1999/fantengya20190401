package com.bawei.com.a20190404moniyk.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.model.bean.ShopBean;
import com.bawei.com.a20190404moniyk.presenter.MainPresenter;
import com.bawei.com.a20190404moniyk.view.adapter.ShopAdapter;
import com.bawei.com.a20190404moniyk.view.interfaces.IMainView;

import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 09:10:23
 * @Description:
 */
public class Frag_one extends Fragment implements IMainView {

    private RecyclerView recyclerView1;
    private ShopAdapter shopAdapter;
    private MainPresenter mainPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_one,container,false);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView1.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView1.setLayoutManager(linearLayoutManager);
        shopAdapter = new ShopAdapter(getContext());
        recyclerView1.setAdapter(shopAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        mainPresenter.loadFormDataNet();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void CallBackSuccess(ShopBean shopBean) {
        List<ShopBean.DataBean> data = shopBean.getData();
        shopAdapter.setData(data);
    }

    @Override
    public void CallBackFail(String errMsg) {

    }
}
