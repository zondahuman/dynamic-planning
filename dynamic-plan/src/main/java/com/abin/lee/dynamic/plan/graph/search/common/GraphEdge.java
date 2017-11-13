package com.abin.lee.dynamic.plan.graph.search.common;

/**
 * Created by abin on 2017/11/13 17:35.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.graph
 * http://blog.csdn.net/lemon_tree12138/article/details/47319659
 * 2.图中的边：
 */
public class GraphEdge {

    private GraphNode nodeLeft;

    private GraphNode nodeRight;

    /**
     * @param nodeLeft
     *          边的左端
     * @param nodeRight
     *          边的右端
     */
    public GraphEdge(GraphNode nodeLeft, GraphNode nodeRight) {
        this.nodeLeft = nodeLeft;
        this.nodeRight = nodeRight;
    }

    public GraphNode getNodeLeft() {
        return nodeLeft;
    }

    public GraphNode getNodeRight() {
        return nodeRight;
    }

}