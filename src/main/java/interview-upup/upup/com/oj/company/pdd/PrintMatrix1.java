package upup.com.oj.company.pdd;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 20:37
 * @description
 * 对于n阶矩阵，首先用米字形分割线把矩阵等分为8 个区域，然后从右上角开始，
 * 按逆时针顺序给各区域编号为1,2,...,8
 * 同时矩阵元素需要满足：
 *  1.各区域内的元素都等于区域的编号
 *  2.被分割线穿过的元素都等于0
 *
 *  打印
 */
public class PrintMatrix1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        int floor = n / 2 - 1;
        if (n % 2 == 0) {
            int right = n / 2;
            for (int i = 0; i < floor; i++) {
                int left1 = i + 1;
                while (left1 < right) {
                    arr[i][left1] = 2;
                    arr[n - 1 - i][left1] = 5;
                    left1++;
                }
            }

            int left = n / 2;
            for (int i = 0; i < floor; i++) {
                int right1 = n - 2 - i;
                while (right1 >= left) {
                    arr[i][right1] = 1;
                    arr[n - 1 - i][right1] = 6;
                    right1--;
                }
            }

            int bottom = n / 2;
            for (int i = 0; i < floor; i++) {
                int up1 = i + 1;
                while (up1 < bottom) {
                    arr[up1][i] = 3;
                    arr[up1][n - 1 - i] = 8;
                    up1++;
                }
            }

            int up = n / 2;
            for (int i = 0; i < floor; i++) {
                int bottom1 = n - i - 2;
                while (bottom1 >= up) {
                    arr[bottom1][i] = 4;
                    arr[bottom1][n - 1 - i] = 7;
                    bottom1--;
                }
            }

        } else {
            int right = n / 2;
            for (int i = 0; i < floor; i++) {
                int left1 = i + 1;
                while (left1 < right) {
                    arr[i][left1] = 2;
                    arr[n - 1 - i][left1] = 5;
                    left1++;
                }
            }

            int left = n / 2;
            for (int i = 0; i < floor; i++) {
                int right1 = n - 2 - i;
                while (right1 > left) {
                    arr[i][right1] = 1;
                    arr[n - 1 - i][right1] = 6;
                    right1--;
                }
            }

            int bottom = n / 2;
            for (int i = 0; i < floor; i++) {
                int up1 = i + 1;
                while (up1 < bottom) {
                    arr[up1][i] = 3;
                    arr[up1][n - 1 - i] = 8;
                    up1++;
                }
            }

            int up = n / 2;
            for (int i = 0; i < floor; i++) {
                int bottom1 = n - i - 2;
                while (bottom1 > up) {
                    arr[bottom1][i] = 4;
                    arr[bottom1][n - 1 - i] = 7;
                    bottom1--;
                }


            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}