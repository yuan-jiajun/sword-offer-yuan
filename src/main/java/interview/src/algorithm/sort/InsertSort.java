package algorithm.sort;

import org.junit.Test;

/**
 * 直接插入排序
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {
    public static void insertSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {/**循环的轮数---初始条件data[0]已排序，从data[1]开始插入*/
            int temp = data[i];
            if (data[i] < data[i - 1]) {/**待排序的数据小于已排序的数据中最大的数，则需要插入已经排序的数据中，否则位置保持不变*/
                int j = i - 1;
                for (; j >= 0 && data[j] > temp; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = temp;
            }
//            System.out.println(java.util.Arrays.toString(data));
        }

    }

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                /**这个for循环里面的东西是真的骚气，
                 * 就相当于一直比较新加的数和原来已经排序的数字，在交换位置的过程中找到新加数据的最终值*/
                swap(nums, j, j - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        insertSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));

        System.out.println("********* 泛型 **************");
        Integer[] data2 = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
//        System.out.println("排序之前：\n" + java.util.Arrays.toString(data2));
        sort((T[]) data2);
        System.out.println(java.util.Arrays.toString(data2));
    }
}
