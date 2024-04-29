package test53_GetNumberOfK;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 17:27
 * @description
 */
public class GetNumberOfK {
    /**
     * 递归算法
     */
    public static int search(int[] nums, int target) {
        // 若数组为空
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 若数组中只有一个数
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;

        int mid = nums.length / 2;

        if (target < nums[mid]) {
            result += search(Arrays.copyOfRange(nums, 0, mid), target);
        } else if (target > nums[mid]) {
            result += search(Arrays.copyOfRange(nums, mid, nums.length), target);
        } else {
            result += getCount(nums, mid);
        }

        return result;
    }

    /**
     * K与中间的值相等时，从中间值前后分别查找
     */
    private static int getCount(int[] arraySorted, int mid) {
        int k = arraySorted[mid];
        int result = 0;

        for (int i = mid; i < arraySorted.length; i++) {
            if (arraySorted[i] == k) {
                result++;
            } else {
                break;
            }
        }

        for (int i = mid - 1; i >= 0; i--) {
            if (arraySorted[i] == k) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }


    @Test
    public void test() {
        int[] a = new int[]{1, 3};
        System.out.println(search(a, 1));

        int[] b = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(search(b, 8));

        int[] c = new int[]{2, 2};
        System.out.println(search(c, 3));

        int[] d = new int[]{1, 2, 3};
        System.out.println(search(d, 1));
    }
}