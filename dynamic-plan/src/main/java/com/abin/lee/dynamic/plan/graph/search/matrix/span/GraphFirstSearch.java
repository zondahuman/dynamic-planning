package com.abin.lee.dynamic.plan.graph.search.matrix.span;


import java.util.LinkedList;
import java.util.Queue;


/**
 *
 *基于邻接矩阵实现的深度和广度遍历
 *
 */
public class GraphFirstSearch {
    final static int INF = 100000;
    final int max = 100;
    int[] vexs = new int[max]; //存放顶点的数组
    int[][] edges = new int[max][max]; //存放边的数组

    /*
     * 创建邻接矩阵
     */
    public void createGraph(GraphFirstSearch graph , int[][] A, int[] vs) {
        vexs = vs;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A.length;j++) {
                graph.edges[i][j] = A[i][j];
            }
        }

    }

    /*
     * 输出邻接矩阵
     */
    public void print_Graph(GraphFirstSearch graph) {
        for(int i=0;i<graph.vexs.length;i++) {
            for(int j=0;j<graph.vexs.length;j++) {
                if (graph.edges[i][j] == INF) {
                    System.out.printf("%4s", "/");
                }else {
                    System.out.printf("%4d",graph.edges[i][j]);
                }
            }
            System.out.println("\n");
        }
    }


    /**
     * 找出给定顶点的第一个邻接顶点
     * @param graph
     * @param v
     * @return
     */
    public int getFirst(GraphFirstSearch graph, int v) {
        for(int i=0;i<graph.vexs.length;i++) {
            if (graph.edges[v][i]==1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 找出给定顶点v的第k个邻接顶点的邻接顶点
     * @param graph
     * @param v
     * @param k
     * @return
     */
    public int getNext(GraphFirstSearch graph , int v, int k) {
        for(int i=k+1;i<graph.vexs.length;i++) {
            if (graph.edges[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }


    /*
     * 深度遍历
     */
    public void DFS(GraphFirstSearch graph , int v, int[] visited) {
        int next;
        System.out.println(v);
        visited[v] =1;
        next=graph.getFirst(graph, v);
        while (next!=-1) {
            if (visited[next]==0) {
                graph.DFS(graph, next,visited);
            }
            next=graph.getNext(graph, v, next);
        }
    }
    /*
     * 广度遍历
     */
    public void BFS(GraphFirstSearch graph, int v, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int next;
        queue.add(v);
        visited[v]=1;
        while (!queue.isEmpty()) {
            next=queue.remove();
            System.out.println(next);
            int vex = graph.getFirst(graph, next);
            while (vex!=-1) {
                if (visited[vex]==0) {
                    queue.add(vex);
                    visited[vex]=1;
                }
                vex=graph.getNext(graph, next, vex);
            }
        }

    }


    public static void main(String[] args) {
        int[] vs  = {0,1,2,3,4};
        int[][] A = {
                {INF,1,INF,1,INF},
                {1,INF,1,INF,INF},
                {INF,1,INF,1,1},
                {1,INF,1,INF,1},
                {INF,INF,1,1,INF}
        };

        GraphFirstSearch graph = new GraphFirstSearch();
        graph.createGraph(graph, A, vs);
        graph.print_Graph(graph);
        int[] visited = new int[100];
        int[] visited1 = new int[100];
        graph.DFS(graph, 0,visited);
        System.out.println("-----------");
        graph.BFS(graph, 0, visited1);
    }

}