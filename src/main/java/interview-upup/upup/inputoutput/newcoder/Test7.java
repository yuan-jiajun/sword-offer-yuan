package upup.inputoutput.newcoder;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5647/G
 * 来源：牛客网
 * 题目描述
 * 计算一系列数的和
 * 输入描述:
 * 输入数据有多组, 每行表示一组输入数据。
 * 每行不定有n个整数，空格隔开。(1 <= n <= 100)。
 * 输出描述:每组数据输出求和的结果
 * 输入
 * 1 2 3
 * 4 5
 * 0 0 0 0 0
 * 输出
 * 6
 * 9
 * 0
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            int sum = 0;
            String[] sums = line.trim().split(" ");
            for (String s : sums) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
