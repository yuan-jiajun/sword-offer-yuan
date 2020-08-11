package yuan.test64_sumNums;

import org.junit.Test;

/**
 * @author yuanjiajun
 * @description https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @date 2020/8/12 2:21
 */
public class SumNums {
/**同样的逻辑，在leetcode上oj，下面的方法没加static
 * 执行用时：1 ms, 在所有 Java 提交中击败了62.82%的用户
 * 内存消耗：37.1 MB, 在所有 Java 提交中击败了19.63%的用户
 *
 * 加上static
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了75.43%的用户
 * */
    public static int sumNums(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += sumNums(n - 1)) > 0);//这一步真的太骚了
        return sum;
    }

    /**
     * 解法二：利用递归和全局变量求和
     */
    private static int sum = 0;

    public static int sum2(int n) {
        sum3(n);
        return sum;
    }

    private static boolean sum3(int n) {
        sum += n;
        return (n > 0) && sum3(n - 1);
    }

    @Test
    public void test46() throws Exception {
        int n = 10;
        System.out.println("解法一，利用递归，求1 + ...+ " + n + " 的和：" + SumNums.sumNums(n));
        System.out.println("解法二，利用递归和全局变量，求1 + ...+ " + n + " 的和：" + SumNums.sum2(n));
    }

}