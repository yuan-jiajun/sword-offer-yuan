package com.oj.company.jingdong;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/8/27 20:28
 * @description
 * ac 100%
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2 * n - 1];
        int i = 0;
        int start = n - 1;
        int end = n - 1;
        while (i < n) {
            int start1 = start;
            int end1 = end;
            while (start1 <= end1) {
                arr[i][start1] = in.nextInt();
                start1++;
            }
            i++;
            start--;
            end++;
        }

        int[][] dp = new int[n][2 * n - 1];
        dp[0][n - 1] = arr[0][n - 1];
        dp[1][n - 1] = arr[1][n - 1] + dp[0][n - 1];
        dp[1][n - 2] = arr[1][n - 2] + dp[0][n - 1];
        dp[1][n] = arr[1][n] + dp[0][n - 1];

        for (int j = 2; j < n; j++) {
            for (int k = 0; k < 2 * n - 1; k++) {
                int left = 0;
                int mid;
                int right = 0;
                if (k - 1 >= 0) left = dp[j - 1][k - 1];
                if (k + 1 <= 2 * n - 2) right = dp[j - 1][k + 1];

                mid = dp[j - 1][k];

                dp[j][k] = Math.max(mid + arr[j][k], Math.max(left + arr[j][k], right + arr[j][k]));
            }
        }

        int max = 0;

        for (int j = 0; j < 2 * n - 1; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }

        System.out.println(max);

    }
}