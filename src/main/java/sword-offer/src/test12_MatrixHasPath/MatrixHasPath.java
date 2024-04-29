package test12_MatrixHasPath;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 19:41
 * @description https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class MatrixHasPath {

    /**
     * 回溯法(DFS)
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] arr) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, arr, 0, flag))
                    return true;
            }
        }
        return false;
    }

    /**
     * 判断是否匹配
     */
    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int stringIndex, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[stringIndex] || flag[index] == 1)
            return false;

        if (stringIndex == str.length - 1)
            return true;

        flag[index] = 1;

        /**个人感觉回溯的精髓就是下面这几行代码*/
        if (helper(matrix, rows, cols, i - 1, j, str, stringIndex + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, stringIndex + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, stringIndex + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, stringIndex + 1, flag)) {
            return true;
        }

        /**重新置 0*/
        flag[index] = 0;

        return false;
    }
}