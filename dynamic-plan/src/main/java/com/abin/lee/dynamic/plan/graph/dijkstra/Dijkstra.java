package com.abin.lee.dynamic.plan.graph.dijkstra;

import com.abin.lee.dynamic.common.JsonUtil;

/**
 * Created by abin on 2017/11/14 .
 * 有向图最短路径问题
 * https://www.cnblogs.com/biyeymyhjob/archive/2012/07/31/2615833.html
 * https://blog.csdn.net/heroacool/article/details/51014824
 */
public class Dijkstra {
    public static int MAX = 10000;

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
        int[] shortPath = Dijsktra(weight, start);
        for (int i = 0; i < shortPath.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
        }
        System.out.println("-------------------------------------------------------------");
        int[][] weight1 = {
                {0,    3, 2000, 7, MAX},
                {3,    0,    4, 2, MAX},
                {MAX,  4,    0, 5, 4},
                {7,    2,    5, 0, 6},
                {MAX, MAX,   4, 6, 0}
        };
        int[] shortestPath = shortest(weight1, start);
        System.out.println("shortestPath=" + JsonUtil.toJson(shortestPath));

    }

    //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
    //返回一个int[] 数组，表示从start到它的最短路径长度
    public static int[] Dijsktra(int[][] weight, int start) {
        int length = weight.length;
        //存放从start到其他各点的最短路径
        int[] shortPath = new int[length];
        //存放从start到其他各点的最短路径的字符串表示
        String[] path = new String[length];
        for (int i = 0; i < length; i++) {
            path[i] = start + "-->" + i;
        }
        //标记当前该顶点的最短路径是否已经求出,1表示已求出
        int[] visited = new int[length];
        shortPath[start] = 0;
        visited[start] = 1;
        for (int count = 1; count <= length - 1; count++) {
            //选出一个距离初始顶点start最近的未标记顶点
            int k = -1;
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;
            //以k为中间点，修正从start到未访问各点的距离   //判断是直接v[0]连接v[j]短，还是经过v[k]连接v[j]更短
            for (int i = 0; i < length; i++) {
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i]);
        }
        System.out.println("=====================================");
        return shortPath;
    }
    //{0, 3, 2000, 7, MAX},
    //{3, 0, 4, 2, MAX},
    //{MAX, 4, 0, 5, 4},
    //{7, 2, 5, 0, 6},
    //{MAX, MAX, 4, 6, 0}


    //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
    //返回一个int[] 数组，表示从start到它的最短路径长度
    public static int[] shortest(int[][] weight, int start) {
        int length = weight.length;
        //存放从start到其他各点的最短路径
        int[] shortPath = new int[length];
        shortPath[start] = 0;
        //标记当前该顶点的最短路径是否已经求出,1表示已求出
        int[] visited = new int[length];
        visited[start] = 1;
        for (int count = 1; count <= length - 1; count++) {
            //选出一个距离初始顶点start最近的未标记顶点
            int k = -1;
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }
            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;
            //以k为中间点，修正从start到未访问各点的距离   //判断是直接v[0]连接v[j]短，还是经过v[k]连接v[j]更短
            for (int i = 0; i < length; i++) {
                if (visited[i] == 0 && dmin + weight[k][i] < weight[start][i]) {
                    weight[start][i] = dmin + weight[k][i];
                }
            }
        }

        return shortPath;
    }


}