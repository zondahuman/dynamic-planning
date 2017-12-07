package com.abin.lee.dynamic.greedy.basic.gas;

/**
 * Created by abin on 2017/12/7 2017/12/7.
 * dynamic-planning
 * com.abin.lee.dynamic.greedy.basic.gas
 * 一、实验目的与要求
 1、掌握汽车加油问题的算法；
 2、进一步掌握贪心算法；
 二、实验题
 一辆汽车加满油后可以行驶N千米。旅途中有若干个加油站。若要使沿途的加油次数最少，设计一个有效的算法，指出应在那些加油站停靠加油。并证明你的算法能产生一个最优解。
 三、实验提示
 把两加油站的距离放在数组中，a[1..n]表示从起始位置开始跑，经过n个加油站，a[k]表示第k－1个加油站到第k个加油站的距离。汽车在运行的过程中如果能跑到下一个站则不加油，否则要加油。
 http://blog.51cto.com/qiangmzsx/824850
 */
public class GasStationRefuel {

    public static void main(String[] args) {
        int[] distance = new int[]{1,2,3,4,5,6,6};
        int totalJourney = 7;
        int result = carRefuel(distance, totalJourney);
        System.out.println("result=" + result);
    }

    /**
     *
     * @param distance  两加油站的距离放在数组中
     * @param n  一辆汽车加满油后可以行驶N千米
     * @return
     */
    public static int carRefuel(int[] distance, int n){
        int sum = 0;
        int journey = 0;
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] > n){
                System.out.println("Do not to the destation");
                return -1;
            }
        }
        for (int i = 0; i < distance.length; i++) {
            journey += distance[i];
            if(journey > n){
                sum++;
                journey = distance[i];
            }
        }
        return sum;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, index = 0;
        for (int i = 0; i < cost.length; i++) {
            int cur = gas[i] - cost[i];

            tank += cur;
            if (tank < 0) {//if sum < 0, index can only start from i + 1
                index = i + 1;
                tank = 0;
            }
            total += cur;
        }
        return total < 0 ? -1 : index;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;
    }


}
