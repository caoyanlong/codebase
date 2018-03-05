package com.self.lib.Algorithm;

import java.util.HashSet;

/**
 * Created by cyl on 2018/3/2.
 */

public class Algorithm {
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
     * @param str
     * @return 字符串转化成整数
     */
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                isPos = c == '+' ? true : false;
            } else if (c >= '0' && c <= '9') {
                // 检查溢出情况
                if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos ? result : -result;
            }
        }
        return isPos ? result : -result;
    }
}
