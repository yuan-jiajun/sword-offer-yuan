package upup.com.oj.company.iFlytek;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/8/29 19:31
 * @description
 */
public class Main {
    // 递归实现
    public static void solve(int n) {
        for (int i = 2; i <= n; i++) {

            if (i == n) {
                System.out.print(i);
                return;
            }

            if (n > i && (n % i == 0)) {
                System.out.print(i + "*");
                solve(n / i);
                break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
    }
}