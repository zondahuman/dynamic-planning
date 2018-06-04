march action

# dynamic-planning:

动态规划一般可分为线性动规，区域动规，树形动规，背包动规四类。
举例：
线性动规：拦截导弹，合唱队形，挖地雷，建学校，剑客决斗等；
区域动规：石子合并， 加分二叉树，统计单词个数，炮兵布阵等；
树形动规：贪吃的九头龙，二分查找树，聚会的欢乐，数字三角形等；
背包问题：01背包问题，完全背包问题，分组背包问题，二维背包，装箱问题，挤牛奶（同济ACM第1132题）等；

应用实例：
最短路径问题 ，项目管理，网络流优化等；


给定一个整数数组，找到一个具有最大和的子数组，返回其最大和（求最大子数组之和的方法）
给定两个字符串，求长度最大的公共子串
给定字符串求长度最大的不重复子串
求一维数组中不重叠的两个子数组的最大和(求两个子数组最大的累加和)


动态规划-最短路径
动态规划-背包问题
f(i,j) = Max{ f[i-1,j-W[i]]+P[i](j>=W[i]), f[i-1,j] (j <W[i]) }
f[i,j]表示在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。
 f[i-1,j] (j <W[i]) ： 背包装第i-1个和之前的物品时候的最大价值(但是不包括第i个，第i个可能本身大于背包承重，第i个可能性价比不是最高的)
 f[i-1,j-W[i]]+P[i](j>=W[i])：背包装第i个和之前的物品的最大价值
W[i] :  第i个物体的重量；
P[i] : 第i个物体的价值；
 f[i-1,j-W[i]]：前i-1个物体放入容量为j-W[i]的背包的最大价值；


动态规划-滚动数组
动态规划-贪心算法
Java动态规划 实现最长公共子序列以及最长公共子字符串

动态规划考点： 写递推公式

动态规划三个重要概念：
1、最优子结构
2、边界
3、状态转移公式


算法网站：
https://acm.sjtu.edu.cn/OnlineJudge/
https://leetcode.com/
http://www.geeksforgeeks.org/
http://www.lintcode.com/zh-cn/
https://leetcode-cn.com/problemset/all/?topicSlugs=array
https://www.ojcoder.cn/   很牛逼的算法网站




数组算法：
寻找和为定值的两个数(找出数组里面任意两个数相加等于一个值k)
求最大子数组之和的方法
最小和的子数组
删除指定数组的元素
数组中出现次数超过一半的数字
求一维数组中不重叠的两个子数组的最大和(求两个子数组最大的累加和) (难度系数比较高)
在一个先增长后减小的数组中找到最大值(要么一直增大，要么一直减小，要么先增大后减小)
一个数组的值先从小到大递增后从大到小递减，找出最大的值
一个数组的值先从大到小递减后从小到大递增，找出最小的值
数组中只出现一次的数字
数组中第k大的数
无序数组的中位数

字符串算法：
给定两个字符串，求长度最大的公共子串
给定两个字符串，求长度最大的公共子序列
给定字符串求长度最大的不重复子串(最长无重复子串)
求字符串中所有字符的组合
一个字符串是否是另一个字符串的子串(一个字符串是否包含另一个字符串)
字符串全排列

图的算法：
图上两点直接的最短距离(迪杰斯特拉)
图的深度优先遍历
图的广度优先遍历
矩阵的总路径数


动态规划：
01背包问题
爬楼梯递归，循环(动态规划实现循环)


贪心算法：
加油站加油

单链表算法：
单链表反转
单链表是否有环
单链表环的长度
单链表的环的入口
单链表是否相交
单链表查找某个节点
单链表删除某个节点
单链表寻找中间数(一种是暴力解法，另一种就是两个快慢指针)

二叉树算法：
二叉树镜像
二叉树深度遍历
二叉树广度遍历
二叉树按层打印节点
对于给定的二叉树根节点，求该树的深度











