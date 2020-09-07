package upup.inputoutput.newcoder;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5647/B
 * 来源：牛客网
 * 计算a+b
 * 输入描述:输入第一行包括一个数据组数t(1 <= t <= 100)  ,接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
 * 输出描述:输出a+b的结果
 * 示例1
 * 输入
 * 2
 * 1 5
 * 10 20
 * 输出
 * 6
 * 30
 **/
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        while (num > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
            num--;
        }
    }
}
