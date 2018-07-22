package com.abin.lee.dynamic.program.special.maze;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by abin on 2018/7/22.
 * 在以下程序中“＃”代表不可通过，“．”代表可以通过。
 *
 迷宫算法（ＪＡＶＡ实现）
 * https://blog.csdn.net/abinxue/article/details/7365313
 */
public class Maze {
    //内部类
    class Cell {
        private int row;
        private int col;
        private Cell from;//指向父节点

        public Cell(int row, int col, Cell from) {
            this.row = row;
            this.col = col;
            this.from = from;
        }
    }

    char[][] maze =
            {{'#', '#', '#', '#', 'B', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#'},
            {'#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#'},
            {'#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#'},
            {'#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#'},
            {'#', '#', '.', '#', '.', '#', '#', '#', '.', '#', '.', 'A'},
            {'#', '#', '.', '#', '#', '#', '.', '.', '.', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

    public void show() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++)
                System.out.print(" " + maze[i][j]);
            System.out.println();
        }
    }


    //把与from集合中相邻的可染色节点染色，被染色节点记入 dest
    //一旦发现出口将被染色，则返回当前的“传播源”节点
    public Cell colorCell(Set<Cell> from, Set<Cell> dest) {
        Iterator<Cell> it = from.iterator();
        while (it.hasNext()) {
            Cell a = it.next();
            Cell[] c = new Cell[4];
            c[0] = new Cell(a.row - 1, a.col, a); //向上
            c[1] = new Cell(a.row, a.col - 1, a); //向左
            c[2] = new Cell(a.row + 1, a.col, a); //向下
            c[3] = new Cell(a.row, a.col + 1, a); //向右

            for (int i = 0; i < 4; i++) {
                if (c[i].row < 0 || c[i].row >= maze.length) continue;
                if (c[i].col < 0 || c[i].col >= maze[0].length) continue;
                char x = maze[c[i].row][c[i].col];
                if (x == 'B') return a;
                if (x == '.') {
                    maze[c[i].row][c[i].col] = '?';//对可通过路径进行标记
                    dest.add(c[i]);
                }
            }
        }
        return null;
    }


    public void resolve() {
        Set<Cell> set = new HashSet<Cell>();
        set.add(new Cell(9, 11, null));
        for (; ; ) {
            Set<Cell> set1 = new HashSet<Cell>();
            Cell a = colorCell(set, set1);
            if (a != null) {
                System.out.println("找到解！");
                while (a != null) {
                    maze[a.row][a.col] = '+';//标出通路路径
                    a = a.from;
                }
                break;
            }
            if (set1.isEmpty()) {
                System.out.println("无解！");
                break;
            }
            set = set1;
        }
    }


    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.show();
        maze.resolve();
        maze.show();
    }

}