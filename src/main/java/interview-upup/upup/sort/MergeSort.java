package upup.sort;

import org.junit.Test;

/**
 * 归并排序
 * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
 * 归并方法将数组中两个已经排序的部分归并成一个。
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    public static void mergeSort(int[] data) {
        // 归并排序
        partionSort(data, 0, data.length - 1);
    }

    // 将索引从left到right范围的数组元素进行归并排序
    private static void partionSort(int[] data, int left, int right) {
        if (left < right) {
            //找出中间索引
            int mid = left + (right - left) / 2;
            partionSort(data, left, mid);
            partionSort(data, mid + 1, right);

            //合并
            merge(data, left, mid, right);
        }
    }

    // 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
    private static void merge(int[] data, int left, int mid, int right) {
        int[] tempArr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            tempArr[i] = data[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArr[i] <= tempArr[j]) {
                data[k++] = tempArr[i++];
            } else {
                data[k++] = tempArr[j++];
            }
        }

        while (i == mid + 1 && j <= right) {
            data[k++] = tempArr[j++];
        }
        while (j == right + 1 && i <= mid) {
            data[k++] = tempArr[i++];
        }

    }


    protected T[] aux;

    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        genericMerge(nums, l, mid, h);
    }

    protected void genericMerge(T[] nums, int l, int m, int h) {

        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k]; // 将数据复制到辅助数组
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];

            } else if (j > h) {
                nums[k] = aux[i++];

            } else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = aux[j++];
            }
        }
    }

    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        mergeSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));

        System.out.println("********* 泛型 **************");
        Integer[] data2 = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
//        System.out.println("排序之前：\n" + java.util.Arrays.toString(data2));
        sort((T[]) data2);
        System.out.println(java.util.Arrays.toString(data2));
    }
}
