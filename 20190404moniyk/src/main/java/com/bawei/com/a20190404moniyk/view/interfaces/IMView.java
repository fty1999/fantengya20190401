package com.bawei.com.a20190404moniyk.view.interfaces;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 10:39:38
 * @Description:
 */
public interface IMView {
    public interface iView{
        void showData(String msg);
    }
    public interface IPresenter<IView>{
        void requestMsg(String phone,String pwd);
        void attachView(IView iView);
        void detachView(IView iView);
    }
    public interface IModel{
        public interface CallBack{
            void responseData(String msg);
        }
        void requestData(String phone,String pwd,CallBack callBack);
    }
}
