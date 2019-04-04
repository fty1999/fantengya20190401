package com.bawei.com.a20190404moniyk.view.interfaces;

import com.bawei.com.a20190404moniyk.model.bean.ShopBean;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 08:44:54
 * @Description:
 */
public interface IBaseView {
    void CallBackSuccess(ShopBean shopBean);
    void CallBackFail(String errMsg);
}
