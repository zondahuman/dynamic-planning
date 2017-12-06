package com.abin.lee.dynamic.plan.basic.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2017/12/6 18:11.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strings
 * https://segmentfault.com/a/1190000007879305
 */
public class RepeatCommonStringTest {

    public static void main(String[] args) {
        RepeatCommonStringTest s = new RepeatCommonStringTest();
        System.out.println(s.findNoDuplicate("bbbbbb"));
        System.out.println(s.findNoDuplicate("abcabcbb"));
        System.out.println(s.findNoDuplicate("abcbcdabb"));
        System.out.println(s.findNoDuplicate("aab"));
        System.out.println(s.findNoDuplicate("dvdf"));
        System.out.println(s.findNoDuplicate("advdf"));
        /**
         * main方法执行的测试结果为:
         1
         3
         4
         2
         3
         3
         */
    }

    public static int findNoDuplicate(String param) {
        Map<Character, Integer> record = new HashMap<>();
        int current = 0;
        int max = 0;
        for (int i = 0; i < param.length(); i++) {
            if (record.containsKey(param.charAt(i))) {
                current = Math.max(record.get(param.charAt(i)) + 1, current);
            }
            max = Math.max(i - current + 1, max);
            record.put(param.charAt(i), i);
        }
        return max;
    }

    public static int findNoDuplicateBySet(String param) {

        return 0;
    }

}