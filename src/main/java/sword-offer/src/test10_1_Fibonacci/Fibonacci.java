package test10_1_Fibonacci;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 21:32
 * @description https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fibonacci {
    /**
     * 解法一：定义三个局部变量，作为交换
     */
    public static int getFibonacci1(int n) {
        int result = 0;
        int preTwo = 0;
        int preOne = 1;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            result = (preTwo + preOne) % 1000000007;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    @Test
    public void test1() {
        System.out.println(getFibonacci1(48));
    }

    /**
     * 解法二 ：只需要两个局部变量
     */
    public static long getFibonacci2(int n) {
        long sum = 1;
        long number = 1;

        if (n <= 0)
            return 0;
        if (n == 1 || n == 2) {
            return 1;
        }

        while (n-- > 2) {
            number = sum - number;
            sum += number;
        }
        return sum;
    }

    @Test
    public void test2() {
        System.out.println(getFibonacci2(5));
    }

    /**
     * 解法三：递归：效率低，有大量重复计算
     */
    public static int getFibonacci3(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return getFibonacci3(n - 1) + getFibonacci3(n - 2);
    }
}