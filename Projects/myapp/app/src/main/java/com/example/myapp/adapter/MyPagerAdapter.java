package com.example.myapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author 25798
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
        private String[] mTitles;
        private ArrayList<Fragment> mFragments;
        public MyPagerAdapter(FragmentManager fm,String[] titles,ArrayList<Fragment> fragment) {
            super(fm);
            this.mTitles = titles;
            this.mFragments = fragment;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
