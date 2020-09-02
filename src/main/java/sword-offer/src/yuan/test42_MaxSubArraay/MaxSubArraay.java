package yuan.test42_MaxSubArraay;

/**
 * @author yuanjiajun
 * @description
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * @date 2020/8/18 0:48
 */
public class MaxSubArraay {
    /**
     * 解法一:贪心
     * 当叠加的和小于0时，就从下一个数重新开始，
     * 同时更新最大和的值(最大值可能为其中某个值)，
     * <p>
     * 当叠加和大于0时，将下一个数值加入和中，
     * 同时更新最大和的值，依此继续。
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int resSum = Integer.MIN_VALUE;
        int curSum = 0;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 当curSum小于0时，就从下一个数重新开始
            // 同时更新每次叠加的最大值
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                // 和大于0时
                curSum += nums[i];
            }

            // 不断更新子串的最大值
            if (curSum > resSum) {
                resSum = curSum;
            }
        }
        return resSum;
    }

    /**
     * 解法二：
     * 动态规划解析：
     * 状态定义： 设动态规划列表 dpdp ，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
     * <p>
     * 为何定义最大和 dp[i] 中必须包含元素 nums[i] ：保证 dp[i] 递推到 dp[i+1]的正确性；如果不包含 nums[i] ，递推时则不满足题目的 连续子数组 要求。
     * 转移方程： 若 dp[i−1]≤0 ，说明 dp[i−1] 对 dp[i] 产生负贡献，即 dp[i−1]+nums[i] 还不如 nums[i] 本身大。
     * <p>
     * 当 dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]；
     * 当 dp[i−1]≤0 时：执行 dp[i] = nums[i]；
     * 初始状态：dp[0]=nums[0]，即以 nums[0] 结尾的连续子数组最大和为nums[0] 。
     * <p>
     * 返回值： 返回 dpdp 列表中的最大值，代表全局最大值。
     * 。
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}