package com.bawei.com.a20190404moniyk.model.http;

import com.bawei.com.a20190404moniyk.application.Contants;
import com.bawei.com.a20190404moniyk.view.interfaces.IMView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 10:35:05
 * @Description:
 */
public class LoginUtils implements IMView.IModel {
    private final OkHttpClient okHttpClient;

    //单例
    public LoginUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public static LoginUtils getInstance(){
        return LoginViewHolder.instance;
    }
    private static class LoginViewHolder{
        private static LoginUtils instance = new LoginUtils();
    }
    @Override
    public void requestData(String phone, String pwd, final CallBack callBack) {
        FormBody formBody = new FormBody.Builder().build();
        final Request request = new Request.Builder()
                .url(Contants.LOGIN_URL+"?phone="+phone+"&pwd="+pwd)
                .method("POST",formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack.responseData(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                callBack.responseData(string);
            }
        });
    }
}
