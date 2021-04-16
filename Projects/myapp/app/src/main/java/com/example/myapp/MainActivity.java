package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.acticity.BaseActivity;
import com.example.myapp.acticity.LoginActivity;
import com.example.myapp.acticity.RegisteActivity;

/**
 * @author 25798
 */
public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnRegiste;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegiste = findViewById(R.id.btn_registe);
    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面跳转
                navigateTo(LoginActivity.class);
            }
        });
        btnRegiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(RegisteActivity.class);
            }
        });
    }
}