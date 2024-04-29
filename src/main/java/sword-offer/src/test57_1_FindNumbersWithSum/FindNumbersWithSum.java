package test57_1_FindNumbersWithSum;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Yuan Jiajun
 * @date 2020/8/18 9:37
 * @description https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class FindNumbersWithSum {

    public static ArrayList<Integer> findNumbersWithSum(int[] sortedArray, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        if (sortedArray == null) {
            return list;
        }
        int left = 0;
        int right = sortedArray.length - 1;

        while (left < right) {
            long curSum = sortedArray[left] + sortedArray[right];
            if (curSum == s) {
                list.add(sortedArray[left]);
                list.add(sortedArray[right]);
                break;
            } else {
                if (curSum > s)
                    right--;
                else
                    left++;
            }
        }
        return list;
    }

    public static int[] findNumbersWithSum2(int[] sortedArray, int s) {
        int[] res = new int[2];
        if (sortedArray == null) {
            return res;
        }
        int left = 0;
        int right = sortedArray.length - 1;

        while (left < right) {
            long curSum = sortedArray[left] + sortedArray[right];
            if (curSum == s) {
                res[0] = sortedArray[left];
                res[1] = sortedArray[right];
                break;
            } else {
                if (curSum > s)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }


    @Test
    public void test() {

        ArrayList<Integer> list = findNumbersWithSum(new int[]{10, 26, 30, 31, 47, 60}, 40);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        int[] res = findNumbersWithSum2(new int[]{10, 26, 30, 31, 47, 60}, 40);
        for (Integer integer : res) {
            System.out.println(integer);
        }

    }
}