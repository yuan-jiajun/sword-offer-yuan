package SimpleChageDirect;

/**
 * @author yuanjiajun
 * @description
 * https://www.nowcoder.com/practice/11f7c6cb54524c3693119e4088533305?tpId=113&&tqId=33523&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/22 2:27
 */

public class Solution2 {
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
        boolean[][] isVisited = new boolean[3][n];
        // 动态规划数组
        long[][] dp = new long[4][n];
        // 防止答案过大，对 M 取模
        int M = 1000000007;
        // 将障碍点设置为已经访问
        for (int i = 0; i < m; i++) {
            isVisited[x[i] - 1][y[i] - 1] = true;
        }
        // 从dp[0][0]开始访问
        dp[0][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (!isVisited[0][i + 1]) {
                dp[0][i + 1] = (dp[0][i] + dp[1][i]) % M;
            }
            if (!isVisited[1][i + 1]) {
                dp[1][i + 1] = (dp[0][i] + dp[1][i] + dp[2][i]) % M;
            }
            if (!isVisited[2][i + 1]) {
                dp[2][i + 1] = (dp[1][i] + dp[2][i]) % M;
            }
        }
        return (int) dp[2][n - 1] % M;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[] x = new int[]{2, 3, 2};
        int[] y = new int[]{3, 2, 1};

        System.out.println(new Solution2().solve(n, m, x, y));

    }
}