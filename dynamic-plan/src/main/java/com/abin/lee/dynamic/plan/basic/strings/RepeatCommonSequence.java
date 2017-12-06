package com.abin.lee.dynamic.plan.basic.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2017/12/6 14:45.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strings
 */
public class RepeatCommonSequence {

    public static void main(String[] args) {
        String param = "abcdaef";
        int result = lengthOfLongestSubstring(param);
        System.out.println("result="+result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // Hashmap中存放的是 字符-索引
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //如果map里已经有这个index[j]处的char，将i赋成j+1。
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);//注意这里的max，适用于“abba”这种情况，“a”虽然存在于map中了，但i也不移动。
            // 将char加入哈希表中，value为索引值j。
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    

}
