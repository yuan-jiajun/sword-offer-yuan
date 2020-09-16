package upup.com.oj.company.meituan.turn1;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 11:34
 * @description
 * https://www.nowcoder.com/discuss/500649
 */
public class Main3 {
    public static int helper(int n, int[] a) {

        int temp;
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            temp = a[i];
            for (int j = 1; j <= n; j++) {
                temp = temp ^ (i % j);
            }
            b[i] = temp;
        }
        int res = 0;
        if (n == 1) {
            res = b[1];
        } else {
            res = b[1] ^ b[2];
            for (int i = 3; i <= n; i++) {
                res = res ^ b[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(helper(n, a));
    }
}