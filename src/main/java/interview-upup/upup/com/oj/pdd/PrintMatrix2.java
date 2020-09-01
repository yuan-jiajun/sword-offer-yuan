package upup.com.oj.pdd;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 20:37
 * @description 对于n阶矩阵，首先用米字形分割线把矩阵等分为8 个区域，然后从右上角开始，
 * 按逆时针顺序给各区域编号为1,2,...,8
 * 同时矩阵元素需要满足：
 * 1.各区域内的元素都等于区域的编号
 * 2.被分割线穿过的元素都等于0
 * 打印
 */
public class PrintMatrix2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        int n = 4;
        int[][] arr = new int[n][n];
        for (int[] ints : arr) {
            Arrays.fill(ints, 0);
        }


        int vertical = n / 2;
        int horizon = vertical;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < vertical && j < horizon && i < j)
                    arr[i][j] = 2;
                if (i < vertical && j > horizon&&)
                    arr[i][j] = 1;

            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}