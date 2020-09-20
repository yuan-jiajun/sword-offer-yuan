package leetcode.practice.No213_RobCircle;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/15 20:36
 * @description @link
 */
public class RobCircle {
    public int robCircle(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }


    @Test
    public void test() {
        System.out.println(robCircle(new int[]{2, 3, 2}));
    }
}