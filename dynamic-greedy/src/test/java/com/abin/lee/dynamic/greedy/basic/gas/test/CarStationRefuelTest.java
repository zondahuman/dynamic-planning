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
        System.out.println("result=" + result);
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
