package iopractice.newcoder;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5647/D
 * 来源：牛客网
 *
 * 计算一系列数的和
 *
 *
 * 输入描述：每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为 0 的时候结束输入, 接下来n个正整数,即需要求和的每个正整数。
 * 输出描述:每组数据输出求和的结果
 * 输入
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 0
 * 输出
 * 10
 * 15
 **/
public class Test4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){
            int num = in.nextInt();
            if(num == 0){
                break;
            }

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
