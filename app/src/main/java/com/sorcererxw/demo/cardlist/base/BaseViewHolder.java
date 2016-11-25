package com.sorcererxw.demo.cardlist.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sorcererxw.demo.cardlist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.textView_item)
    public TextView text;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
