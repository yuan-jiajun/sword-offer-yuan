package knapsackproblem.No2_01Knapsack;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/9 14:29
 * @description @link https://www.acwing.com/problem/content/description/2/
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 * 第 i 件物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值
 */
public class No2_01Knapsack {
    public static void main(String[] args) {
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int KSV = reader.nextInt();
        // 一个长度为N+1的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1];
        // 一个长度为N+1的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close();

        int result = ks(N, KSV, v, w);
        System.out.println(result);
    }

    private static int ks(int i, int j, int[] v, int[] w) {
        int res = 0;
        {
            //todo
        }
        return res;
    }
}

//递归
class Solution1 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length - 1;
    private static final int KSV = 10;

    //上面是一些预处理

    public static void main(String[] args) {
        int result = ks(N, KSV);
        System.out.println("最大价值为：" + result);
    }

    private static int ks(int i, int j) {
        int result = 0;
        if (i == 0 || j == 0) {
            // 初始条件
            result = 0;
        } else if (v[i] > j) { // 装不下该珠宝
            result = ks(i - 1, j);
        } else {// 可以装下
            result = Math.max(ks(i - 1, j), ks(i - 1, j - v[i]) + w[i]);
        }
        return result;
    }
}


//dp原始未优化代码
class Solution2 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length - 1;
    private static final int KSV = 10;

    //上面是一些预处理

    public static void main(String[] args) {
        int result = ks();
        System.out.println("最大价值为：" + result);
    }


    // 正式工作的代码
        /*
        定义一个二阶矩阵dp[N+1][KSV+1],
        这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候
        第0列表示背包的体积为0的时候，即不能装任何东西的时候

        dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        对于dp[i][j]有两种情况：
        1. 不选择当前的第i件物品/第i件物品比背包容量要大，则dp[i][j] = dp[i-1][j]
        2. 选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：
           当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值
            dp[i][j] = dp[i-1][j-v[i]] + w[i]
        dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
        即：
        if(j >= v[i]):
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
        else:
            dp[i][j] = dp[i-1][j]
        */
    private static int ks() {
        int[][] dp = new int[N + 1][KSV + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= KSV; j++) {//j从0或1开始都可以
                for (int k = 0; k * v[i] <= j && k <= 1; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * v[i]] + k * w[i]);//   不装 ； 装k 个
                }
            }
            for (int j = 0; j <= KSV; j++) {
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
            System.out.println();
        }
        return dp[N][KSV];
    }
}

//dp优化后代码
class Solution3 {
    private static final int[] v = {0, 5, 7};
    private static final int[] w = {0, 5, 8};

    private static final int N = v.length - 1;
    private static final int KSV = 10;

    //上面是一些预处理

    public static void main(String[] args) {
        int result = ks();
        System.out.println("最大价值为：" + result);
    }

    // 将dp优化为一维数组
        /*
        注意，这里第二层循环的时候，还是小到大循环的话，那么

        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
        实际上变成了
        dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);

        因为i-1的值已经在前面被更新过了，覆盖了
        为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖

        dp[j] 表示当背包容量为j时，能装下的最大价值(j>0&&j<=KSV)

        如果不逆序的话，输出结果为10，dp数组实际为：  ??????????//yuan
        0 0 0 0 0 0
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        0 2 4 6 8 10
        */

    private static int ks() {
        int[] dp = new int[KSV + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = KSV; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
            for (int j = 0; j <= KSV; j++) {
                System.out.println(i + "  dp[" + j + "] = " + dp[j]);
            }
            System.out.println();
        }
        return dp[KSV];
    }
}