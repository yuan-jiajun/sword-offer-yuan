package upup.com.oj.netease;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/8/8 15:00
 */
public class Solution {
    public static int arrayPrimeNumberCount(int[] array) {
        int count = 0;
        for (int a : array) {
            count += intPrimeNumberCount(a);
        }
        return count;
    }

    public static int intPrimeNumberCount(int a) {
        return a >> 1;
    }


    public static void main(String[] args) {
//        System.out.println(arrayPrimeNumberCount(new int[]{1, 1, 1,}));
//        System.out.println(arrayPrimeNumberCount(new int[]{5, 3, 7}));

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = in.nextInt();
        }

        System.out.println(arrayPrimeNumberCount(array));
    }
}