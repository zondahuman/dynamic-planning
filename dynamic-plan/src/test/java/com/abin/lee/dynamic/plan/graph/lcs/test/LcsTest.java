package com.abin.lee.dynamic.plan.graph.lcs.test;

/**
 * Created by abin on 2017/12/1 2017/12/1.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.graph.lcs.test
 * https://leetcode.com/problems/delete-operation-for-two-strings/discuss/
 * https://www.cnblogs.com/hapjin/p/5572483.html
 */
public class LcsTest {

    public static int lcs(String param1, String param2) {
        int[][] dp = new int[param1.length() + 1][param2.length() + 1];
        for(int row = 0; row <= param1.length(); row++)
            dp[row][0] = 0;
        for(int column = 0; column <= param2.length(); column++)
            dp[0][column] = 0;
        for (int i = 1; i <= param1.length(); i++) {
            for (int j = 1; j <= param2.length(); j++) {
                    if (param1.charAt(i - 1) == param2.charAt(i - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
//        int val =  dp[param1.length()][param2.length()];
//        return param1.length() - val + param2.length() - val;
        return dp[param1.length()][param2.length()];
    }

    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
//        String str1 = "";
//        String str2 = "";
        int result = lcs(str1, str2);
        System.out.println(result);
    }
}
