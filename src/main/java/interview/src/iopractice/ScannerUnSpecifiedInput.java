package iopractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerUnSpecifiedInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * 接收这种输入, 第一行这个数字用来提示后面还有多少行，但是每行的个数是不定的
         * 3
         * 1 2 3 4 5 4 7 9
         * 7 2 3 4 5 4 8
         * 4 2 3 2 5 6
         */
        /*
         * 读取一行然后切分的方式
         */
        int num = scanner.nextInt();
        //注意，这里nextInt读完还在上一行，需要先读取一个换行符到下一行去
        scanner.nextLine();

        ArrayList[] lines = new ArrayList[num];

        for (int i = 0; i < num; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            String line = scanner.nextLine();
            String[] split = line.trim().split("\\s+");
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            lines[i] = list;
        }

        for (ArrayList line : lines) {
            System.out.println(line);
        }
    }
}
