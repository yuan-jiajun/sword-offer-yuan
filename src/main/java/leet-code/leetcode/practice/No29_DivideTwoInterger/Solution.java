package leetcode.practice.No29_DivideTwoInterger;

/**
 * @author Yuan Jiajun
 * @date 2020/8/4 16:09
 * @description @see https://leetcode-cn.com/problems/divide-two-integers/
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Solution {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp >= temp) {
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return k ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.divide(20, 2));
//        System.out.println(Solution.divide(Integer.MIN_VALUE + 1, -1));
    }
}