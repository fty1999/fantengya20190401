package com.bawei.com.a20190404moniyk.model.http;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 08:49:38
 * @Description:
 */
public class HttpUtils <T>{

    //单例
    public OkHttpClient okHttpClient;
    private HttpUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static HttpUtils getInstance(){
        return HttpViewHolder.instance;
    }

    private static class HttpViewHolder{
        private static HttpUtils instance = new HttpUtils();
    }

    private CallBackData mCallBack;
    public void getData(String path, final Class<T> tClass, CallBackData callBackData){
        this.mCallBack = callBackData;
        Request request = new Request.Builder()
                .url(path)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = handler.obtainMessage();
                message.what = 0;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(string, tClass);
                Message message = handler.obtainMessage();
                message.what = 1;
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                T t = (T) msg.obj;
                mCallBack.onSuccess(t);
            }else {
                String err = (String) msg.obj;
                mCallBack.onFail(err);
            }
        }
    };

    //创建一个接口
    public interface CallBackData<D>{
        void onSuccess(D d);
        void onFail(String msg);
    }
}
