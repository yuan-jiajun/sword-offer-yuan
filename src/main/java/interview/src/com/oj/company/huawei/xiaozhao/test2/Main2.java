package com.oj.company.huawei.xiaozhao.test2;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description
 * 输入：源字符串；目标字符串
 * 每个字符串包括多个单词，以一个或多个空格分割，比较时不区分大小写
 * 符号中，逗号 ， 句号 . 叹号 ! 互相视为相同，而 问号 ？ 与其他符号不同，符号偏差规则与单词偏差规则相同
 * 数字与字母处理方式一样，与字母无空格分隔视为一个单词，否则视为多个单词。
 *
 * 输出：
 * 输出偏差与目标字符串单词总数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.split(";")[0];
        String s2 = s.split(";")[1];

        char[] chPre = s1.toCharArray();
        char[] chAns = s2.toCharArray();

        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");

        int step = 0;
        int totalLen = 1;

        for (char ch : chAns) {
            if (ch == ' ' || ch == ',' || ch == '.' || ch == '!' || ch == '?') {
                totalLen++;
            }
        }

        if (s1.equalsIgnoreCase(s2)) {
        } else {
            for (int i = 0, j = 0; i < split1.length && j < split2.length; ) {
                String sa = split1[i];
                String sb = split2[j];

                if (sa.equals(sb)) {
                    i++;
                    j++;
                } else {
                    if (j + 1 < split2.length && split1[i].equals(split2[j + 1])) {
                        j++;
                        step++;
                        continue;
                    } else if (i + 1 < split1.length && split1[i + 1].equals(split2[j])) {
                        i++;
                        step++;
                        continue;
                    }
                    i++;
                    j++;
                    step++;
                }
            }
        }

        System.out.println("(" + step + "," + totalLen + ")");
    }
}