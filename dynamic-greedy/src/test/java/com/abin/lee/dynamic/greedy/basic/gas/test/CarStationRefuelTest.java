package com.abin.lee.dynamic.greedy.basic.gas.test;

/**
 * Created by abin on 2017/12/7 2017/12/7.
 * dynamic-planning
 * com.abin.lee.dynamic.greedy.basic.gas.test
 */
public class CarStationRefuelTest {
    public static void main(String[] args) {
        int[] distance = new int[]{1,2,3,4,5,6,6};
        int totalJourney = 7;
        int result = carRefuel(distance, totalJourney);
//        int result = addRefuel(distance, totalJourney);
        System.out.println("result=" + result);
    }


    public static int addRefuel(int[] distance, int journey){
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] > journey)
                return -1;
        }
        int sum = 0;
        int num = 0;
        for (int i = 0; i < distance.length; i++) {
            sum+=distance[i];
            if(sum > journey){
                num++;
                sum = distance[i];
            }
        }
        return num;
    }

    public static int carRefuel(int[] distance, int totalJourney){
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] > totalJourney){
                return -1;
            }
        }
        int journey = 0;
        for (int i = 0; i < distance.length; i++) {
            journey += distance[i];
            if(journey > totalJourney){
                sum++;
                journey = distance[i];
            }
        }
        return sum;
    }
}
