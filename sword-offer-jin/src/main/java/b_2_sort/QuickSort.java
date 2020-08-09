package b_2_sort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 递归实现快速排序， 递归公式
     * quickSort(nums, start, end)
     * int index = partition(nums, start, end);
     * quickSort(nums, start, index-1), quickSort(nums, index+1, end)
     * 递归结束条件：
     * start >= end
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        //递归终止条件
        if (start >= end) {
            return;
        }

        int index = partition(nums, start, end);

        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start; //left表示所有已处理的小于pivot的数的 后一个数 的索引（第一个比pivot大的数的索引，所有最后会和pivot交换）
        int right = start; //right表示所有已处理的数的最后一个的索引
        int temp = 0; //用于交换
        while (right <= end - 1) {
            if (nums[right] < pivot) { //
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                //指针移动
                left++;
            }
            right++;
        }
        //把pivot放到正确的位置上
        nums[end] = nums[left];
        nums[left] = pivot;
        //返回pivot的索引
        return left;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
//        int[] nums = new int[]{3, 8, 1, 7, 5, 2, 4};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));


    }

}
