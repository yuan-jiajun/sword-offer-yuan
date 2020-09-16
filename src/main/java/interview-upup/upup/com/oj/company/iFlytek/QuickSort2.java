package upup.com.oj.company.iFlytek;

/**
 * @author Yuan Jiajun
 * @date 2020/8/29 20:02
 * @description
 */

import org.junit.Test;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 */
public class QuickSort2 {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //left 和 right 都是数组的下标
    //left 和 right 都是数组的下标
    public static int partition(int[] a, int left, int right) {
        int pivot = a[right];

        int i, j;

        for (i = left, j = left; j < right; j++) {
            if (a[j] <= pivot) {
                swap(a, i++, j);
            }
        }
        swap(a, i, right);

        System.out.println(java.util.Arrays.toString(a));

        return i;
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int index = partition(data, left, right);
            quickSort(data, left, index - 1);//递归调用
            quickSort(data, index + 1, right);
        }
    }


    @Test
    public void test() {
        int[] data = {25, 84, 21, 47, 15, 27, 68, 35, 20};

        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        System.out.println();
        quickSort(data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
