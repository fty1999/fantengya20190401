package com.bawei.com.a20190404moniyk.presenter;

import com.bawei.com.a20190404moniyk.application.Contants;
import com.bawei.com.a20190404moniyk.model.bean.ShopBean;
import com.bawei.com.a20190404moniyk.model.http.HttpUtils;
import com.bawei.com.a20190404moniyk.view.interfaces.IMainView;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 08:44:35
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<ShopBean>>{

    private final HttpUtils httpUtils;

    public MainPresenter(){
        httpUtils = HttpUtils.getInstance();
    }
    public void loadFormDataNet(){
        httpUtils.getData(Contants.SHOP_URL, ShopBean.class, new HttpUtils.CallBackData<ShopBean>() {

            @Override
            public void onSuccess(ShopBean shopBean) {
                getView().CallBackSuccess(shopBean);
            }

            @Override
            public void onFail(String msg) {
                getView().CallBackFail(msg);
            }
        });
    }
}
