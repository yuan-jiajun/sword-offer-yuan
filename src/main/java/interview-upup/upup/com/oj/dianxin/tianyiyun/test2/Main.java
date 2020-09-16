package upup.com.oj.dianxin.tianyiyun.test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/16 21:27
 * @description @link
 */
public class Main {
    public static String Puzzle(String s) {
        int[] num = new int[26];
        Arrays.fill(num, 1);
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (num[s.charAt(i) - 'a'] <= min) {
                min = num[s.charAt(i) - 'a'];
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() && i >= 0; i++) {
            if (num[s.charAt(i) - 'a'] != min) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
            System.out.println(Puzzle(string));
        }
    }

}