package upup.algorithm.sort;

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

    //left 和 right 都是数组的下标，个人推荐下面这种partition方法
    public static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i, j;

        for (i = left, j = left; j < right; j++) {
            if (a[j] <= pivot) {
                swap(a, i++, j);
            }
        }

        swap(a, i, right);

        return i;
    }

    //left 和 right 都是数组的下标
    private static int partition2(int[] data, int left, int right) {
        int pivot = data[left];
        int i = left + 1;//left是否加1 都可以
        int j = right;

        while (true) {
            while (data[i] <= pivot && i < right) i++;
            while (data[j] >= pivot && j > left) j--;
            if (i < j) {
                swap(data, i, j);
            } else break;

        }
        swap(data, left, j);

        return j;
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int index = partition2(data, left, right);
            quickSort(data, left, index - 1);//递归调用
            quickSort(data, index + 1, right);
        }
    }


    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};

        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
