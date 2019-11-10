package com.muviteam.muviapp.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> stringListTitles = new ArrayList<>();


    public AdapterViewPager(@NonNull FragmentManager fm) {
        super(fm);
        fragmentList.add(new FragmentHome());
        fragmentList.add(new FragmentHome());
        fragmentList.add(new FragmentHome());

        stringListTitles.add("Watchlist");
        stringListTitles.add("Home");
        stringListTitles.add("Generos");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return stringListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringListTitles.get(position);
    }

}
