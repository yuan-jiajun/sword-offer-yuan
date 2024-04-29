package test17_PrintToMaxOfNDigits;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 16:17
 * @description https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class PrintToMaxOfNDigits {
    /**
     * 创建数组并校验输入值
     */
    public static void printToMaxOfNDigits(int n) {
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }

    /**
     * 输出数值
     * 思想：先固定高位，向低位递归，直到所有位都填完
     */
    private static void printArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n != array.length) {
                /**通过下面2行的代码确保遍历的完整性和不乱序*/
                array[n] = i;
                printArray(array, n + 1);
            } else {
                //对于数字0，需要判定是否在有效数字前面，如果在有效数字前面的0不输出
                //在有效数字后面的0需要输出
                boolean isFirstNo0 = false;

                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
//                        if (!isFirstNo0)//这一步的判断实际上是不需要的
                        isFirstNo0 = true;
                    } else {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    @Test
    public void test() throws Exception {
        int n = 3;
        printToMaxOfNDigits(n);
    }
}