package a_13_robotrange;

/**
 * 通过回溯法寻找机器人的运动范围
 */
public class RobotRange {
    /**
     * 在一个rows行 cols栏中的矩阵中，查找机器人能够到达多少个格子
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(0, 0, rows, cols, threshold, visited);
    }

    private static int movingCountCore(int row, int col, int totalRows, int totalCols, int threshold, boolean[][] visited) {
        int count = 0;
        if (0 <= row && row < totalRows && 0 <= col && col < totalCols && !visited[row][col] && check(row, col, threshold)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(row, col + 1, totalRows, totalCols, threshold, visited)
                    + movingCountCore(row, col - 1, totalRows, totalCols, threshold, visited)
                    + movingCountCore(row + 1, col, totalRows, totalCols, threshold, visited)
                    + movingCountCore(row - 1, col, totalRows, totalCols, threshold, visited);

        }
        return count;
    }

    private static boolean check(int row, int col, int threshold) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }
        if (sum > threshold)
            return false;
        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold;
    }


    public static void main(String[] args) {
        int a = 18;
        int b = 19;
        int t = 19;
        System.out.println(movingCount(4,4,4));
    }

}
