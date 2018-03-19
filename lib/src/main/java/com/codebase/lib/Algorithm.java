package com.codebase.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by baidu on 2018/3/3.
 * 算法 按出题频率写
 */

public class Algorithm {
    /**
     * 频率 ：1
     *
     * @param nums
     * @param target
     * @return 两数之和
     * <p>
     * 给定一个整数数列，找出其中和为特定值的那两个数。
     * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int result[] = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        return result;
    }

    /**
     * 频率 ：2
     *
     * @param str
     * @return 字母转整数
     */
    public int myAtoi(String str) {
        int result = 0;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            char chat = str.charAt(i);
            if (i == 0 && (chat == '-' || chat == '+')) {
                negative = chat == '-' ? true : false;
            } else if (chat >= '0' && chat <= '9') {
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    return 0;
                }
                result = result * 10 + Integer.valueOf(chat) - '0';
            } else {
                return negative ? -result : result;
            }

        }
        return negative ? -result : result;
    }

    /**
     * 频率 ：3
     *
     * @param nums
     * @return 三数之和
     * 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零
     * <p>
     * 例如, 给定数组 S = [-1, 0, 1, 2, -1, -4]，
     * 一个结果集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //TODO 暂时先把搞了 比较复杂 暂时想法 三层遍历
        return null;
    }

    /**
     * 频率 ：4
     *
     * @param s
     * @return 有效的括号
     */
    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (result.empty()) {
                result.push(s.charAt(i));
            } else if ((result.peek() == '(' && s.charAt(i) == ')')
                    || (result.peek() == '{' && s.charAt(i) == '}')
                    || (result.peek() == '[' && s.charAt(i) == ']')) {
                result.pop();
            } else {
                result.push(s.charAt(i));
            }
        }
        return result.isEmpty();
    }

    /**
     * 频率 ：5 自己写的
     *
     * @param l1
     * @param l2
     * @return 合并两个已排序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newNode = new ListNode(0);
        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        while (nextL1.next != null) {
            while (nextL1.value > nextL2.value) {
                newNode.value = nextL2.value;
                newNode.next = nextL2.next;
                nextL2 = nextL2.next;
            }
            newNode.value = nextL1.value;
            newNode.next = nextL1.next;
            nextL1 = nextL1.next;
        }
        if (nextL1 != null)
            newNode.next = nextL1;
        else
            newNode.next = nextL2;
        return newNode;

    }

    /**
     * 频率 ：6
     *
     * @param haystack
     * @param needle
     * @return 实现 strStr()。
     * 返回蕴含在 haystack 中的 needle 的第一个字符的索引，如果 needle 不是 haystack 的一部分则返回 -1 。
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     */
    public int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            int pos = i;
            while (j < needle.length() && needle.charAt(j) == haystack.charAt(pos)) {
                j++;
                pos++;
                if (j == needle.length() - 1) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }


    /**
     * 频率 ：7
     *
     * @param x
     * @param n
     * @return Pow
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     */
    public double pow(double x, int n) {
        if (n < 0) {
            return 1.0 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = x;
        for (int i = 1; i < n; i++) {
            result = result * x;
        }
        return result;
    }


    /**
     * 频率 ：8
     *
     * @param intervals
     * @return <>p</>
     * 给出一个区间的集合, 请合并所有重叠的区间。
     * 示例：
     * 给出 [1,3],[2,6],[8,10],[15,18],
     * 返回 [1,6],[8,10],[15,18].
     */
    public List<Interval> merge(List<Interval> intervals) {
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(8, 10));
        if (intervals == null || intervals.size() <= 0) {
            return null;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        List<Interval> list = new ArrayList<>();
        Interval l1 = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval l2;
            if (i == intervals.size() - 1) {
                l2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
            } else {
                l2 = intervals.get(i + 1);
            }
            if (l2.start >= l1.start && l2.start <= l1.end) {
                l1.end = Math.max(l1.end, l2.end);
            } else {
                list.add(l1);
                l1 = l2;
            }
        }
        for (Interval interval : list) {
            System.out.println(interval.toString());
        }
        return list;
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    /**
     * * 频率 ：9
     *
     * @param intervals
     * @param newInterval
     * @return 插入区间 Insert Interval
     * 示例 1:
     * 给定区间 [1,3],[6,9]，插入并合并 [2,5] 得到 [1,5],[6,9].
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(6, 9));
        newInterval = new Interval(3, 7);
        ArrayList<Interval> res = new ArrayList<Interval>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval l1 = intervals.get(i);
            if (l1.end < newInterval.start) {
                res.add(l1);
            } else if (newInterval.end < l1.start) {
                res.add(newInterval);
                newInterval = l1;
            } else if (newInterval.end >= l1.start || newInterval.start <= l1.end) {
                newInterval.start = Math.min(l1.start, newInterval.start);
                newInterval.end = Math.max(l1.end, newInterval.end);
            }
        }
        res.add(newInterval);
        for (Interval interval : res) {
            System.out.println(interval.toString());
        }
        return res;
    }

    /**
     * 频率 ：10
     *
     * @param n
     * @return 爬楼梯
     * <p>
     * 输入： 2
     * 输出： 2
     * 说明： 有两种方法可以爬到顶端。
     * 1.  1 步 + 1 步
     * 2.  2 步
     */

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 频率 ：11
     *
     * @param matrix
     * @return 矩阵置零
     * <p>
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将这个元素所在的行和列都置零。
     */
    public void setZeroes(int[][] matrix) {
        int rownum = matrix.length;
        if (rownum == 0) return;
        int colnum = matrix[0].length;
        if (colnum == 0) return;

        boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;

        // Does first colnum have zero?
        for (int j = 0; j < colnum; ++j) {
            if (matrix[0][j] == 0) {
                hasZeroFirstColumn = true;
                break;
            }
        }

        // Does first row have zero?
        for (int i = 0; i < rownum; ++i) {
            if (matrix[i][0] == 0) {
                hasZeroFirstRow = true;
                break;
            }
        }

        // find zeroes and store the info in first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes except the first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        // set zeroes for first row and column if needed
        if (hasZeroFirstRow) {
            for (int j = 0; j < colnum; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (hasZeroFirstColumn) {
            for (int i = 0; i < rownum; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 频率 ：12
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n     合并两个有序数组
     *              <p>
     *              给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = n + m - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) nums1[index--] = nums1[i--];
        while (j >= 0) nums1[index--] = nums2[j--];
    }

    /**
     * 频率 ：13 自己写的不一定对
     *
     * @param l1
     * @param l2
     * @return 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        while (l1Current.next != null) {
            newNode.value = (l1Current.value + l2Current.value) % 10;
            newNode.next.value = (l1Current.next.value + l2Current.next.value) % 10;
            if (newNode.value > 9) {
                newNode.next.value += 1;
            }
            l1Current = l1Current.next;
            l2Current = l2Current.next;
        }
        return newNode;
    }

    /**
     * 频率 ：14
     *
     * @param lists
     * @return Merge k Sorted Lists
     * 初见之下，最容易想到的方法是“归并排序”（Merging Sort）：将两个或两个以上的有序表组合成一个新的有序表，
     * 无论是顺序存储结构还是链式存储结构，对于任何两个长度分别为m和n的有序表，其组合都可在O(m+n)的时间复杂度量级上完成。
     * 对于K个有序表，假设共有N个元素，且这些有序表初始状态都不为空，每个有序表平均拥有N/K个元素。
     * 最常用的方法是采用“二分”的思想进行两两合并：第一轮循环，
     * 有序表lists[0]与lists[(K+1)/2]，lists[1]与lists[(K+1)/2+1]，lists[2]与lists[(K+1)/2+2]....，lists[K/2-1]与lists[K-1]。
     * 这样K个有序表就被组合成了K/2个有序表；第二轮循环后将减少为K/4个有序表；直到组合成一个具有N个元素的有序表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int len = lists.length;

        if (len == 1)
            return lists[0];

        while (len > 1)//基于“二分”思想进行链表的两两组合
        {
            int mid = (len + 1) / 2;//二分
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists1(lists[i], lists[i + mid]);
            }
            len = mid;
        }
        return lists[0];
    }

    //有序链表的组合，L1和L2为头结点，归并排序的核心思想
    public ListNode mergeTwoLists1(ListNode L1, ListNode L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;

        ListNode head = new ListNode(0);//保存结果的链表，头结点初始化
        ListNode phead = head;

        while (L1 != null && L2 != null)//两个链表归并排序
        {
            if (L1.value <= L2.value) {
                phead.next = L1;//接入结果链表
                phead = phead.next;//移动指针
                L1 = L1.next;
            } else {
                phead.next = L2;
                phead = phead.next;
                L2 = L2.next;
            }
        }
        if (L1 != null)
            phead.next = L1;
        else
            phead.next = L2;

        return head.next;//初始化的第一个节点不属于结果
    }


    /**
     * 频率 ：15
     *
     * @param nums
     * @param val
     * @return 给定 nums = [3,2,2,3]，val = 3，
     * 你的函数应该返回 长度 = 2，数组的前两个元素是 2。
     * 移除元素
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length < 0) {
            return 0;
        }
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }

    /**
     * 频率 ：16
     * 全排列
     *
     * @param nums
     * @return [1, 2, 3] 具有如下排列：
     * <p>
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    // 最终返回的结果集
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return res;

        // 采用前后元素交换的办法，dfs解题
        exchange(nums, 0, len);
        return res;
    }

    public void exchange(int[] nums, int i, int len) {
        // 将当前数组加到结果集中
        if (i == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(nums[j]);
            }
            res.add(list);
            return;
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            exchange(nums, i + 1, len);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 频率 ：17
     * 字谜分组
     *
     * @param strs
     * @return 例如，给定 ["eat", "tea", "tan", "ate", "nat", "bat"]，返回：
     * <p>
     * [
     * ["ate", "eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortString = String.valueOf(chars);
            map.putIfAbsent(sortString, new ArrayList<String>());
            map.get(sortString).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 频率 ：18
     * 二进制求和
     *
     * @param a
     * @param b
     * @return 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * <p>
     * 案例：
     * a = "11"
     * b = "1"
     * 返回 "100"
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() <= 0) {
            return b;
        }
        if (b == null || b.length() <= 0) {
            return a;
        }
        int lengthA = a.length();
        int lengthB = b.length();
        boolean isAShort = lengthA <= lengthB;

        String shortStr = isAShort ? a : b;
        String longStr = isAShort ? b : a;
        int longLength = longStr.length();
        boolean isNextAdd1 = false;
        StringBuilder newString = new StringBuilder();
        for (int i = shortStr.length() - 1; i >= 0; i--) {
            char shortChar = shortStr.charAt(i);
            char longChar = longStr.charAt(i);
            if (isNextAdd1) {
                if ((longChar == '1' && shortChar == '1')) {
                    newString.append('1');
                    isNextAdd1 = true;
                } else if ((longChar == '0' && shortChar == '1')
                        || (longChar == '1' && shortChar == '0')) {
                    newString.append('0');
                    isNextAdd1 = true;
                } else if (longChar == '0' && shortChar == '0') {
                    newString.append('1');
                    isNextAdd1 = false;
                }
            } else {
                if ((longChar == '1' && shortChar == '1')) {
                    newString.append('0');
                    isNextAdd1 = true;
                } else if ((longChar == '0' && shortChar == '1')
                        || (longChar == '1' && shortChar == '0')) {
                    newString.append('1');
                    isNextAdd1 = false;
                } else if (longChar == '0' && shortChar == '0') {
                    newString.append('0');
                    isNextAdd1 = false;
                }
            }
            longLength--;
        }
        if (longLength > 0) {
            for (int i = longLength - 1; i > 0; i--) {
                newString.append(longStr.charAt(i));
            }
        }
        return newString.reverse().toString();
    }

    /**
     * 频率 ：19
     * x 的平方根
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842..., 由于我们想返回一个整数，小数部分将被舍去。
     * 二分搜索折半查找
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int middle = 0;
        while (left < right) {
            middle = left + (right - left) / 2;
            if (x / middle >= middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right - 1;
    }

    /**
     * 频率 ：20
     * 组合
     *
     * @param n
     * @param k
     * @return 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 例如，
     * 如果 n = 4 和 k = 2，组合如下：
     * <p>
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> unit = new ArrayList<>();
        comeback(1, k, n, unit, result);
        return result;
    }

    private void comeback(int temp, int k, int n, List<Integer> unit, List<List<Integer>> result) {
        if (unit.size() == k) {
            result.add(new ArrayList<Integer>(unit));
        }
        for (int i = temp; i < n; i++) {
            unit.add(i);
            comeback(i + 1, k, n, unit, result);
            unit.remove(unit.size() - 1);//TODO 不理解
        }
    }

    /**
     * 频率 ：21
     * 91. 解码方法
     *
     * @param s
     * @return 包含 A-Z 的字母的消息通过以下规则编码：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个包含数字的编码消息，请确定解码方法的总数。
     * <p>
     * 例如，
     * 给定消息为 "12"， 它可以解码为 "AB"（1 2）或 "L"（12）。
     * <p>
     * "12" 的解码方法为 2 种。
     */
    public int numDecodings(String s) {
        return 0;
    }

    /**
     * 频率 ：22
     * 102. 二叉树的层次遍历
     *
     * @param
     * @return 给定一个二叉树，返回其按层次遍历的节点值
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果为：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> unit = new ArrayList<>();
        while (root.left != null && root.right != null) {

        }
        return null;
    }

    /**
     * 频率 ：23
     * 求根叶数字总和
     *
     * @param root
     * @return <p>
     * 给定一个只包含 0-9 数字的二叉树，每个根到叶的路径可以代表一个数字。
     * 例如，从根到叶路径 1->2->3则代表数字 123。
     * 查找所有根到叶数字的总和。
     * 例如，
     * 1
     * / \
     * 2   3
     * 根到叶子路径 1->2 表示数字 12。
     * 根到叶子路径 1->3 表示数字 13。
     * 返回总和 = 12 + 13 = 25。
     */
    public int sumNumbers(TreeNode root) {

        return 1;
    }

    /**
     * 频率 ：24
     * 分割回文串
     *
     * @param s
     * @return <p>
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * 返回 s 所有可能的分割方案。
     * 例如，给出 s = "aab",
     * 返回
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    /**
     * @param string
     * @return 求字符串中不重复字符串的长度
     */
    public int bestLengthOfString(String string) {
        if (string == null) {
            return 0;
        }
        if (string.length() <= 1) {
            return string.length();
        }
        HashSet<Character> characters = new HashSet<>();

        int i = 0;
        int pre = 0;
        int max_index = 0;
        int length = string.length();
        while (i < length) {
            if (characters.contains(string.charAt(i))) {
                if (i - pre > max_index) {
                    max_index = i - pre;
                }
                while (string.charAt(pre) != string.charAt(i)) {
                    pre++;
                    characters.remove(pre);
                }
                pre++;
            } else {
                characters.add(string.charAt(i));
            }
            i++;
        }
        max_index = Math.max(i - pre, max_index);
        return max_index;
    }

    /**
     * 二维有序数组查找
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        return 1;
    }

    static int index = 0;
    static Object LOCK = new Object();

    /**
     * 两个线程交替打印字符串
     */
    public void threadPrintStr() {
        final String printStr = "i think this is ok";
        final char[] chars = printStr.toCharArray();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (index < chars.length) {
                    synchronized (LOCK) {
                        if (index % 2 == 0) {
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("thread a = " + chars[index]);
                        index++;
                        LOCK.notify();
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (index < chars.length) {
                    synchronized (LOCK) {
                        if (index % 2 == 1) {
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("thread b = " + chars[index]);
                        index++;
                        LOCK.notify();
                    }
                }
            }
        });
        a.start();
        b.start();
    }

    /**
     * @param x 自己写的
     * @return 反转整数 利用字符串的方式
     */
    public int reverse(int x) {
        String revertString = String.valueOf(x);
        StringBuilder newString = new StringBuilder();
        int length = revertString.length() - 1;
        int last = 0;
        if (x < 0) {
            last = 1;
        }
        for (int i = length; i >= last; i--) {
            newString.append(revertString.charAt(i));
        }
        int revertInt = Integer.valueOf(newString.toString());
        if (x < 0) {
            revertInt = -revertInt;
        }
        return revertInt;
    }

    /**
     * @param x
     * @return 反转整数 整数取余的方式
     */
    public int reverse1(int x) {
        boolean negative = x > 0;
        if (negative) {
            x = -x;
        }
        int r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (negative) {
            r = -r;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            r = 0;
        }
        return r;
    }

    class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }

    /**
     * @param head
     * @param n    移除单链表的倒数N个值
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cureet = head;
        ListNode next = head.next;
        while (next != null) {
            length++;
            next = next.next;
        }
        if (n > length) {
            return null;
        }
        int i = 0;
        while (i + n < length) {
            i++;
            cureet = head.next;
        }
        cureet.next = cureet.next.next;
        return head;
    }

    /**
     * @param head
     * @param n    移除单链表的倒数N个值
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<ListNode>();
        ListNode start = new ListNode(0);
        start.next = head;
        nodeList.add(start);

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int index = nodeList.size() - n;
        nodeList.get(index - 1).next = nodeList.get(index).next;

        return nodeList.get(0).next;
    }

    /**
     * @param n
     * @return 生成括号
     * 给 n 对括号，写一个函数生成所有合适的括号组合。
     * 比如，给定 n = 3，一个结果为：
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }

    /**
     * @param left
     * @param right
     * @param out
     * @param res   没太看懂 TODO
     */
    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }

    /**
     * @param head
     * @return 交换相邻结点
     * 给定 1->2->3->4，你应该返回 2->1->4->3
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null && next != null) {
            int value = current.value;
            current.value = next.value;
            next.value = value;
            current = next.next;
            if (current == null) {
                break;
            }
            next = current.next;
        }
        return head;
    }


    /**
     * @param nums
     * @return 从排序数组中删除重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 0) {
            return 0;
        }
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }
        number++;
        return number;
    }


    /**
     * @param nums
     * @param k
     * @return Kth Largest Element in an Array
     * 查找第K大的数 利用快排
     */
    public int findKthLargest(int[] nums, int k) {
        return k;
    }

}
