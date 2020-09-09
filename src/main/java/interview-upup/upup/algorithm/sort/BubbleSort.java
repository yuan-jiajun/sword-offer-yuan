package upup.algorithm.sort;

import org.junit.Test;

/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 每一轮将最大值放置在最后
     */
    public static void bubbleSort1_1(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength; i++) {//轮数
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (data[j + 1] < data[j]) {
                    swap(data, j, j + 1);
                }
            }
//            System.out.println(java.util.Arrays.toString(data));
        }
    }

    /**
     * 每一轮将最小值放置在最前
     */
    public static void bubbleSort1_2(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++) {//轮数
            for (int j = arrayLength - 1 - i; j > 0; j--) {
                if (data[j - 1] > data[j]) {
                    swap(data, j, j - 1);
                }
            }
//            System.out.println(java.util.Arrays.toString(data));
        }
    }


    //优化1，在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
    public static void bubbleSort2(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        boolean isSorted = false;
        for (int i = 0; i < arrayLength - 1 && !isSorted; i++) {/**这个判定条件就很骚*/
            isSorted = true;
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    isSorted = false;
                }
            }
//            System.out.println(java.util.Arrays.toString(data));
        }
    }

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {/**这个判定条件就很骚*/
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }


    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
//        bubbleSort(data);
//        bubbleSort1_2(data);
        bubbleSort2(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));

        System.out.println("********* 泛型 **************");
        Integer[] data2 = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
//        System.out.println("排序之前：\n" + java.util.Arrays.toString(data2));
        sort((T[]) data2);
        System.out.println(java.util.Arrays.toString(data2));
    }
}
