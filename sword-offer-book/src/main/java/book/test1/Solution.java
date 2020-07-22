package book.test1;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&&tqId=11154&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @date 2020/7/23 3:12
 * <p>
 * 运行时间：99ms
 * 占用内存：17400k
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
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