package acwing.knapsackproblem.No3_CompleteKnapsack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/9 15:01
 * @description @see https://www.acwing.com/problem/content/3/
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 * 第 i 种物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class No3_CompleteKnapsack {

}

//递归
class Solution1 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length;
    private static final int KSV = 10;

    public static void main(String[] args) {
        int result = ks(N - 1, KSV);
        System.out.println("最大价值为：" + result);
    }

    private static int ks(int i, int j) {
        int result = 0;
        if (i == 0 || j == 0) {
            // 初始条件
            result = 0;
        } else if (v[i] > j) {// 装不下该珠宝
            result = ks(i - 1, j);
        } else {//可以装下
            for (int k = 0; k * v[i] <= j; k++) {// 取k个物品i，取其中使得总价值最大的k
                int tmp = ks(i - 1, j - v[i] * k) + w[i] * k;
                if (tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}

//dp 未优化
class Solution2 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length;
    private static final int KSV = 10;

    private static final int[][] dp = new int[N][KSV + 1];

    public static void main(String[] args) {
        ks();
        System.out.println("最大价值为：" + dp[N - 1][KSV]);
    }

    private static void ks() {
        for (int i = 1; i < N; i++) {//i 从 1 开始
            for (int j = 0; j <= KSV; j++) {//j从0或1开始都可以
                for (int k = 0; k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * v[i]] + k * w[i]);//   不装 ； 装k 个
                }
            }
            for (int j = 0; j <= KSV; j++) {
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
            System.out.println();
        }
    }
}

//dp 未优化
class Solution3 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length;
    private static final int KSV = 10;

    private static final int[] dp = new int[KSV + 1];

    public static void main(String[] args) {
        ks();
        System.out.println("最大价值为：" + dp[KSV]);
    }

    private static void ks() {
        for (int i = 1; i < N; i++) {//i 从 1 开始
            for (int j = KSV; j >= v[i]; j--) {//j从0或1开始都可以

                for (int k = 0; k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);//   不装 ； 装k 个
                }
            }
            for (int j = 0; j <= KSV; j++) {
                System.out.println("前" + i + "个物品，背包容量为" + j + "时能装下的最大价值" + dp[j]);
            }
            System.out.println();
        }
    }
}
