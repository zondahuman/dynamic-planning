package com.abin.lee.dynamic.plan.graph.pack.test;

import com.abin.lee.dynamic.common.JsonUtil;

/**
 * Created by abin on 2017/11/25 2017/11/25.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.graph.pack.test
 */
public class BackPackTest {

    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = pack(m, n, w, p);
//        System.out.printf("c[][] = "+ JsonUtil.toJson(c));
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m-1) {
                    System.out.println();
                }
            }
        }
    }

    /**
     *
     * @param m  表示背包的重量
     * @param n  表示物件的个数
     * @param w  物件的重量数组
     * @param p  物价的价值数组
     * @return
     */
    public static int[][] pack(int m, int n, int[] w, int[] p){
        //前n个物件放入了承重为m的背包所能得到的最大价值
        int[][] maxValue = new int[n][m];
        for (int i = 1; i <n ; i++)
            maxValue[i][0] = 0;
        for (int i = 1; i <m ; i++)
            maxValue[0][i] = 0;
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                if(w[i] < j){
                        maxValue[i][j] = Math.max(maxValue[i-1][j-w[i]]+p[i], maxValue[i-1][j]);
                }else{
                    maxValue[i][j] = maxValue[i-1][j];
                }
            }
        }
        return maxValue;
    }



}
