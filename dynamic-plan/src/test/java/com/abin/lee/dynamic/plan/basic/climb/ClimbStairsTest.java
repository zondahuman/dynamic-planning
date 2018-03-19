package com.abin.lee.dynamic.plan.basic.climb;

/**
 * Created by abin on 2018/3/19 13:26.
 * dynamic-planning
 * com.abin.lee.dynamic.plan.basic.climb
 */
public class ClimbStairsTest {

    public static void main(String[] args) {
        int way = 20 ;

        int result1 = climbStairsDynamic(way);
        System.out.println("result1=" + result1);
    }


        public static int climbStairsDynamic(int n){
            if(n <= 2)
                return n ;
            int one = 1;
            int two = 2;
            int temp = 0;
            for (int i = 3; i <= n ; i++) {
                temp = one + two;
                one = two ;
                two = temp ;
            }
            return temp;
        }


}
