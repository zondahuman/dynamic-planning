package com.abin.lee.dynamic.plan.graph.search.matrix.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abin on 2017/11/13 18:36.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.graph
 */
public class DepthBoardSearch {


    /**
     * 深度遍历
     * DFSearch
     * @param node
     *          当前节点
     * @param visited
     *          被访问过的节点列表
     */
    public void searchTraversing(GraphNode node, List<GraphNode> visited) {
        // 判断是否遍历过
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.println("节点：" + node.getLabel());
        for (int i = 0; i < node.edgeList.size(); i++) {
            searchTraversing(node.edgeList.get(i).getNodeRight(), visited);
        }
    }

    /**
     * 广度优先搜索
     * BFSearch
     * @param node
     *          搜索的入口节点
     */
    public void searchTraversing(GraphNode node) {
        List<GraphNode> visited = new ArrayList<GraphNode>(); // 已经被访问过的元素
        Queue<GraphNode> q = new LinkedList<GraphNode>(); // 用队列存放依次要遍历的元素
        q.offer(node);

        while (!q.isEmpty()) {
            GraphNode currNode = q.poll();
            if (!visited.contains(currNode)) {
                visited.add(currNode);
                System.out.println("节点：" + currNode.getLabel());
                for (int i = 0; i < currNode.edgeList.size(); i++) {
                    q.offer(currNode.edgeList.get(i).getNodeRight());
                }
            }
        }
    }



}
