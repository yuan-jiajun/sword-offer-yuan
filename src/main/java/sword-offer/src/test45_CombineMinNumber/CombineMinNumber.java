package test45_CombineMinNumber;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 15:42
 * @description
 */
public class CombineMinNumber {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 解法一：自定义快排
     */
    public static String printMinNumber1(int[] array) {
        int[] clone = array.clone();
        StringBuilder sb = new StringBuilder();
        printMin(clone, 0, clone.length - 1);

        for (int i : clone) {
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * 快排+比较
     */
    public static void printMin(int[] array, int start, int end) {
        if (start < end) {
            int pivot = array[end];
            int i, j;

            for (i = start, j = start; j < end; j++) {

                // array[j]、main_number的组合较小，就把array[j]换到最前面
                if (isSmall(String.valueOf(array[j]), String.valueOf(pivot))) {
                    swap(array, i++, j);
                }
            }

            swap(array, end, i);

            printMin(array, 0, i - 1);
            printMin(array, i + 1, end);
        }
    }

    /**
     * 比较两个字符的大小(判断m是否比n小）
     */
    private static boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return true;
            }
            if (left.charAt(i) > right.charAt(i))
                return false;
        }
        return false;
    }

    /**
     * 解法二：使用JDK的归并排序
     */
    public static String printMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        int len = numbers.length;

        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(printMinNumber1(new int[]{3, 30, 34, 5, 9}));//30 3 34 5 9
        System.out.println(printMinNumber2(new int[]{3, 30, 34, 5, 9}));//30 3 34 5 9
    }
}