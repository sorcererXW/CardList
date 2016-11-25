package com.sorcererxw.demo.cardlist.util;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class LinearItemType {
    public static final int TYPE_TOP = 0x0;
    public static final int TYPE_BOTTOM = 0x1;
    public static final int TYPE_CENTER = 0x2;

    public static int type(int pos, int count) {
        if (pos == 0) {
            return TYPE_TOP;
        }
        if (pos == count - 1) {
            return TYPE_BOTTOM;
        }
        return TYPE_CENTER;
    }

}
