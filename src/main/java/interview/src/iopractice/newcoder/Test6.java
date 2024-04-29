package iopractice.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/F
 * 来源：牛客网
 *
 * 题目描述
 * 计算一系列数的和
 *
 * 输入描述:
 * 输入数据有多组, 每行表示一组输入数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 * 输出描述:
 * 每组数据输出求和的结果
 * 示例1
 * 输入
 * 复制
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 输出
 * 复制
 * 10
 * 15
 **/
public class Test6 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){
            int num = in.nextInt();
            int sum = 0;
            while(num > 0){
                sum += in.nextInt();
                num--;
            }
            System.out.println(sum);
            in.nextLine();
        }

    }

}
