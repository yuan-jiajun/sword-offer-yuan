package com.oj.company.goodix;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 20:44
 * @description
 */
public class Pig {
    int f(int N) {
        if (N < 3)
            return 1;
        else
            return f(N - 1) + f(N - 2);
    }

    @Test
    public void test() {
        System.out.println(f(7));
        System.out.println(f(4));
    }
}