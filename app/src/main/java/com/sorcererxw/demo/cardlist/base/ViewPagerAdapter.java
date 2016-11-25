package com.sorcererxw.demo.cardlist.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private List<Pair<Fragment, String>> mList = new ArrayList<>();

    public void addItem(Pair<Fragment, String> item) {
        mList.add(item);
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position).first;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).second;
    }
}
