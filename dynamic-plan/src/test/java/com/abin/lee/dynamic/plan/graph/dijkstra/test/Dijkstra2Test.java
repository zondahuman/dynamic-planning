package com.abin.lee.dynamic.plan.graph.dijkstra.test;

/**
 * Created by abin on 2018/6/4.
 */
public class Dijkstra2Test {
    public static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //邻接矩阵
        int[][] weight = {
                {0,    3, 2000, 7, MAX},
                {3,    0,    4, 2, MAX},
                {MAX,  4,    0, 5, 4},
                {7,    2,    5, 0, 6},
                {MAX, MAX,   4, 6, 0}
        };
        int start = 0;
        int[] shortPath = dijkstra(weight, start);
        for (int i = 0; i < shortPath.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
        }

    }

    public static int[] dijkstra(int[][] weight, int start){
        int length = weight.length ;
        int[] shortPath = new int[length];
        int[] visited = new int[length];
        visited[start] = 1;
        shortPath[0] = 0;

        for (int count = 1; count <length ; count++) {
            int k = -1 ;
            int dest = Integer.MAX_VALUE ;
            for (int i = 0; i <length ; i++) {
                if(visited[i] == 0 && weight[start][i] < dest){
                    dest = weight[start][i];
                    k = i ;
                }
            }
            shortPath[k] = dest ;
            visited[k] = 1 ;
            for (int i = 0; i <length ; i++) {
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
                    weight[start][i] = weight[start][k] + weight[k][i];
                }
            }
        }
        return shortPath;
    }

}
