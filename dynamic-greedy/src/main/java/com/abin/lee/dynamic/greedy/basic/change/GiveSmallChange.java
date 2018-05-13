package com.abin.lee.dynamic.greedy.basic.change;

/**
 * Created by abin on 2018/5/13 16:47.
 * dynamic-planning
 * com.abin.lee.dynamic.greedy.basic.change
 * 找零钱
 * https://www.cnblogs.com/yjqc/p/7607028.html
 */
public class GiveSmallChange {
    /**
     * 贪心算法，找零钱
     * 假设有100 50 10 1零钱供找零，输入找零的钱返回找零的钱和张数
     *
     * 思路：
     * while(能朝给定目标前进一步)｛
     *  利用可行的决策，求出可行解的一个元素
     * ｝
     * 由所有元素组合成问题的一个可行解；
     * 这里我没有提现结果的组合，直接进行了打印输出。
     * 循环的思路：
     * 1、从100元开始找零直到1元：while (i <= (a.length - 1))
     * 2、判断当前找零的钱是否大于剩余要找零的钱（不然找零为负数）：count >= a[i]，如果小于count则换到下一个面额的货币
     * 3、输出找零的钱和张数：System.out.println("找零：" + a[i] + "元" + count / a[i] + "张。");
     * 4、如果剩余钱数为0则找零结束否则i+1换到下一个货币值
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] faceValue = {100, 50, 10, 5, 1};
        smallChange(faceValue, 12693);
    }

    /**
     *
     找零：100元126张。
     找零：50元1张。
     找零：10元4张。
     找零：1元3张。
     找零完毕！
     * @param faceValue
     * @param change
     */
    public static void smallChange(int[] faceValue, int change){
        int size = faceValue.length;
        int i = 0 ;
        while(i <= size){
            if(change >= faceValue[i]){
                System.out.println("找零：" + faceValue[i] + "元" + change / faceValue[i] + "张。");
                change = change - change / faceValue[i] * faceValue[i] ;
                if(change == 0){
                    System.out.println("找零完毕！");
                    break;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
    }





}
