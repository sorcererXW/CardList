package com.sorcererxw.demo.cardlist.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sorcererxw.demo.cardlist.planA.LinearFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public abstract class BaseFragment extends Fragment {
    protected abstract int provideLayout();

    protected static final String DATA_KEY = "data-key";

    protected ArrayList getData(){
        return getArguments().getStringArrayList(DATA_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(provideLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init(getActivity());
    }

    protected abstract void init(Activity activity);
}
