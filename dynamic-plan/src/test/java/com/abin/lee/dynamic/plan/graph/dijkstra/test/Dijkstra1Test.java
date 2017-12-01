package com.abin.lee.dynamic.plan.graph.dijkstra.test;

/**
 * Created by abin on 2017/11/25 2017/11/25.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.graph.dijkstra.test
 */
public class Dijkstra1Test {
    public static int MAX = 10000;

    public static void main(String[] args) {
        //邻接矩阵
        int[][] weight = {
                {0, 3, 2000, 7, MAX},
                {3, 0, 4, 2, MAX},
                {MAX, 4, 0, 5, 4},
                {7, 2, 5, 0, 6},
                {MAX, MAX, 4, 6, 0}
        };
        int start = 0;
        int[] shortPath = dijkstra(weight, start);
        for (int i = 0; i < shortPath.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
        }

    }

   public static int[] dijkstra(int[][] input, int start){
       int length = input.length;
       int[] shortPath = new int[input.length];
       int[] flag = new int[input.length];

       shortPath[0] = 0;
       flag[0] = 1;
       Integer dest = Integer.MAX_VALUE;
       int k = -1;
       for(int i=0;i<length;i++){
            if(flag[i] == 0 && input[start][i] < dest){
                dest = input[start][i];
                k = i;
            }
       }




        return shortPath;
   }



}
