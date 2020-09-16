package upup.com.oj.bank.cmbnt;

import java.util.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/6 21:11
 * @description 输入：
 * 第一行：节点的个数，
 * 第二行：邻接矩阵表达的服务关系
 * 第三行： 起点服务编号
 * <p>
 * A[0][1] == 1 表示节点0会调用节点1
 * A[4][0] == 0 表示节点4不会调用节点0
 */
public class Main {
    static int length = 0;
    static int startServer = 0;
    static boolean isFind = false;
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        int[][] matrix = new int[length][length];

        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                matrix[j][i] = sc.nextInt();
            }
        }

        startServer = sc.nextInt();
        iter(matrix, startServer, "");

        Set<String> set = new HashSet<>(res);

        for (String s : set) {
            System.out.println(new StringBuilder(s).reverse().substring(0, s.length() - 1));
        }
    }


    public static void iter(int[][] matrix, int col, String s) {
        if (s.replace(startServer + "", "").contains(col + ""))
            return;

        if (col == startServer) {
            if (!isFind) {
                isFind = true;
            } else {
                s = s + col;
                res.add(s);
                return;
            }
        }

        s = s + col;

        List<Integer> list = nextCols(matrix, col);

        int i = 0;
        while (list.size() != 0 && i < list.size()) {
            i++;
            for (Integer integer : list) {
                iter(matrix, integer, s);
            }
        }
    }

    public static List<Integer> nextCols(int[][] matrix, int col) {
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < length; j++) {
            if (matrix[j][col] == 1)
                res.add(j);
        }
        return res;
    }

}
