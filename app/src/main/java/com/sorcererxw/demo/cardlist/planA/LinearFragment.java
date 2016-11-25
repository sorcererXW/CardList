package com.sorcererxw.demo.cardlist.planA;

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

    @Override
    protected int provideLayout() {
        return R.layout.a_fragment;
    }

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
    protected void init(Activity activity) {
        Adapter adapter =
                new Adapter(activity, getData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
    }
}
