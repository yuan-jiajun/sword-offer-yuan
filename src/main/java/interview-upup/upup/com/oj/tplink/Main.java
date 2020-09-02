package upup.com.oj.tplink;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:40
 * @description
 */
class Main {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        max = Math.max(count, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{4, 5, 6, 2, 3, 7}));
    }

}