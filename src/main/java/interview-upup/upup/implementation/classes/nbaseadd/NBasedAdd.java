package upup.implementation.classes.nbaseadd;

import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/16 18:53
 * @description @link
 */
public class NBasedAdd {
    static Scanner in = new Scanner(System.in);

    public static String addByBasedN(String a, String b, int based) {
        StringBuilder res = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;

        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            res.append((char) (carry % based + '0'));
            carry /= based;
        }

        if (carry > 0) {
            res.append('1');
        }

        res.reverse();

        return res.toString();
    }

    public static void main(String[] args) {
        String a = in.next();
        String b = in.next();
        int based = in.nextInt();
        System.out.println(addByBasedN(a, b, based));
    }

}