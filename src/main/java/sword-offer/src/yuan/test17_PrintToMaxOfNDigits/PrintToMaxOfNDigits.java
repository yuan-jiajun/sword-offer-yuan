package yuan.test17_PrintToMaxOfNDigits;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 16:17
 * @description
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