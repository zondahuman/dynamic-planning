package com.abin.lee.dynamic.plan.basic.strand;

/**
 * Created by abin on 2017/11/20 2017/11/20.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.strand
 */
public class DynamicString {
    public static void main(String[] args) {
        String str1 = "EDUCATIONAL";
        String str2 = "ADVANTAGE";
        int result = lcs(str1, str1.length(), str2, str2.length());
        System.out.println("result=" + result);
    }

    /**
     * http://www.jianshu.com/p/514d535eceab
     * 递归方式实现求两个字符串最长公共字序列的长度
     * @param str1 第一个字符串
     * @param m 第一个字符串需要比较的长度
     * @param str2 第二个字符串
     * @param n 第一个字符串需要比较的长度
     * @return
     */
    public static int lcs(String str1,int m,String str2,int n){
        if(m == 0 || n == 0) return 0;//如果其中有一个元素为空则返回0
        if(str1.charAt(m - 1) == str2.charAt(n - 1))
            return lcs(str1,m - 1,str2,n - 1) + 1;//如果需要比较的两个字符串最后一个字符相同则将问题缩小
        //剩下的情况则两个字符串的最后一个字符不相等，取两种情况中的最大值
        return Math.max(lcs(str1,m - 1,str2,n),lcs(str1,m,str2,n - 1));
    }

}
