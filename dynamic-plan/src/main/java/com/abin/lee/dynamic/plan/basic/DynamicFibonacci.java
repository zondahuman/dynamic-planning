package com.abin.lee.dynamic.plan.basic;

/**
 * Created by abin on 2017/11/21 2017/11/21.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic
 */
public class DynamicFibonacci {
    public static void main(String[] args) {
        int way = 20 ;

        int result = fibonacci(way);
        System.out.println("result=" + result);
        int result1 = fibonacciDynamic(way);
        System.out.println("result1=" + result1);

    }

    /**
     * Fibonacci数列---递归
     * http://www.jianshu.com/p/514d535eceab
     * @param n
     * @return
     */
    public static int fibonacci(int n) { // 计算Fibonacci数列的第n项（二分递归版）：O(2^n)
        return (2 > n) ? n // 若到达递归基，直接取值
                : fibonacci(n - 1) + fibonacci(n - 2); // 否则，递归计算前两项，其和即为正解
    }

    /**
     * Fibonacci数列---动态规划
     * http://www.jianshu.com/p/514d535eceab
     * @param n
     * @return
     */
    public static Integer fibonacciDynamic(int n) { // 计算Fibonacci数列的第n项（动态规划版）：O(n)
        if(n < 2) return n;
        int a = 0;//第一个值
        int b = 1;//第二个值
        int tmp = 0;//辅助变量
        for(int i = 2;i <= n;i++){
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }
}
