package iopractice.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/H
 * 来源：牛客网
 * <p>
 * 题目描述
 * 对输入的字符串进行排序后输出
 * 输入描述:
 * 输入有两行，第一行n
 * <p>
 * 第二行是n个空格隔开的字符串
 * 输出描述:
 * 输出一行排序后的字符串，空格隔开，无结尾空格
 * 示例1
 * 输入
 * 复制
 * 5
 * c d a bb e
 * 输出
 * 复制
 * a bb c d e
 **/
public class LinesStringDicOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //方法1
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            String[] strs = line.trim().split(" ");
            Arrays.sort(strs);
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }


        //方法2,不推荐，在有些环境下会报java.util.NoSuchElementException: No line found
        String line;
        while (!(line = in.nextLine()).isEmpty()) {
            String[] strs = line.trim().split(" ");
            Arrays.sort(strs);
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}
