package com.alibaba.test1;

import java.util.Scanner;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/3/30 19:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < list.length; i++) {
            list[i] = in.nextInt();
        }


        int total = 0;
        for (int i = 0; i < m; i++) {
            total = total(list, k);
        }
        System.out.println(total);

    }

    public static int total(int[] list, int k) {

        for (int i = 0; i < list.length; i++) {
            list[i] += k;
        }
        int maxNumber = list[0];
        int maxSequence = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > maxNumber) {
                maxNumber = list[i];
                maxSequence = i;
            }
        }
        list[maxSequence] = list[maxSequence] / 2;

        int total = 0;
        for (int i = 0; i < list.length; i++) {
            total += list[i];
        }
        return total;
    }
}