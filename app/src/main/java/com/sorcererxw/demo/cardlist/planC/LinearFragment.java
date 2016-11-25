package com.sorcererxw.demo.cardlist.planC;

import android.app.Activity;
import android.os.Bundle;
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

public class LinearFragment extends BaseFragment {
    public static LinearFragment newInstance(ArrayList<String> data) {
        LinearFragment fragment = new LinearFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(DATA_KEY, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int provideLayout() {
        return R.layout.c_fragment;
    }

    @Override
    protected void init(Activity activity) {
        LinearAdapter adapter =
                new LinearAdapter(activity, getData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
    }
}