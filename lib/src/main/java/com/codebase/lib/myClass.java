package com.codebase.lib;


import java.util.List;

public class myClass {
    public static void main(String args[]) {
//        int sort[] = {4, 2, 1, 3, 9, 7, 5, 8};
//        Sort selectSort = new Sort();
//        selectSort.selectSort(sort);
//        for (int i = 0; i < sort.length; i++) {
//            System.out.println(sort[i]);
//        }
        Algorithm algorithm = new Algorithm();
        Algorithm.TreeNode root = new Algorithm.TreeNode(3);
        root.left = new Algorithm.TreeNode(9);
        root.right = new Algorithm.TreeNode(20);
        root.right.left = new Algorithm.TreeNode(15);
        root.right.right = new Algorithm.TreeNode(7);

        List<List<Integer>> res = algorithm.levelOrder(root);

        for (List<Integer> is : res) {
            for (Integer i : is) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
