package upup.com.oj.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 20:37
 * @description 对于n阶矩阵，首先用米字形分割线把矩阵等分为8 个区域，然后从右上角开始，
 * 按逆时针顺序给各区域编号为1,2,...,8
 * 同时矩阵元素需要满足：
 * 1.各区域内的元素都等于区域的编号
 * 2.被分割线穿过的元素都等于0
 * 打印
 */
public class PrintMatrix2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int[] ints : arr) {
            Arrays.fill(ints, 0);
        }

        double mid = (n + 0.0) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i <= mid && j >= mid && isKMoreThan45(i, j, n) && (i + j) != n - 1)
                    arr[i][j] = 1;

                if (i <= mid && j < mid && i < j)
                    arr[i][j] = 2;

                if (i < mid && j < mid && i > j)
                    arr[i][j] = 3;

                if (i >= mid && j < mid && isKMoreThan45(i, j, n) && (i + j) != n - 1)
                    arr[i][j] = 4;

                if (i >= mid && j < mid && !isKMoreThan45(i, j, n) && (i + j) != n - 1)
                    arr[i][j] = 5;

                if (i > mid && j >= mid && !isKMoreThan45(i, j, n) && i != j)
                    arr[i][j] = 6;

                if (i >= mid && j >= mid && i < j)
                    arr[i][j] = 7;

                if (i < mid && j > mid && !isKMoreThan45(i, j, n) && (i + j) != n - 1)
                    arr[i][j] = 8;
            }
        }

        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                arr[i][n / 2] = 0;
            }
            for (int j = 0; j < n; j++) {
                arr[n / 2][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isKMoreThan45(int i, int j, int n) {
        int yLength = n - i;
        return yLength > j;
    }
}