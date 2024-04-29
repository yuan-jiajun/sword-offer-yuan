package test66_MultiplyArray;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/28 0:29
 */
public class MultiplyArray {
    /**
     * 利用矩阵法构建乘积数组
     * <p>
     * 算法流程：
     * 初始化：数组 B ，其中 B[0] = 1 ；辅助变量 tmp=1 ；
     * 计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i] ；
     * 计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入 B[i] ；
     * 返回 B 。
     * 复杂度分析：
     * 时间复杂度 O(N) ： 其中 N 为数组长度，两轮遍历数组 a ，使用 O(N) 时间。
     * 空间复杂度 O(1) ： 变量 tmp 使用常数大小额外空间（数组 b 作为返回值，不计入复杂度考虑）。
     */
    public static int[] multiply(int[] a) {
        int length = a.length;
        int[] res = new int[length];

        if (length != 0) {
            res[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                res[i] = res[i - 1] * a[i - 1];
            }

            int temp = 1;
            //计算上三角连乘
            for (int j = length - 2; j >= 0; j--) {
                temp *= a[j + 1];
                res[j] *= temp;
            }
        }
        return res;
    }
}