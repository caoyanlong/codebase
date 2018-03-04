package com.codebase.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * 频率 ：5
     *
     * @param l1
     * @param l2
     * @return 合并两个已排序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
     * @return 合并区间 Insert Interval
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
     * @param x
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

}
