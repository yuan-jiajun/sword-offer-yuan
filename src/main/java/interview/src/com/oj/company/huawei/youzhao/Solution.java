package com.oj.company.huawei.youzhao;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/8/19 18:58
 * @description
 */
public class Solution {
    public static int remianLines(int[] frame, int[] brick) {
        int lengthFrame = frame.length;
        int lengthBrick = brick.length;


        if (lengthBrick > lengthFrame)
            return 0;
        int dif = lengthFrame - lengthBrick;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dif; i++) {
            int[] temp = new int[lengthFrame];
            System.arraycopy(frame, 0, temp, 0, lengthFrame);
            for (int j = 0; j < lengthBrick; j++) {
                temp[i + j] = frame[i + j] + brick[j];
            }

            while (isBaseFull(temp)) {
                for (int j = 0; j < temp.length; j++) {
                    temp[j]--;
                }
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] > max) max = temp[j];
                if (temp[j] < min) min = temp[j];
            }
            int height = max - min;
            if (height < res) {
                res = max - min;
            }
        }

        return res;
    }

    public static boolean isBaseFull(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int[] frame = new int[a.length()];
        int[] brick = new int[b.length()];

        for (int i = 0; i < a.length(); i++) {
            frame[i] = a.charAt(i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            brick[i] = b.charAt(i)- '0';
        }
        System.out.println(remianLines(frame, brick));
    }


    @Test
    public void test() {
//        int[] frame = new int[]{2, 2, 0, 2};
//        int[] brick = new int[]{2};

        int[] frame = new int[]{2, 1, 2, 2};
        int[] brick = new int[]{1, 2, 1};

        System.out.println(remianLines(frame, brick));
    }
}