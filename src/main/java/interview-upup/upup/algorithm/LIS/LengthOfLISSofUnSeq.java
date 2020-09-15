package upup.algorithm.LIS;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/4 11:53
 * @description 给定一个无序的整数数组，找到其中最长上升非连续子序列的长度。（非连续）
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 这道题有两种做法，
 * 一种是DP也就是动态规划，第i个元素之前的最小上升子序列的长度无非就是max(dp[i],dp[j]+1),
 * <p>
 * 另一种做法就是二分查找法，再新建一个数组，然后第一个数先放进去，然后第二个数和第一个数比较，如果说大于第一个数，那么就接在他后面，
 * 如果小于第一个数，那么就替换，一般的，如果有i个数，那么每进来一个新的数，都要用二分查找法来得知要替换在哪个位置的数。
 * 因为有个for循环，所以是O(N),在加上循环里有个二分查找，所以最后是O(NlogN)的时间复杂度。
 * <p>
 * 相当于维护一个结果数组，如果当前元素比结果数组的值都大的的话，就追加在结果数组后面（相当于递增序列长度加了1）；
 * 否则的话用当前元素覆盖掉第一个比它大的元素
 * （这样做的话后续递增序列才有可能更长，即使并没有更长，这个覆盖操作也并没有副作用哈，
 * 当然这个覆盖操作可能会让最终的结果数组值并不是最终的递增序列值，这无所谓,反正只是求长度）
 */
public class LengthOfLISSofUnSeq {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];

        // 自己一定是一个子序列
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int res = dp[0];

        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //二分查找如果找到了就返回元素下标，没有找到就返回第一个比查找元素大的元素的下标的相反数减一
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0 ? -idx - 1 : idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLIS2(new int[]{4, 5, 6, 2, 3, 7}));
        System.out.println(lengthOfLIS(new int[]{4, 5, 6, 2, 3, 7}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 8, 6, 4}));

    }
}