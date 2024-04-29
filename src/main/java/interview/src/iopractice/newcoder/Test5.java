package iopractice.newcoder;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/5647/E
 * 来源：牛客网
 * 计算一系列数的和
 * 输入
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 输出
 * 10
 * 15
 **/
public class Test5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rows  = in.nextInt();
        while(rows > 0){
            int num = in.nextInt();
            int sum = 0;
            while(num > 0){
                sum += in.nextInt();
                num--;
            }
            System.out.println(sum);
            rows--;
        }
    }
}
