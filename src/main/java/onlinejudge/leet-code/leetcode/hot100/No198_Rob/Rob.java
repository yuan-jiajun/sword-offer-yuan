package leetcode.hot100.No198_Rob;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/9/15 20:12
 * @description @link https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {
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
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
