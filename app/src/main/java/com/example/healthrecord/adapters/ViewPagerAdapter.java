package com.example.healthrecord.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTabTitle;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new ArrayList<>();
        mTabTitle = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle.get(position);
    }

    public void addTab(String tabTitle, Fragment fragment){
        mTabTitle.add(tabTitle);
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

}
