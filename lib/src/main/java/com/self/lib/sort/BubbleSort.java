package com.self.lib.sort;

/**
 * Created by cyl on 2018/2/27.
 * 冒泡排序：复杂度o(n^2)
 * 思想：从下开始向上比较相邻的两个值，大的放上面所有元素一一比较
 */

public class BubbleSort {
    public void bubbleSort(int[] sort) {
        int length = sort.length;
        if (length <= 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sort[j] < sort[i]) {
                    int temp = sort[j];
                    sort[j] = sort[i];
                    sort[i] = temp;
                }
            }
        }

    }
}
