package com.example.myapp.acticity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.R;
import com.example.myapp.util.StringUtils;

public class RegisteActivity extends BaseActivity {
    private EditText etUser;
    private EditText etPwd;
    private Button registeBtn;

    @Override
    protected int initLayout() {
        return R.layout.activity_registe;
    }

    @Override
    protected void initView() {
        etUser = findViewById(R.id.et_registe_user);
        etPwd = findViewById(R.id.et_registe_pwd);
        registeBtn = findViewById(R.id.registe_btn);

    }

    @Override
    protected void initData() {
        registeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //获取到输入框中用户输入的内容
                String userName = etUser.getText().toString().trim();
                String password = etPwd.getText().toString().trim();
                registe(userName,password);
            }
        });
    }

    private void registe(String userName,String password) {
        if(StringUtils.isEmpty(userName)) {
            showToast("用户名不能为空");
        }
        if(StringUtils.isEmpty(password)) {
            showToast("密码不能为空");
        }
    }
}