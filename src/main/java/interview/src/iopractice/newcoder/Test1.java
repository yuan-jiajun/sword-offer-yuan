package iopractice.newcoder;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5647/A
 * 来源：牛客网
 * 计算 a+b
 * 输入描述:输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 * 输出描述:输出a+b的结果
 * 示例1
 * 输入
 * 1 5
 * 10 20
 * 输出
 * 6
 * 30
 **/

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //方法1
        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
            in.nextLine();//这一行代码必须有，返回这一行已经读完后剩下的部分，即和最近的一个换行符之间的字符串
        }

        //方法2
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
//            in.nextLine();//这一行可有可无，因为一行只有2个整数输入
        }

        //方法2
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            System.out.println(a + b);
        }
    }
}
