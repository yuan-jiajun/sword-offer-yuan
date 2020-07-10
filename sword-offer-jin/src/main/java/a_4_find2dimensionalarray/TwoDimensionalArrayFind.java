package a_4_find2dimensionalarray;

/**
 * 二维数组中的查找
 */
public class TwoDimensionalArrayFind {

    /**
     * 二维数组中的查找，输入二维数组，行数及列数
     *
     * @param numbers 二维数组
     * @param rows    行数
     * @param cols    列数
     * @param target  要查找的目标
     * @return 是否找到
     */
    public static boolean findInTwoDimensionalArray(int[][] numbers, int rows, int cols, int target) {
        if (numbers == null || cols < 1 || rows < 1 || numbers.length != rows || numbers[0].length != cols)
            throw new RuntimeException("Invalid input");

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            System.out.println("进入循环");
            if (numbers[row][col] == target) {
                return true;
            }

            //一整列的最小值都比target大，这一整列都不用看了
            if (numbers[row][col] > target) {
                col--;
            } else { //一整行的最大值都比target小，这一整行都不用看了
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(findInTwoDimensionalArray(twoDimensionalArray, 4, 4,7));
        System.out.println(findInTwoDimensionalArray(twoDimensionalArray, 4, 4,8));
        System.out.println(findInTwoDimensionalArray(twoDimensionalArray, 4, 4,20));
        System.out.println(findInTwoDimensionalArray(twoDimensionalArray, 4, 4,3));
        System.out.println(findInTwoDimensionalArray(twoDimensionalArray, 4, 4,5));

    }

}
