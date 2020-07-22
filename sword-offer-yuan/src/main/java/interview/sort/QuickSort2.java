package sort;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 *
 * @author shkstart
 * 2018-12-17
 */
public class QuickSort2 {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //left 和 right 都是数组的下标
    private static int getIndex(int[] data, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回

        int pivot = data[left];
        int i = left;//是否加1 都可以
//        int i = left + 1;
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
            int index = getIndex(data, left, right);
            quickSort(data, left, index - 1);//递归调用
            quickSort(data, index + 1, right);
        }
    }


    public static void main(String[] args) {
//        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30};
        int[] data = {293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
