package com.sorcererxw.demo.cardlist.planB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sorcererxw.demo.cardlist.R;
import com.sorcererxw.demo.cardlist.base.BaseViewHolder;
import com.sorcererxw.demo.cardlist.util.LinearItemType;

import java.util.ArrayList;
import java.util.List;

import static com.sorcererxw.demo.cardlist.util.LinearItemType.TYPE_BOTTOM;
import static com.sorcererxw.demo.cardlist.util.LinearItemType.TYPE_TOP;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {
    private List<String> mList = new ArrayList<>();
    private Context mContext;

    public LinearAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        return LinearItemType.type(position, getItemCount());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case TYPE_BOTTOM:
                layout = R.layout.b_item_linear_bottom;
                break;
            case TYPE_TOP:
                layout = R.layout.b_item_linear_top;
                break;
            default:
                layout = R.layout.b_item_linera_center;
        }
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends BaseViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
