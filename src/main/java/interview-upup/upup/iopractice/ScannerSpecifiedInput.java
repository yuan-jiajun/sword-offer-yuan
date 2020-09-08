package upup.iopractice;

import java.util.Scanner;

public class ScannerSpecifiedInput {

    /*
     * 测试Scanner的单字符读取或单行读取
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        * 接收这种输入, 第一行这个数字用来提示第二行有多少个数
        * 5
        * 1 2 3 4 5
        */
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
            System.out.println(nums[i]);
        }

    }
}
