package upup.sort;


import org.junit.Test;

/**
 * 直接选择排序
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void selectSort(int[] data) {
//        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++) {   //i < arrayLength - 1
            for (int j = i + 1; j < arrayLength; j++) {
                if (data[j] < data[i]) {
                    swap(data, i, j);
                }
            }
//            System.out.println(java.util.Arrays.toString(data));
        }
    }

    /*****************泛型实现 + 改进 ****************/
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
    }


    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        selectSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));

        System.out.println("********* 泛型 **************");
        Integer[] data2 = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
//        System.out.println("排序之前：\n" + java.util.Arrays.toString(data2));
        sort((T[]) data2);
        System.out.println(java.util.Arrays.toString(data2));
    }


}
