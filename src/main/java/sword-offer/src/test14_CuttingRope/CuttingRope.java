package test14_CuttingRope;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 10:58
 * @description https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope {

    /**
     * 定义一个数组dp，其中dp[i]表示的是长度为i的绳子能得到的最大乘积。
     * 我们先把长度为i的绳子拆成两部分，一部分是j，另一部分是i-j，那么会有下面4种情况
     * 1，j和i-j都不能再拆了
     * dp[i]=j*(i-j);
     * 2，j能拆，i-j不能拆
     * dp[i]=dp[j]*(i-j);
     * 3，j不能拆，i-j能拆
     * dp[i]=j*dp[i-j];
     * 4，j和i-j都能拆
     * dp[i]=dp[j]*dp[i-j];
     * 我们取上面4种情况的最大值即可。我们把它整理一下，得到递推公式如下
     * dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
     */

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }

        return dp[n];
    }

    /**
     * 方便理解版本
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int e = dp[i];
                int b = (i - j) * j;//j和i-j都不能再拆了
                int d = (i - j) * dp[j];//j能拆，i-j不能拆
                int c = dp[i - j] * j;//j不能拆，i-j能拆
                int a = dp[i - j] * dp[j];//j和i-j都能拆

                dp[i] = max(a, b, c, d, e);
            }
        }

        return dp[n];
    }

    public int max(int a, int b, int c, int d, int e) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        if (d > max)
            max = d;
        if (e > max)
            max = e;
        return max;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope2(10));
    }
}