package yuan.test21_OddEvenNumber;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 9:49
 * @description https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class OddEvenNumber {
    /**
     * 解法一：移动偶数位置
     * 时间复杂度 O（n²)，空间复杂度 O（1)
     */
    public int[] reOrderArray1(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            if (array[i] % 2 != 0) {//如果array[i]是奇数
                while (j >= 0) {

                    if (array[j] % 2 != 0) {//奇数
                        break;
                    }

                    if (array[j] % 2 == 0) {//偶数
                        swap(array, j + 1, j);
                        j--;
                    }
                }
            }
        }
        return array;
    }

    /**
     * 解法二：双指针法,类似于快排
     * 时间复杂度 O（n)，空间复杂度 O（1)
     */
    public int[] reOrderArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            /**从前往后找，直到找到个偶数*/
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            /**从后往前找，直到找到个奇数数*/
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reOrderArray1(nums)));
        System.out.println(Arrays.toString(reOrderArray2(nums)));
    }

}