package com.abin.lee.dynamic.plan.basic.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by abin on 2017/12/1 2017/12/1.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strings
 * https://www.cnblogs.com/hapjin/p/5572483.html
 */
public class LongestCommonSequence {

    //求解str1 和 str2 的最长公共子序列
    public static int Lcs1(String str1, String str2){
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for(int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for(int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

        for(int i = 1; i <= str1.length(); i++)
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else if(c[i][j-1] > c[i-1][j])
                    c[i][j] = c[i][j-1];
                else
                    c[i][j] = c[i-1][j];
            }
        return c[str1.length()][str2.length()];
    }

    /**
     * 求给定两个字符串的最大公共子串，必须连续的公共子串，不连续的公共子串处理不了
     * @param param1
     * @param param2
     * @return
     */
    public static String maxSimpleCommonString(String param1, String param2) {
        String max = param1.length() >= param2.length() ? param1 : param2;
        String min = param1.length() == max.length() ? param2 : param1;
        for (int i = min.length() - 1; i >= 1; i--) {
            for (int j = 0; j <= min.length()-i; j++) {
                String temp = min.substring(j, i);
                if (max.contains(temp))
                    return temp;
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 求给定两个字符串的最大公共子串长度(最大公共子串可以不连续，可以跳跃过某些字母)
     * @param param1
     * @param param2
     * @return
     */
    public static int lcs(String param1, String param2){
        int[][] common = new int[param1.length()+1][param2.length()+1];
        for (int i = 1; i <= param1.length(); i++) {
            for (int j = 1; j <= param2.length(); j++) {
                if(i == 0 || j == 0) {
                    common[i][j] = 0;
                }else if(param1.charAt(i-1) == param2.charAt(j-1)){
                    common[i][j] = common[i-1][j-1] + 1;
                }else{
                    common[i][j] = Math.max(common[i-1][j], common[i][j-1]);
                }
            }
        }
        return common[param1.length()][param2.length()];
    }


    //test
    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
//        String str1 = "";
//        String str2 = "";
        int result = Lcs1(str1, str2);
        System.out.println("result="+result);
        int result2 = lcs(str1, str2);
        System.out.println("result2="+result2);
        String str5 = "abcdefghab";
        String str6 = "cdefghijk";
        String result5 = maxSimpleCommonString(str5, str6);
        System.out.println("result5="+result5);
    }
}
