package yuan.test39_MoreThanHalfNum;

/**
 * @author Yuan Jiajun
 * @date 2020/8/27 16:42
 * @description @link https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class MoreThanHalfNum {
    /**
     * 获取数组中出现次数超过数组长度一半的数字
     */
    public static int moreThanHalfNum(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    /**
     * 检查输入的数字出现的次数是否超过数组长度一半
     */
    private static boolean checkMoreThanHalf(int[] array, Integer number) {
        int times = 0;
        for (int i : array) {
            if (i == number) {
                times++;
            }
        }
        return times * 2 >= array.length;
    }
}