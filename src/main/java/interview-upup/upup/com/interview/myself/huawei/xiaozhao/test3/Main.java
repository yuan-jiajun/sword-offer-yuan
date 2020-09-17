package upup.com.interview.myself.huawei.xiaozhao.test3;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description @link  https://blog.csdn.net/qq_38649940/article/details/108439867
 * 给出n ∗ m 的矩阵，每个格子有三个值d , r , s为这一步往右走的概率，d为这一步往下走的概率，s为原地不动的概率，
 * 求从(1,1)到(n,m)的期望步数。
 * n∗ m<= 1e6
 */
public class Main {
    public static double[] pd = new double[100005];
    public static double[] pr = new double[100005];
    public static double[] ps = new double[100005];
    public static double[] DP = new double[100005];

    public static int n, m;

    public static int G(int x, int y) {
        return m * (x - 1) + y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pd[G(i, j)] = in.nextDouble();
                pr[G(i, j)] = in.nextDouble();
                ps[G(i, j)] = in.nextDouble();
            }
        }

        //DP[G(x, y)]表示从(x,y)出发，到右下角的期望
        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {
                if (i == n && j == m) continue;
                //每次有p的概率走出格子，则期望需要1/p次走出这个格子。
                //只考虑一定移动情况下，
                //期望1 = sum(到下一步的概率 * (下一步到终点的期望 + 1) =  sum(到下一步的概率 * (下一步到终点的期望 ) + 1
                //因为 sum (到下一步的概率) = sum(移动概率) = 1
                //考虑上原地stop后，
                //期望2 = 期望1 / 移动的概率
                DP[G(i, j)] = (pd[G(i, j)] * DP[G(i + 1, j)] + pr[G(i, j)] * DP[G(i, j + 1)] + 1) / (1.0 - ps[G(i, j)]);
            }
        }


        System.out.println(DP[G(1, 1)]);
    }
}

