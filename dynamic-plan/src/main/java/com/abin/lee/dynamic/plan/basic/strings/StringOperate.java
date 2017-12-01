package com.abin.lee.dynamic.plan.basic.strings;

import org.junit.Test;

/**
 * Created by abin on 2017/12/1 2017/12/1.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strings
 */
public class StringOperate {

    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        int lengtha = A.length();
        int lengthb = B.length();
        String maxStr = (lengtha >= lengthb) ? A : B;
        String minStr = (lengtha >= lengthb) ? B : A;
        for (int i = minStr.length(); i >= 1; i--) {
            for (int j = 0; j < minStr.length(); j++) {
                String temp = minStr.substring(j, i);
                if (maxStr.contains(temp))
                    return temp.length();
            }
        }
        return 0;
    }

    public int longestCommonSubsequence1(String A, String B) {
        int lengtha = A.length();
        int lengthb = B.length();
        String maxStr = (lengtha >= lengthb) ? A : B;
        String minStr = (lengtha >= lengthb) ? B : A;
        int maxLength = 0;
        for (int j = minStr.length(); j >= 1; j--) {
            for (int i = 0; i < minStr.length(); i++) {
                String temp = minStr.substring(i, j);
                if (maxStr.contains(temp)) {
                    int tempLength = temp.length();
                    maxLength = Math.max(maxLength, tempLength);
                }
            }
        }
        return maxLength;
    }

    @Test
    public void testLongestCommonSubsequence() {
//        String param1 = "abcdefg";
//        String param2 = "cdefghijk";
        String param1 = "bedaacbade";
        String param2 = "dccaeedbeb";
        int length = longestCommonSubsequence(param1, param2);
//        int length = longestCommonSubsequence1(param1, param2);
        System.out.println("length=" + length);
    }
}
