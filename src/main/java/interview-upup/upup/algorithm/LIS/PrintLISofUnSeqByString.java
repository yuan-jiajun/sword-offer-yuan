package upup.algorithm.LIS;

/**
 * @author Yuan Jiajun
 * @date 2020/9/4 16:25
 * @description
 */

public class PrintLISofUnSeqByString {
    public static String lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0)
            return "";

        String[] dp = new String[length];
        dp[0] = String.valueOf(nums[0]);

        for (int i = 1; i < length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                    int len = (dp[i] == null || dp[i].length() == 0) ? 0 : dp[i].split("\\.").length;
                    if (len < dp[j].split("\\.").length + 1) {
                        dp[i] = dp[j] + "." + nums[i];
                    }
                }
            }

            if (count == 0) {
                dp[i] = String.valueOf(nums[i]);
            }
        }

        String res = "";
        for (String s : dp) {
            int len1 = (res == null || res.length() == 0) ? 0 : res.split("\\.").length;
            int len2 = (s == null || s.length() == 0) ? 0 : s.split("\\.").length;
            if (len1 < len2)
                res = s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        String a = lengthOfLIS(nums);
        System.out.println(a);

        System.out.println(lengthOfLIS(new int[]{4, 5, 6, 2, 3, 7}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 8, 6, 4}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}