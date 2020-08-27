package upup.com.jd;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/8/27 19:37
 * @description
 */
public class Main {
    public static int getKthNumber(int n) {
        int bit = 0;
        int base = 1;
        int count = 0;
        while (count < n) {
            base *= 3;
            count += base;
            bit++;
        }

        int[] res = new int[bit];
        int lastBase = base / 3;
        int lastCount = count - base;

        int distance = n - lastCount;

        for (int i = 0; i < bit; i++) {
            if (distance <= lastBase) {
                res[i] = 2;

            } else if (distance <= 2 * lastBase) {
                res[i] = 3;
                distance = distance - lastBase;
            } else if (distance <= 3 * lastBase) {
                res[i] = 5;
                distance = distance - 2 * lastBase;
            }
            lastBase /= 3;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : res) {
            sb.append(a);
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = getKthNumber(n);
        System.out.println(res);
    }


//    @Test
//    public void test() {
//        System.out.println(getKthNumber(7));
//        System.out.println(getKthNumber(3));
//        System.out.println(getKthNumber(12));
//        System.out.println(getKthNumber(14));
//        System.out.println(getKthNumber(16));
//        System.out.println(getKthNumber(146));
//    }
}