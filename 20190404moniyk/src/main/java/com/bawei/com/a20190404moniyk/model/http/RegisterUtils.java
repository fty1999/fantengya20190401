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
 * @Date: 2019/4/4 10:35:28
 * @Description:
 */
public class RegisterUtils implements IMView.IModel{
    private final OkHttpClient okHttpClient;

    //单例
    public RegisterUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public static RegisterUtils getInstance(){
        return LoginViewHolder.instance;
    }
    private static class LoginViewHolder{
        private static RegisterUtils instance = new RegisterUtils();
    }
    @Override
    public void requestData(String phone, String pwd, final IMView.IModel.CallBack callBack) {
        FormBody formBody = new FormBody.Builder().build();
        final Request request = new Request.Builder()
                .url(Contants.REGISTER_URL+"?phone="+phone+"&pwd="+pwd)
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
