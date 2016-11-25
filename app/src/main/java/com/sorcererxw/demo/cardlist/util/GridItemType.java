package com.sorcererxw.demo.cardlist.util;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class GridItemType {
    public static final int TYPE_CENTER = 0x0;
    public static final int TYPE_TOP = 0x1;
    public static final int TYPE_BOTTOM = 0x2;
    public static final int TYPE_LEFT = 0x3;
    public static final int TYPE_RIGHT = 0x4;
    public static final int TYPE_TOP_LEFT = 0x5;
    public static final int TYPE_TOP_RIGHT = 0x6;
    public static final int TYPE_BOTTOM_LEFT = 0x7;
    public static final int TYPE_BOTTOM_RIGHT = 0x8;

    public static int type(int pos, int span, int count) {
        if (pos < span) {
            if (pos == 0) {
                return TYPE_TOP_LEFT;
            }
            if (pos == span - 1) {
                return TYPE_TOP_RIGHT;
            }
            return TYPE_TOP;
        }
        if (pos + span >= count) {
            if (pos % span == 0) {
                return TYPE_BOTTOM_LEFT;
            }
            if ((pos + 1) % span == 0) {
                return TYPE_BOTTOM_RIGHT;
            }
            return TYPE_BOTTOM;
        }
        if (pos % span == 0) {
            return TYPE_LEFT;
        }
        if ((pos + 1) % span == 0) {
            return TYPE_RIGHT;
        }
        return TYPE_CENTER;
    }

}
