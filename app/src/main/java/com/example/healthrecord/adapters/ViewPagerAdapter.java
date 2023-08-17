package com.example.healthrecord.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.healthrecord.fragments.RegisterPatientFragment;
import com.example.healthrecord.fragments.ViewPatientFragment;

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
