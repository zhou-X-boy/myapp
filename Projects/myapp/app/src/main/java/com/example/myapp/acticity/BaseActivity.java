package com.example.myapp.acticity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.MainActivity;

/**
 * @author 25798
 *
 */
public abstract class BaseActivity  extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initData();
    /**
     * 同步页面提示
     */
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    /**
     * 异步页面提示
     */
    public void showToastSync(String msg) {
        Looper.prepare();
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        Looper.loop();
    }

    /**
     * 页面跳转
     * @param cls  需要跳转到的页面的 .class
     */
    public void navigateTo(Class cls) {
        Intent in = new Intent(mContext, cls);
        startActivity(in);
    }

    /**
     * 将key值保存起来
     * @param key
     * @param val
     */
    public void saveStringToSp(String key,String val) {
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }
}
