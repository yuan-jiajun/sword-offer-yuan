package upup.algorithm.sort;

import org.junit.Test;

/**
 * Shell排序
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1
 */

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    public static void ShellSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;

        int h = 1;
        while (h <= arrayLength / 3) {
            h = h * 3 + 1;// 1, 4, 13, 40, ...
        }

        while (h > 0) {
//            System.out.println("===h的值：" + h + "===");
            for (int i = h; i < arrayLength; i++) {
                int temp = data[i];
                if (data[i] < data[i - h]) {
                    int j = i - h;

                    /*元素后移*/
                    for (; j >= 0 && data[j] > temp; j -= h) {
                        data[j + h] = data[j];
                    }

                    data[j + h] = temp;
                }
                System.out.println(java.util.Arrays.toString(data));
            }
            h = (h - 1) / 3;
        }
    }


    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        ShellSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));

        System.out.println("********* 泛型 **************");
        Integer[] data2 = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
//        System.out.println("排序之前：\n" + java.util.Arrays.toString(data2));
        sort((T[]) data2);
        System.out.println(java.util.Arrays.toString(data2));


        int[] data3 = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        ShellSort(data3);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data3));
    }
}
