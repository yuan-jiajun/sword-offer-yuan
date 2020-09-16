package upup.com.oj.company.meituan.turn1;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 9:54
 * @description
 * 给一串偶数个字符，只有大小写字母，求修改多少个字母可以让大小写数量相同。
 */
public class Main2 {
    private static int lowerCount = 0;
    private static int upperCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c >= 'a' && c <= 'z') {
                lowerCount++;
            }
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }
        }
        int dif = Math.abs(lowerCount - upperCount);
        System.out.println(dif / 2);
    }
}