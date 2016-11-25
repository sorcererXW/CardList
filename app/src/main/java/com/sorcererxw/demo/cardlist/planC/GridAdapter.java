package com.sorcererxw.demo.cardlist.planC;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.sorcererxw.demo.cardlist.R;
import com.sorcererxw.demo.cardlist.base.BaseViewHolder;
import com.sorcererxw.demo.cardlist.util.GridItemType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.mthli.slice.Slice;

import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_BOTTOM;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_BOTTOM_LEFT;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_BOTTOM_RIGHT;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_CENTER;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_LEFT;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_RIGHT;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_TOP;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_TOP_LEFT;
import static com.sorcererxw.demo.cardlist.util.GridItemType.TYPE_TOP_RIGHT;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<String> mList = new ArrayList<>();
    private Context mContext;
    private int mSpan;

    public GridAdapter(Context context, List<String> list, int span) {
        mContext = context;
        mList = list;
        mSpan = span;
        while (mList.size() % mSpan != 0) {
            mList.add(null);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return GridItemType.type(position, mSpan, getItemCount());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case TYPE_TOP:
                layout = R.layout.c_item_grid_top;
                break;
            case TYPE_TOP_LEFT:
                layout = R.layout.c_item_grid_top_left;
                break;
            case TYPE_TOP_RIGHT:
                layout = R.layout.c_item_grid_top_right;
                break;
            case TYPE_BOTTOM:
                layout = R.layout.c_item_grid_bottom;
                break;
            case TYPE_BOTTOM_LEFT:
                layout = R.layout.c_item_grid_bottom_left;
                break;
            case TYPE_BOTTOM_RIGHT:
                layout = R.layout.c_item_grid_bottom_right;
                break;
            case TYPE_LEFT:
                layout = R.layout.c_item_grid_left;
                break;
            case TYPE_RIGHT:
                layout = R.layout.c_item_grid_right;
                break;
            default:
                layout = R.layout.c_item_grid_center;
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
                        false, false, false, false);
                break;
            case TYPE_TOP:
                setSlice(holder.frame,
                        true, true, true, true,
                        true, false, false, false);
                break;
            case TYPE_BOTTOM:
                setSlice(holder.frame,
                        true, true, true, true,
                        false, true, false, false);
                break;
            case TYPE_LEFT:
                setSlice(holder.frame,
                        true, true, true, true,
                        false, false, true, false);
                break;
            case TYPE_RIGHT:
                setSlice(holder.frame,
                        true, true, true, true,
                        false, false, false, true);
                break;
            case TYPE_TOP_LEFT:
                setSlice(holder.frame,
                        false, true, true, true,
                        true, false, true, false);
                break;
            case TYPE_TOP_RIGHT:
                setSlice(holder.frame,
                        true, false, true, true,
                        true, false, false, true);
                break;
            case TYPE_BOTTOM_LEFT:
                setSlice(holder.frame,
                        true, true, false, true,
                        false, true, true, false);
                break;
            case TYPE_BOTTOM_RIGHT:
                setSlice(holder.frame,
                        true, true, true, false,
                        false, true, false, true);
                break;
        }
        if (mList.get(position) == null) {
            return;
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

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
