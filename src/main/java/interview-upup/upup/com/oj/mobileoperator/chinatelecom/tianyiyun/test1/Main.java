package upup.com.oj.mobileoperator.chinatelecom.tianyiyun.test1;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/16 21:10
 * @description @link
 */
public class Main {
    public static int getNthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[multiply2] * 2, Math.min(arr[multiply3] * 3, arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min) {
                multiply2++;
            }
            if (arr[multiply3] * 3 == min) {
                multiply3++;
            }
            if (arr[multiply5] * 5 == min) {
                multiply5++;
            }
        }

        return arr[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getNthUglyNumber(sc.nextInt()));
    }
}
