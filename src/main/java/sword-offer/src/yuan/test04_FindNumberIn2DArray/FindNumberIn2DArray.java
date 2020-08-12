package yuan.test04_FindNumberIn2DArray;

/**
 * @author yuanjiajun
 * @description
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
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