package upup.com.oj.company.meituan.turn1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 10:23
 * @description
 * 公司有n位员工，除了最高领导都有一位直接领导，可以看作一棵树
 * 1.每个人要么没有下属，要么至少2个直接下属
 * 2.第 i 个人的下属（包括自己）恰好有 n 个
 *
 * 输入：
 * 第一行：一个整数n，公司总人数
 * 第二行：n个整数，第 i 个数为 第 i 个人的下属个数
 *
 * 例子：
 * 3 //YES
 * 1 1 3
 * 2 //No
 * 1 2
 */
public class Main4 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            String res = "";

            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 2) {
                    res = "NO";
                }
            }


            if (res.equals("NO")) {
                System.out.println("NO");
            } else {
                int[] clone = Arrays.copyOfRange(arr, 0, arr.length);
                Arrays.sort(clone);
                boolean[] temp = new boolean[clone.length];
                Arrays.fill(temp, false);


                for (int i = clone.length - 1; i > 0; i--) {
                    boolean find = false;
                    if (!temp[i] && clone[i] > 1) {
                        for (int j = i - 1; j >= 0; j--) {
                            for (int k = i - 1; k >= 0; k--) {
                                if (!temp[j] && !temp[k] && j != k && clone[j] + clone[k] + 1 == clone[i]) {
                                    temp[i] = true;
                                    if (clone[j] == 1) {
                                        temp[j] = true;
                                    }
                                    if (clone[k] == 1) {
                                        temp[k] = true;
                                    }
                                    find = true;
                                    break;
                                }
                            }
                            if (find) {
                                break;
                            }
                        }
                    }
                }

                res = "YES";
                for (boolean b : temp) {
                    if (b == false) {
                        res = "NO";
                    }
                }
                System.out.println(res);
            }

        }
    }
}