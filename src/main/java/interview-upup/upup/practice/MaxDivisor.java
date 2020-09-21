package upup.practice;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/21 19:03
 * @description @link
 */
public class MaxDivisor {
    public void compute(int n) {
        int i, j, a = 0, b = 1;

        for (j = 2; j < n; j++) {
            if (n % j == 0) {
                a = j;
                b = a;
            }
        }
        if (b == a) {
            System.out.println(b);
        } else {
            System.out.println("素数");
        }
    }

    @Test
    public void test() {
        compute(28);
        compute(11);
    }
}