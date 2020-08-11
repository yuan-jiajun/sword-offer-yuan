package yuan.test3_findRepeatNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuan Jiajun
 * @description
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @date 2020/8/11 14:45
 */
public class FindRepeatNumber {
    public int findRepeatNumber1(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            /**直到第i位的数字是i跳出循环，如果第i位找不到i则一定能在第i位的循环中找到重复的数字*/
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        /**如果遍历完整个数组都没找到重复数字，则返回-1*/
        return -1;
    }


    /**
     * 方式采用了集合的特性
     * 时间复杂度：O(n)
     * 遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)O(1)，故总的时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(n)
     * 不重复的每个元素都可能存入集合，因此占用 O(n)O(n) 额外空间
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();//todo:hashset的实现原理
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 先排序在查找，排序之后有重复的肯定是挨着的，然后前后两两比较，如果有重复的直接返回
     */
    public int findRepeatNumber3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }


}