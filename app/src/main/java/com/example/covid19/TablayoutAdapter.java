package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TablayoutAdapter extends FragmentPagerAdapter {

    public ArrayList<Fragment> mFragmentList=new ArrayList<>();
    public ArrayList<String> mFragmentTitleList =new ArrayList<>();

    public TablayoutAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment fragment ,String title)
    {
        mFragmentTitleList.add(title);
        mFragmentList.add(fragment);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
