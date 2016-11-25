package com.sorcererxw.demo.cardlist.planA;

import android.support.v4.app.Fragment;

import com.sorcererxw.demo.cardlist.base.BasePlanActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class PlanActivity extends BasePlanActivity {

    @Override
    protected Fragment provideLinearFragment(ArrayList<String> data) {
        return LinearFragment.newInstance(data);
    }

    @Override
    protected Fragment provideGridFragment(ArrayList<String> data) {
        return GridFragment.newInstance(data);
    }
}
