package com.example.myapp.acticity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.api.Api;
import com.example.myapp.api.ApiConfig;
import com.example.myapp.api.TtitCallback;
import com.example.myapp.entity.LoginResponse;
import com.example.myapp.util.AppConfig;
import com.example.myapp.util.StringUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author 25798
 */
public class LoginActivity extends BaseActivity {
    
    private EditText etUser;
    private EditText etPwd;
    private Button loginBtn;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etUser = findViewById(R.id.et_user);
        etPwd = findViewById(R.id.et_pwd);
        loginBtn = findViewById(R.id.login_btn);

    }

    @Override
    protected void initData() {
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //获取到输入框中用户输入的内容
                String userName = etUser.getText().toString().trim();
                String password = etPwd.getText().toString().trim();
                try {
                    login(userName,password);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void login(String userName,String password) throws IOException {
        if (StringUtils.isEmpty(userName)) {
            showToast("用户名不能为空");
            return;
        }
        if (StringUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return;
        }
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("user", userName);
        params.put("password", password);
        Api.config(ApiConfig.LOGIN,params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(String res) {
                Gson gson = new Gson();
                LoginResponse response = gson.fromJson(res,LoginResponse.class);
                if("OK".equals(response.getResult())) {
                    LoginResponse.DataDTO data = response.getData();
                    String token = data.getToken();
                    saveStringToSp("token", token);
                    navigateTo(HomeActivity.class);
                    showToastSync("登录成功");
                }else {
                    showToastSync(response.getMsg());
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure", String.valueOf(e));
            }
        });
    }
}