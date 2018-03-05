package com.self.lib;

import com.self.lib.Algorithm.Algorithm;
import com.self.lib.sort.BubbleSort;

public class myClass {
    public static void main(String args[]) {
        int sort[] = {1, 4, 2, 5, 3, 8, 6, 7};


        // 冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(sort);

        //快速排序
        Algorithm algorithm = new Algorithm();
        System.out.println(algorithm.myAtoi("1234"));
    }

}
