package com.oj.company.tplink;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:40
 * @description 给定一个无序的整数数组，找到其中最长上升连续子序列的长度。（连续）
 */
class PrintAndLengthofLISofSeq {
    public static int lengthofLCISofSeq(int[] nums) {
        if (nums.length == 0)
            return 0;

        int length = 0;
        int count = 0;
        List<Integer> res = new ArrayList<Integer>();

        res.add(count++, nums[0]);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                res.add(count++, nums[i + 1]);
            } else {
                length = Math.max(res.size(), length);
                res.clear();
                count = 0;
                res.add(count++, nums[i + 1]);
            }
        }

        //最长可能在最后的情况
        length = Math.max(res.size(), length);

//        System.out.print(Arrays.toString(res.toArray()));

        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthofLCISofSeq(new int[]{4, 5, 6, 2, 3, 7}));
        System.out.println(lengthofLCISofSeq(new int[]{1, 2, 8, 6, 4}));
    }

}