package com.bawei.com.a20190404moniyk.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.com.a20190404moniyk.R;
import com.bawei.com.a20190404moniyk.model.bean.LoginBean;
import com.bawei.com.a20190404moniyk.presenter.LoginPresenter;
import com.bawei.com.a20190404moniyk.presenter.RegisterPresenter;
import com.bawei.com.a20190404moniyk.view.interfaces.IMView;
import com.google.gson.Gson;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/4 10:37:14
 * @Description:
 */
public class RegisterActivity extends BaseActivity implements IMView.iView {
    private LoginPresenter loginPresenter;
    private Button login_button;
    private TextView register_text;
    private CheckBox rememb;
    private EditText phone_edit;
    private EditText pwd_edit;
    private RegisterPresenter registerPresenter;

    @Override
    protected void initView() {
        //登录按钮
        login_button = findViewById(R.id.register_button);
        //注册
        register_text = findViewById(R.id.text1);
        phone_edit = findViewById(R.id.editText0);
        pwd_edit = findViewById(R.id.editText1);

        //记住密码
        rememb = findViewById(R.id.checkbox0);
        SharedPreferences sp;
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone= phone_edit.getText().toString();
                String pwd= pwd_edit.getText().toString();
                if(phone.equals("") && pwd.equals("")){
                    Toast.makeText(RegisterActivity.this, "手机号或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }//传数据15036311244
                registerPresenter.requestMsg(phone,pwd);
            }
        });
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected int setSelfView() {
        return R.layout.activity_register;
    }

    ;

    @Override
    protected void initData() {
        registerPresenter = new RegisterPresenter();
        registerPresenter.attachView(this);
    }

    @Override
    public void showData(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_SHORT).show();
                Gson gson=new Gson();
                LoginBean loginBean = gson.fromJson(msg, LoginBean.class);
                String status = loginBean.getStatus();
                if(status.equals("0000")){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }
}
