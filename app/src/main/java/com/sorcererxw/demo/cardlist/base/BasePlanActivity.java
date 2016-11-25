package com.sorcererxw.demo.cardlist.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sorcererxw.demo.cardlist.R;
import com.sorcererxw.demo.cardlist.util.DataGenerator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public abstract class BasePlanActivity extends AppCompatActivity {
    private Fragment mLinearFragment;
    private Fragment mGridFragment;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.toolbar_plan)
    Toolbar mToolbar;

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ButterKnife.bind(this);

        mLinearFragment = provideLinearFragment(DataGenerator.generateData(50));
        mGridFragment = provideGridFragment(DataGenerator.generateData(210));

        setSupportActionBar(mToolbar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if (mLinearFragment != null) {
            adapter.addItem(Pair.create(mLinearFragment, "Linear"));
        }
        if (mGridFragment != null) {
            adapter.addItem(Pair.create(mGridFragment, "Grid"));
        }
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    protected abstract Fragment provideLinearFragment(ArrayList<String> data);

    protected abstract Fragment provideGridFragment(ArrayList<String> data);
}
