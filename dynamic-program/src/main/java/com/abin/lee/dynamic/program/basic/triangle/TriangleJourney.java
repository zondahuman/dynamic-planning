package com.abin.lee.dynamic.program.basic.triangle;

/**
 * Created by abin on 2017/12/7 2017/12/7.
 * dynamic-planning
 * com.abin.lee.dynamic.program.basic.triangle
 * http://blog.csdn.net/chriscute/article/details/53097032
 * https://leetcode.com/problems/triangle/description/
 */
public class TriangleJourney {
    /**
     * 比如，给出下列数字三角形：
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]
     从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
     * @param args
     */
    public static void main(String[] args) {
        int[][] triangle = {
                {2,0,0,0},
                {3,4,0,0},
                {6,5,7,0},
                {4,1,8,3}
        };

        int shortest = minimumTotal1(triangle);
        System.out.println("shortest="+shortest);
    }

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        // write your code here

    /*
    从二维数组的倒数第二行开始往上，每一行的元素改为下一行能与之
    相加的两个数较小者与其相加之后的和
    即minpath[i][j]=min{minpath[i+1][j],minpath[i+1][j+1]} + triangle[i][j]
    */
        int m = triangle.length;
        if(m==0)
            return 0;
        if(m==1)
            return triangle[0][0];
        for(int i=m-2;i>=0;i--)
            for(int j=0;j<=i;j++){
                if(triangle[i+1][j]>triangle[i+1][j+1])
                    triangle[i][j] += triangle[i+1][j+1];
                else
                    triangle[i][j] += triangle[i+1][j];
            }

        return triangle[0][0];
    }
    public static int minimumTotal1(int[][] triangle) {
    /*
    从二维数组的倒数第二行开始往上，每一行的元素改为下一行能与之
    相加的两个数较小者与其相加之后的和
    即minpath[i][j]=min{minpath[i+1][j],minpath[i+1][j+1]} + triangle[i][j]
    */
        int m = triangle.length;
        for(int i=m-2;i>=0;i--)
            for(int j=0;j<=i;j++){
                if(triangle[i+1][j]>triangle[i+1][j+1])
                    triangle[i][j] += triangle[i+1][j+1];
                else
                    triangle[i][j] += triangle[i+1][j];
            }

        return triangle[0][0];
    }
}
