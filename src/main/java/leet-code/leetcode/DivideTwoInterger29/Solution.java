package leetcode.DivideTwoInterger29;

/**
 * @author Yuan Jiajun
 * @description
 * https://leetcode-cn.com/problems/divide-two-integers/submissions/
 * @date 2020/8/4 16:09
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