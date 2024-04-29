package com.speak.baidu.sre;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/8/28 11:37
 * @description 有两个数组a, b，大小都为n,数组元素为任意整数，无序， 要求：通过交换a,b中的元素，使[数组a元素的和]与[数组b元素的和]之间差的绝对值最小。
 */
public class Second {
    public static void main(String[] args) {
        int[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] arrayOne = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
//        int[] arrayOne = {11, 12, 13, 14, 15, 16, 17, 18};

        reOrder(arrayOne, arrayTwo);

        System.out.println(JSONObject.toJSONString(arrayOne));
        System.out.println(Arrays.stream(arrayOne).sum());
        System.out.println(JSONObject.toJSONString(arrayTwo));
        System.out.println(Arrays.stream(arrayTwo).sum());

    }

    /**
     * 计算过程
     * 1、分别求出两个数组的和及对应的差值
     * 2、分别在两个数组中找出一个数据，使得这两个数据的差值最接近数组和的差值，然后记录坐标
     * 3、交换两个坐标的数据，然后递归执行此过程。
     * 4、当数组和相等时，又或者是两个数组中找不到元素差值小于数组和差值的数据时得出最终结果
     */
    public static void reOrder(int[] array, int[] array2) {
        //求出两个数组的和
        int sumOne = Arrays.stream(array).sum();
        int sumTwo = Arrays.stream(array2).sum();
        int diff = sumOne >= sumTwo ? sumOne - sumTwo : sumTwo - sumOne;

        //两个数组和相等
        if (diff == 0) {
            return;
        }

        //找到一对小于等于差值的数据进行交换
        // 记录需要更换的两个坐标，以及坐标的差值
        int sub_one = 0, sub_two = 0, sub_diff = -1;

        if (sumOne > sumTwo) {
            for (int i = 0; i < array.length; i++) {
                int currentNum = array[i];
                for (int j = 0; j < array2.length; j++) {
                    int currentNum2 = array2[j];

                    if (currentNum > currentNum2 && currentNum - currentNum2 < diff) {
                        if (currentNum - currentNum2 > sub_diff) {
                            sub_diff = currentNum - currentNum2;
                            sub_one = i;
                            sub_two = j;
                        }
                    }

                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                int currentNum = array[i];
                for (int j = 0; j < array2.length; j++) {
                    int currentNum2 = array2[j];
                    if (currentNum < currentNum2 && currentNum2 - currentNum < diff) {
                        if (currentNum2 - currentNum > sub_diff) {
                            sub_diff = currentNum2 - currentNum;
                            sub_one = i;
                            sub_two = j;
                        }
                    }
                }
            }
        }

        // 交换位置，递归处理
        if (sub_diff > 0) {
            int tmp = array[sub_one];
            array[sub_one] = array2[sub_two];
            array2[sub_two] = tmp;
            reOrder(array, array2);
        }

    }
}