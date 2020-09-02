package upup.demos;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:50
 * @description
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class demos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        lengthOfLIS(arr);
    }

    public static void lengthOfLIS(int[] nums) {
        int[] minTail = new int[nums.length];
        int[] dp = new int[nums.length];
        int len = 0;
        for (int l = 0; l < nums.length; l++) {
            int i = Arrays.binarySearch(minTail, 0, len, nums[l]);
            while (i >= 0) {
                i = Arrays.binarySearch(minTail, i + 1, len, nums[l]);
            }
            i = -i - 1;
            if (i == len) {
                len++;
            }
            minTail[i] = nums[l];
            dp[l] = i + 1;
        }
        int[] res = new int[len];
        int index = res.length - 1;
        int next = Integer.MAX_VALUE;
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] <= next && dp[k] == index + 1) {
                res[index] = nums[k];
                next = res[index];
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int val : res)
            sb.append(val).append(" ");
        System.out.println(sb.toString());
    }

    @Test
    public void test() {
        lengthOfLIS(new int[]{4, 5, 6, 2, 3, 7});
        lengthOfLIS(new int[]{1, 2, 8, 6, 4});

    }
}