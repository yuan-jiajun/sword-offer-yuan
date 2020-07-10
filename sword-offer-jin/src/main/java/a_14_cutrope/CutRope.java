package a_14_cutrope;

/**
 * 使用动态规划解决剪绳子的问题
 * 动态规划的使用场景都具备如下的条件：
 * 1、问题是要求一个问题的最优解
 * 2、整体的最优解依赖于局部的最优解
 * 3、大问题可以分解为小问题，且不同大问题之间的小问题重叠
 * 4、可以从下往上计算小问题的最优解并缓存下来
 */
public class CutRope {
    /**
     * 剑指offer面试题14，剪绳子，长度为n的绳子剪为m段，m为多少都可以，求每段长度之积的最大值
     *
     * @return
     */
    private static int maxProductAfterCutting(int ropeLength) {
        if (ropeLength < 2) {
            return 0;
        }
        if (ropeLength == 2) {
            return 1;
        }
        if (ropeLength == 3) {
            return 2;
        }
        //递归公式：
        // f(n) = max(f(i)*f(n-i)), 其中 0<i<n
        int[] products = new int[ropeLength + 1];

        //注意这几个初值，跟 n<=3 时的 f(n) 是不一样的 ！！！
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int k = 4; k <= ropeLength; k++) {
            int max = 0;
            for (int i = 1; i <= k / 2; i++) {
                int prod = products[i] * products[k - i];
                if (prod > max) {
                    max = prod;
                }
            }
            products[k] = max;
        }
        return products[ropeLength];
    }


    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(3));
        System.out.println(maxProductAfterCutting(4));
        System.out.println(maxProductAfterCutting(5));
        System.out.println(maxProductAfterCutting(8));

    }
}
