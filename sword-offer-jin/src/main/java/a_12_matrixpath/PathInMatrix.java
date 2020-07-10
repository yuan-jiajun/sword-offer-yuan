package a_12_matrixpath;

public class PathInMatrix {

    private static int currentIndex = 0;

    /**
     * 使用回溯法在矩阵中查找是否存在字符串路径
     *
     * @param charMatrix 矩阵
     * @param rows       行数
     * @param cols       列数
     * @param target     目标字符串
     * @return
     */
    public static boolean findPathInMatrix(char[][] charMatrix, int rows, int cols, String target) {
        if (charMatrix == null || charMatrix.length != rows || charMatrix[0].length != cols || target == null) {
            throw new RuntimeException("invalid input");
        }
        //先确保不为空
        if (target.isEmpty()) {
            return false;
        }

        boolean[][] visited = new boolean[rows][cols]; //开始时全部都是false
        char[] targetCharArray = target.toCharArray(); //转为字符数组方便判断
        currentIndex = 0; //重置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { //遍历矩阵中所有节点，作为开始节点
                if (hasPathCore(charMatrix, rows, cols, i, j, targetCharArray, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯法查找
     */
    private static boolean hasPathCore(char[][] charMatrix, int totalRows, int totalCols, int row, int col, char[] target, boolean[][] visited) {
        if (currentIndex == target.length) {//找到字符串结尾了，递归终止条件
            return true;
        }
        //判断当前节点是否匹配, 在这里判断二维数组的边界，边界作为递归终止条件之一
        boolean match = false;
        if (0 <= row && row < totalRows && 0 <= col && col < totalCols && !visited[row][col] && target[currentIndex] == charMatrix[row][col]) { //这里不匹配是直接结束本次函数返回
            currentIndex++;
            visited[row][col] = true; //设为已访问

            match = hasPathCore(charMatrix, totalRows, totalCols, row + 1, col, target, visited)
                    || hasPathCore(charMatrix, totalRows, totalCols, row - 1, col, target, visited)
                    || hasPathCore(charMatrix, totalRows, totalCols, row, col + 1, target, visited)
                    || hasPathCore(charMatrix, totalRows, totalCols, row, col - 1, target, visited); //四个方向都试试,递归

            if (!match) { //没找到，回溯
                currentIndex--;
                visited[row][col] = false;
            }

        }

        return match;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };

        String target = "bfce";
        String target2 = "abfb";

        System.out.println(findPathInMatrix(chars,3,4,target));
        System.out.println(findPathInMatrix(chars,3,4,target2));

    }

}
