package com.oj.company.pdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 18:34
 * @description N*M的小正方形格子，矩阵由0和1组成，1表示一个士兵，一个格子的上下左右视为与该格子相邻。
 * 玩家可以再每个格子上布置一个士兵，并且每个士兵和相邻士兵归为同一个队伍，
 * 现在移动任意格子上的士兵到任意一个空格上，求移动后可以得到的最大队伍士兵数
 * <p>
 * 第一行输入两个整数，N,M(1<=N,M<=400)分别代表格子和列数
 * 接下来的N行，每行M个数字，空格切分，数字0或1代表士兵数量
 * <p>
 * 输出：输出一行包含一个整数，表示可得到的最大队伍士兵数
 */
public class CalculateMaxTeam {

    public static Set[] divideToSets(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        int row = matrix.length;
        int col = matrix[0].length;
        Set<String>[] sets = new HashSet[row * col];


        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
        int[][] flag = new int[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                flag[x][y] = 0;
            }
        }

        int TotalUsedSetsCount = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                int setIdTemp = -1;
                if (matrix[x][y] == 1 && flag[x][y] == 0) {
                    flag[x][y] = 1;
                    for (int i = 0; i < sets.length; i++) {
                        Set set = sets[i];
                        if (set.contains("" + (x - 1) + y) ||
                                set.contains("" + (x + 1) + y) ||
                                set.contains("" + x + (y + 1)) ||
                                set.contains("" + x + (y - 1))) {
                            setIdTemp = i;
                            sets[setIdTemp].add("" + x + y);
                            break;
                        }
                    }

                    if (setIdTemp == -1) {
                        sets[TotalUsedSetsCount].add("" + x + y);
                        setIdTemp = TotalUsedSetsCount;
                        TotalUsedSetsCount++;
                    }

                    if (y + 1 < col && matrix[x][y + 1] == 1 && flag[x][y + 1] == 0) {//右边
                        flag[x][y + 1] = 1;
                        int idTemp = y + 1;
                        sets[setIdTemp].add("" + x + idTemp);
                    }
                    if (y - 1 > 0 && matrix[x][y - 1] == 1 && flag[x][y - 1] == 0) {//左边
                        flag[x][y - 1] = 1;
                        int idTemp = y - 1;
                        sets[setIdTemp].add("" + x + idTemp);
                    }
                    if (x - 1 > 0 && matrix[x - 1][y] == 1 && flag[x - 1][y] == 0) {//上边
                        flag[x - 1][y] = 1;
                        int idTemp = x - 1;
                        sets[setIdTemp].add("" + idTemp + y);
                    }
                    if (x + 1 < row && matrix[x + 1][y] == 1 && flag[x + 1][y] == 0) {//下边
                        flag[x + 1][y] = 1;
                        int idTemp = x + 1;
                        sets[setIdTemp].add("" + idTemp + y);
                    }

                }


            }
        }
        return sets;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrixInput = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixInput[i][j] = in.nextInt();
            }
        }

        int[][] clone;
        int maxLength = 0;

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                clone = Arrays.copyOfRange(matrixInput, 0, matrixInput.length);
                if (clone[x][y] == 0) {
                    for (int x2 = 0; x2 < row; x2++) {
                        for (int y2 = 0; y2 < col; y2++) {
                            if (clone[x2][y2] == 1) {
                                clone[x][y] = 1;
                                clone[x2][y2] = 0;
                                Set[] sets = divideToSets(clone);
                                for (Set set : sets) {
                                    if (set.size() > maxLength)
                                        maxLength = set.size();
                                }
                                clone[x][y] = 0;
                                clone[x2][y2] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxLength);
    }


    @Test
    public void test2() {
        int[][] matrixInput = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 0, 0}};

        int maxLength = 0;

        Set[] sets = divideToSets(matrixInput);

        for (Set set : sets) {
            if (set.size() > maxLength)
                maxLength = set.size();
        }
        System.out.println(maxLength);
    }


    @Test
    public void test() {

//        int[][] matrixInput = new int[][]{
//                {0, 1, 0, 0},
//                {1, 0, 1, 1},
//                {0, 1, 0, 0}};

        int[][] matrixInput = new int[][]{
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1}};


        int maxLength = 0;
        int[][] clone;

        int row = matrixInput.length;
        int col = matrixInput[0].length;

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                clone = Arrays.copyOfRange(matrixInput, 0, matrixInput.length);
                if (clone[x][y] == 0) {
                    for (int x2 = 0; x2 < row; x2++) {
                        for (int y2 = 0; y2 < col; y2++) {
                            if (clone[x2][y2] == 1) {

                                clone[x][y] = 1;
                                clone[x2][y2] = 0;

                                Set[] sets = divideToSets(clone);
                                for (Set set : sets) {
                                    if (set.size() > maxLength)
                                        maxLength = set.size();
                                }

                                clone[x][y] = 0;
                                clone[x2][y2] = 1;

                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxLength);
    }
}