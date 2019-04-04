package com.bawei.com.a20190404moniyk.presenter;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 08:44:25
 * @Description:
 */
public class BasePresenter <V>{
    public V view;
    public V getView(){
        return view;
    }
    public void setView(V view){
        this.view = view;
    }
    public void detachView(){
        this.view = null;
    }
}
