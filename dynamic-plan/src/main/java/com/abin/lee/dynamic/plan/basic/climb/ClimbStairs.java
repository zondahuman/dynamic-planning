package com.abin.lee.dynamic.plan.basic.climb;

/**
 * Created by abin on 2017/11/20 2017/11/20.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.climb
 * http://www.jianshu.com/p/514d535eceab
 * 爬楼梯
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int way = 20 ;

        int result = climbStairs(way);
        System.out.println("result=" + result);

        int result1 = climbStairsDynamic(way);
        System.out.println("result1=" + result1);
    }

    /**
     * 爬楼梯---递归
     * http://blog.csdn.net/happyaaaaaaaaaaa/article/details/48948247
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);       //Time Limit Exceeded when n >= 42
    }

    /**
     * 爬楼梯---动态规划
     * http://blog.csdn.net/happyaaaaaaaaaaa/article/details/48948247
     * @param n
     * @return
     */
    public static int climbStairsDynamic(int n) {
        if(n <= 2) return n;
        int a = 1;//只有1级台阶的情况
        int b = 2;//有2级台阶的情况
        int tmp = 0;//辅助变量
        for(int i = 3;i <= n;i++){
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }

    public static int climbStairsDp(int n){
        if (n == 1) {
            return 1;
        }
        int[] cb = new int[n+1];
        cb[1] = 1;
        cb[2] = 2;
        for (int i = 3; i <=n ; i++) {
            cb[i] = cb[i-1] + cb[i-2];
        }
        return cb[n];
    }

}
