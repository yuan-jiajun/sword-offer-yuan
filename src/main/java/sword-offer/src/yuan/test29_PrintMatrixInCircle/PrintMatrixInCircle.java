package yuan.test29_PrintMatrixInCircle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 14:48
 * @description
 */
public class PrintMatrixInCircle {

    public static int[] printMatrixForLeetcode(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return new int[]{};//或者return new int[0]

        int start = 0;

        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            saveOneCircle(matrix, start, list);
            start++;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 打印矩阵
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null)
            return list;

        int start = 0;

        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            saveOneCircle(matrix, start, list);
            start++;
        }

        return list;
    }

    /**
     * 记录矩阵的环
     */
    private static void saveOneCircle(int[][] matrix, int start, ArrayList<Integer> list) {
        int endX = matrix[0].length - 1 - start; // 结束列
        int endY = matrix.length - 1 - start;  // 结束行

        // 从左往右
        for (int i = start; i <= endX; i++)
            list.add(matrix[start][i]);

        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++)
                list.add(matrix[i][endX]);
        }

        // 从右往左（判断是否会重复打印）
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--)
                list.add(matrix[endY][i]);
        }

        // 从下往上(判断是否会重复打印)
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--)
                list.add(matrix[i][start]);
        }

    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = printMatrixForLeetcode(matrix);
        System.out.println(Arrays.toString(res));
    }
}