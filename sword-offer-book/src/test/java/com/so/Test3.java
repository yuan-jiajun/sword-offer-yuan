package com.so;

import org.junit.Test;

/**
 * 第3题
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
 * 输入一个二维数组和一个整数，判断数组中是否含有整数
 *
 * @author qgl
 * @date 2019/02/17
 */
public class Test3 {
    @Test
    public void test3() {
//        int[][] testArray = {{1, 7, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] testArray = {{0, 1, 2, 4, 5}, {1, 2, 4, 5, 6}, {3, 4, 5, 6, 7}};
        int target = 3;
        System.out.println("解法一：两个指针，数组中是否含有 " + target + " ：" + FindNumber3.find(testArray, target));
        System.out.println("解法二：二分法，数组中是否含有 " + target + " ：" + FindNumber3.find2(testArray, target));
    }
}
