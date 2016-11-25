package com.sorcererxw.demo.cardlist.planD;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sorcererxw.demo.cardlist.R;
import com.sorcererxw.demo.cardlist.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class GridFragment extends BaseFragment {
    public static GridFragment newInstance(ArrayList<String> data) {
        GridFragment fragment = new GridFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(DATA_KEY, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int provideLayout() {
        return R.layout.d_fragment;
    }

    @Override
    protected void init(Activity activity) {
        Adapter adapter =
                new Adapter(activity, getData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(
                new GridLayoutManager(activity, 4, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
    }
}
