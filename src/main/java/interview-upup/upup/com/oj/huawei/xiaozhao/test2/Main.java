package upup.com.oj.huawei.xiaozhao.test2;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 18:14
 * @description
 */
public class Main {
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

        if (!s1.equalsIgnoreCase(s2)) {
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