package com.abin.lee.dynamic.greedy.basic.gas;

import com.abin.lee.dynamic.common.JsonUtil;

/**
 * Created by abin on 2018/5/13 20:35.
 * dynamic-planning
 * LeetCode Gas Station
 * https://leetcode.com/problems/gas-station/description/
 * https://blog.csdn.net/kenden23/article/details/14106137
 * 这道转圈加油问题不算很难，只要想通其中的原理就很简单。我们首先要知道能走完整个环的前提是gas的总量要大于cost的总量，这样才会有起点的存在。
 * 假设开始设置起点start = 0, 并从这里出发，如果当前的gas值大于cost值，就可以继续前进，此时到下一个站点，剩余的gas加上当前的gas再减去cost，
 * 看是否大于0，若大于0，则继续前进。当到达某一站点时，若这个值小于0了，则说明从起点到这个点中间的任何一个点都不能作为起点，
 * 则把起点设为下一个点，继续遍历。当遍历完整个环时，当前保存的起点即为所求。
 * https://www.cnblogs.com/grandyang/p/4266812.html
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println("result=" + JsonUtil.toJson(result));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }
        if (total < 0)
            return -1;
        else
            return j + 1;
    }


}
