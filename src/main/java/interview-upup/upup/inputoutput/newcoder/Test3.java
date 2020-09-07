package upup.inputoutput.newcoder;

import java.util.Scanner;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-30
 * 链接：https://ac.nowcoder.com/acm/contest/5647/C
 * 来源：牛客网
 * 计算a+b
 * 如果输入为0 0则结束输入
 * 输入
 * 1 5
 * 10 20
 * 0 0
 * 输出
 * 6
 * 30
 **/
public class Test3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //方法1
        while(in.hasNextLine()){
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == 0 && b == 0){
                break;
            }
            System.out.println(a+b);
            in.nextLine();
        }


        //方法2
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("0 0"))
                break;
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            System.out.println(a + b);
        }
    }
}
