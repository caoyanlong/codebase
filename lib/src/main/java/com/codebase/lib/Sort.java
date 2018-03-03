package com.codebase.lib;

public class Sort {
    /**
     * @param sort 插入排序：复杂度O(n^2)
     */
    public void inserSort(int sort[]) {
        int length = sort.length;
        int insertValue;
        for (int i = 1; i < length; i++) {
            insertValue = sort[i];
            int j = i - 1;
            while (j >= 0 && sort[j] > insertValue) {
                sort[j + 1] = sort[j];
                j--;
            }
            sort[j + 1] = insertValue;
        }
    }

    /**
     * @param sort 选择排序：复杂度O(n^2)
     *             思想：1.遍历整个数组，将最小的放在最前面
     *             2.遍历剩余数组，将最小的放在剩余数组最前面
     *             3.重复2步骤
     */
    public void selectSort(int sort[]) {
        int length = sort.length;
        for (int i = 0; i < length; i++) {
            int minNum = sort[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {
                if (minNum > sort[j]) {
                    minNum = sort[j];
                    position = j;
                }
            }
            int temp = sort[i];
            sort[i] = minNum;
            sort[position] = temp;
        }
    }

    /**
     * @param sort 冒泡排序：复杂度O(n^2)
     *             思想：1.将序列中所有元素两两比较，将最大的放在最后面。
     *             2.将剩余序列中所有元素两两比较，将最大的放在最后面
     */
    public void bubbleSort(int[] sort) {
        int len = sort.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {//注意第二重循环的条件
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @param sort
     * @param low
     * @param hight 快速排序：复杂度O(n*log2 ^n)
     *              思想：1.选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
     *              2.递归的将p左边和右边的数都按照第一步进行，直到不能递归
     */
    public void quickSort(int sort[], int low, int hight) {
        int index = sort[low];
        int begin = low;
        int end = hight;
        while (begin < end) {
            while (end > begin && index <= sort[end]) {
                end--;
            }
            int temp = sort[end];
            sort[end] = sort[begin];
            sort[begin] = temp;
            while (end > begin && index >= sort[begin]) {
                begin++;
            }
            int tep = sort[begin];
            sort[begin] = sort[end];
            sort[end] = tep;
        }
        if (begin > low) {
            quickSort(sort, low, begin - 1);
        }
        if (end < hight) {
            quickSort(sort, end + 1, hight);
        }
    }

    /**
     * 速度仅次于快速排序，内存少的时候使用，可以进行并行计算的时候使用。
     * 选择相邻两个数组成一个有序序列。
     * 选择相邻的两个有序序列组成一个有序序列。
     * 重复第二步，直到全部组成一个有序序列
     */
    public void mergeSort() {
    }
}
