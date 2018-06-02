package com.abin.lee.dynamic.plan.back;

/**
 * Created by abin on 2018/6/2 12:06.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.back
 */
public class BackPackTest {
    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
//        int c[][] = back(m, n, w, p);
        int c[][] = pack(m, n, w, p);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
        //printPack(c, w, m, n);

    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] back(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] value = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            value[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            value[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w[i - 1] <= j) {
                    if (value[i - 1][j] < (value[i - 1][j - w[i - 1]] + p[i - 1]))
                        value[i][j] = value[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        value[i][j] = value[i - 1][j];

                } else {
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        return value;
    }

    public static int[][] pack(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int[][] value = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            value[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            value[0][j] = 0;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (w[i - 1] <= j) {
                    if (value[i - 1][j] < (value[i - 1][j - w[i-1]] + p[i - 1]))
                        value[i][j] = value[i - 1][j - w[i-1]] + p[i - 1];
                    else
                        value[i][j] = value[i - 1][j];

                } else {
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        return value;
    }



}
