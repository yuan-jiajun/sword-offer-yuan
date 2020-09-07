package yuan.test16_ImplementPower;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 11:02
 * @description  https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class ImplementPower {
    /**
     * 对输入的数进行条件判断后计算结果
     */
    public static double power(double base, int exponent) throws Exception {
        double result = 0.0;

        if (equal(base, 0.0) && exponent < 0) {
            throw new Exception("0的负数次幂无意义");
        }

        if (equal(exponent, 0)) {
            return 1.0;
        }

        if (exponent < 0) {
//            result = powerWithExponent(1.0 / base, -exponent);//都可以
            result = 1.0 / powerWithExponent(base, -exponent);

        } else {
            result = powerWithExponent(base, exponent);
        }

        return result;
    }

    /**
     * 幂计算
     */
    private static double powerWithExponent(double base, int exponent) {
        double result = 1.0;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }

        return result;
    }

    /**
     * 判断两个double型数值是否相等（有误差）
     */
    private static boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && num1 - num2 < 0.0000001;
    }

    @Test
    public void test() throws Exception {
        System.out.println(power(3, -2));
    }
}