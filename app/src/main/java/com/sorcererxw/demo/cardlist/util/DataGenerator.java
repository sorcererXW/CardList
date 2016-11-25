package com.sorcererxw.demo.cardlist.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/11/25
 */

public class DataGenerator {
    public static ArrayList<String> generateData(int size) {
        ArrayList<String> list = new ArrayList<>();
        int st = 0x1F601;
        int max = 0x1F64F - st + 1;
        for (int i = 0; i < size; i++) {
            list.add(new String(Character.toChars(st + i % max)));
        }
        return list;
    }
}
