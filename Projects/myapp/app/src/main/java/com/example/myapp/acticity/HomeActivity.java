package com.example.myapp.acticity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapp.R;
import com.example.myapp.adapter.MyPagerAdapter;
import com.example.myapp.entity.TabEntity;
import com.example.myapp.fragment.DynamicFragment;
import com.example.myapp.fragment.FriendFragment;
import com.example.myapp.fragment.HomeFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * @author 25798
 */
public class HomeActivity extends BaseActivity {

    private final String[] mTitles = {"消息", "好友","空间"};
    private final int[] mIconUnselectIds = {
            R.mipmap.information, R.mipmap.friend,  R.mipmap.dynamic,
           };
    private final int[] mIconSelectIds = {
            R.mipmap.information_selected ,R.mipmap.friend_selected, R.mipmap.dynamic_selected,
            };
    private final ArrayList<Fragment> mFragments = new ArrayList<Fragment>();
    private final ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }


    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewPager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
    }


    @Override
    protected void initData() {
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(DynamicFragment.newInstance());
        mFragments.add(FriendFragment.newInstance());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
    }
}