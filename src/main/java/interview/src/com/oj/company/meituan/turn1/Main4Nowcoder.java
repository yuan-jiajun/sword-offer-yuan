package com.oj.company.meituan.turn1;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 21:29
 * @description
 * 作者：js8544
 * 链接：https://www.nowcoder.com/discuss/500649
 * 来源：牛客网
 *
 * 给出一串子树的节点个数（包含自身），求是否能构成合法树，要求每个非叶节点至少有两个子节点。
 * 思路：n=24明显提示我们是dfs+剪枝，先把输入从大到小排序。
 * 首先预检查：1. arr[0]必须等于n 2. arr[i]不能等于2
 * 然后dfs：
 * 1. arr[i]表示i剩下多少总子节点未分配。child[i]表示i目前分配了多少子节点。set<int> can （candidate）存有子节点未分配的节点（即arr[i]大于1的所有i）。
 * 2. 从x=1开始dfs，每轮dfs去找can中的节点i，如果arr[i] > arr[x]，（ 且不满足（arr[i] - arr[x] == 1 && child[i]==0)，不然i就只能分配x一个子节点，这是不超时的关键。），则把x当成i的字节点，然后去试dfs(x+1).
 * 3. 直到x=n，检查是否所有arr[i]==1 && child[i] != 1，arr[i]=1因为最后只剩下自己没分配出去。
 */
public class Main4Nowcoder {
}