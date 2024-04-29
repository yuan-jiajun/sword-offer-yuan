package test04_FindNumberIn2DArray;

/**
 * @author yuanjiajun
 * @description
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2020/7/23 3:12
 * <p>
 * 运行时间：99ms
 * 占用内存：17400k
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray1(int target, int[][] array) {
        if (array == null || array.length == 0)
            return false;
        int i = 0;
        int j = array[0].length - 1;
        int tmp;
        /**从二维数组的左上角或右下角开始找*/
        while (i <= array.length - 1 && j >= 0) {
            tmp = array[i][j];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}