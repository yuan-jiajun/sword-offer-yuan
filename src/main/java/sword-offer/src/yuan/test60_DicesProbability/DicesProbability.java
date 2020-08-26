package yuan.test60_DicesProbability;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 16:13
 * @description
 */
public class DicesProbability {

    public static Map<Integer, Double> printProbability(int number) {
        Map<Integer, Double> probabilityMap = new HashMap<>();
        if (number < 1) {
            return probabilityMap;
        }
        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;

        // 当第一次抛掷骰子时，有6种可能，每种可能出现一次
        // 第一个骰子投完的结果存到了probabilities[0]
        for (int i = 1; i <= g_maxValue; i++) {
            probabilities[0][i] = 1;
        }

        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        for (int k = 2; k <= number; ++k) {

            // 第k次掷骰子，和最小为k，小于k的情况是不可能发生的,令不可能发生的次数设置为0！
            for (int i = 0; i < k; ++i) {
                probabilities[1 - flag][i] = 0;
            }

            // 第k次掷骰子，和最小为k，最大为g_maxValue*k
            for (int i = k; i <= g_maxValue * k; ++i) {
                // 初始化，因为这个数组要重复使用，上一次的值要清0
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }

            // 若flag=0，1-flag用的就是数组1，而flag=1，1-flag用的就是数组0
            flag = 1 - flag;
        }

        double total = Math.pow(g_maxValue, number);
        for (int sum = number; sum <= g_maxValue * number; sum++) {
            double ratio = (double) probabilities[flag][sum] / total;
            probabilityMap.put(sum, ratio);
        }
        return probabilityMap;
    }

    /**
     * chose
     */
    public static double[] printProbability2(int number) {
        int[][] dp = new int[number + 1][number * 6];

        for (int i = 0; i < 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= number; i++) {
            for (int j = i - 1; j < 6 * i; j++) {

                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - cur];
                }

            }
        }

        //动态规划得到了结果数组
        //dp[i][j] ，表示投掷完 i 枚骰子后，点数 j的出现次数。
        //这里的点数指的是前 n 枚骰子的点数和，而不是第 n 枚骰子的点数
//        System.out.println(Arrays.deepToString(dp));


        int all = (int) Math.pow(6, number);
        //当dp[i][j]的i=number，即为需要的   把n个骰子扔在地上，所有骰子朝上一面的点数之和为s
        int[] tmpRes = dp[number];

        //处理前面为0的数据
//        System.out.println(Arrays.toString(tmpRes));
        int count0 = number - 1;
//        for (int i = 0; i < tmpRes.length; i++) {
//            if (tmpRes[i] == 0) count0++;
//        }

        double[] res = new double[tmpRes.length - count0];
        for (int i = count0, j = 0; i < dp[number].length; i++) {
//            res[j++] = dp[number][i] + 0.0 ;
            res[j++] = (dp[number][i] + 0.0) / all;
        }


        //输出结果保留小数点后5位
        DecimalFormat df = new DecimalFormat("0.00000");
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(df.format(res[i]));
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(printProbability2(2)));
    }


}