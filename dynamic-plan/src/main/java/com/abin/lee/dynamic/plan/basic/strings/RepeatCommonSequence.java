package com.abin.lee.dynamic.plan.basic.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by abin on 2017/12/6 14:45.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strings
 * https://www.cnblogs.com/kkkky/p/7687083.html
 * 给定字符串的最长不重复子串
 *     最长公共子串（Longest Common Substring）与最长公共子序列（Longest Common Subsequence）的区别： 子串要求在原字符串中是连续的，而子序列则只需保持相对顺序一致，并不要求连续。例如X = {a, Q, 1, 1}; Y = {a, 1, 1, d, f}那么，{a, 1, 1}是X和Y的最长公共子序列，但不是它们的最长公共字串。
 */
public class RepeatCommonSequence {

    public static void main(String[] args) {
//        String param = "abcdaef";
        String param = "dvdf";
        int result = lengthOfLongestSubstring(param);
        System.out.println("result="+result);
        int result2 = longestNoDuplicateSubstring(param);
        System.out.println("result2="+result2);
        int result3 = longestSubstring(param);
        System.out.println("result3="+result3);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        Map<Character, Integer> map = new HashMap<>(); // Hashmap中存放的是 字符-索引
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //如果map里已经有这个index[j]处的char，将i赋成j+1。
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            max = Math.max(max, j - i + 1);//注意这里的max，适用于“abba”这种情况，“a”虽然存在于map中了，但i也不移动。
            // 将char加入哈希表中，value为索引值j。
            map.put(s.charAt(j), j);
        }
        return max;
    }


    public static int longestNoDuplicateSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static int longestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }





}
