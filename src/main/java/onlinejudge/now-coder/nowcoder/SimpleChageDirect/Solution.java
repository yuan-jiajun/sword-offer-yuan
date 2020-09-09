package nowcoder.SimpleChageDirect;

/**
 * @author yuanjiajun
 * @description
 * tags-chose
 * @date 2020/7/22 2:27
 */

public class Solution {
    /**
     * 简单变相
     *
     * @param n int整型        表示第几列
     * @param m int整型        表示有几个障碍
     * @param x int整型一维数组 表示障碍在第几行
     * @param y int整型一维数组 表示障碍在第几列
     * @return int整型
     */
    public int solve(int n, int m, int[] x, int[] y) {
        // write code here
        // 表示是否访问过
        boolean[][] isVisited = new boolean[4][n + 1];
        // 动态规划数组
        long[][] dp = new long[4][n + 1];
        // 防止答案过大，对 M 取模
        int M = 1000000007;
        // 将障碍点设置为已经访问
        for (int i = 0; i < m; i++) {
            isVisited[x[i]][y[i]] = true;
        }
        // 从dp[1][1]开始访问
        dp[1][1] = 1;
        for (int i = 1; i < n; i++) {
            if (!isVisited[1][i + 1]) {
                dp[1][i + 1] = (dp[1][i] + dp[2][i]) % M;
            }
            if (!isVisited[2][i + 1]) {
                dp[2][i + 1] = (dp[1][i] + dp[2][i] + dp[3][i]) % M;
            }
            if (!isVisited[3][i + 1]) {
                dp[3][i + 1] = (dp[2][i] + dp[3][i]) % M;
            }
        }
        return (int) dp[3][n] % M;
    }
}