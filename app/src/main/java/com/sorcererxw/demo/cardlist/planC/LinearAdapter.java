package com.sorcererxw.demo.cardlist.planC;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sorcererxw.demo.cardlist.R;
import com.sorcererxw.demo.cardlist.base.BaseViewHolder;
import com.sorcererxw.demo.cardlist.util.GridItemType;
import com.sorcererxw.demo.cardlist.util.LinearItemType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.mthli.slice.Slice;

import static com.sorcererxw.demo.cardlist.util.LinearItemType.TYPE_BOTTOM;
import static com.sorcererxw.demo.cardlist.util.LinearItemType.TYPE_CENTER;
import static com.sorcererxw.demo.cardlist.util.LinearItemType.TYPE_TOP;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class LinearAdapter  extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {
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
                layout = R.layout.c_item_linear_bottom;
                break;
            case TYPE_TOP:
                layout = R.layout.c_item_linear_top;
                break;
            default:
                layout = R.layout.c_item_linera_center;
        }
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_CENTER:
                setSlice(holder.frame,
                        true, true, true, true,
                        false, false, true, true);
                break;
            case TYPE_TOP:
                setSlice(holder.frame,
                        false, false, true, true,
                        true, false, true, true);
                break;
            case TYPE_BOTTOM:
                setSlice(holder.frame,
                        true, true, false, false,
                        false, true, true, true);
                break;
        }
        holder.text.setText(mList.get(position));
    }

    private void setSlice(View view,
                          boolean showLeftTopRect,
                          boolean showRightTopRect,
                          boolean showLeftBottomRect,
                          boolean showRightBottomRect,
                          boolean showTopEdgeShadow,
                          boolean showBottomEdgeShadow,
                          boolean showLeftEdgeShadow,
                          boolean showRightEdgeShadow) {
        Slice slice = new Slice(view);
        slice.setRadius(2);
        slice.setElevation(4);
        slice.showLeftTopRect(showLeftTopRect);
        slice.showRightTopRect(showRightTopRect);
        slice.showLeftBottomRect(showLeftBottomRect);
        slice.showRightBottomRect(showRightBottomRect);
        slice.showTopEdgeShadow(showTopEdgeShadow);
        slice.showBottomEdgeShadow(showBottomEdgeShadow);
        slice.showLeftEdgeShadow(showLeftEdgeShadow);
        slice.showRightEdgeShadow(showRightEdgeShadow);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.frame_item)
        FrameLayout frame;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
