package yuan.test57_2_FindContinuousSequence;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/8/18 9:53
 * @description
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
public class FindContinuousSequence {

    /**
     * 解法一
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();

        int small = 1;
        int big = 2;

        while (small < (target + 1) / 2) {
            int curSum = 0;
            for (int i = small; i <= big; i++) {
                curSum += i;
            }

            if (curSum == target) {
                int[] temp = new int[big - small + 1];
                for (int i = small, j = 0; i <= big; i++, j++) {
                    temp[j] = i;
                }
                resList.add(temp);
                small++;
            } else if (curSum < target) {
                big++;
            } else {//curSum > target
                small++;
            }
        }
        return resList.toArray(new int[0][]);


        /**这种转换的格式不对
         输入：9
         输出：[[2,3,4],[4,5,0]]
         预期结果：[[2,3,4],[4,5]]*/
//        return arrayList2IntArrayUtil(resList);
    }

    public int[][] arrayList2IntArrayUtil(ArrayList<ArrayList<Integer>> list) {
        int a, b = 0;
        a = list.size();
        for (ArrayList<Integer> arrayList : list) {
            if (b < arrayList.size()) {
                b = arrayList.size();
            }
        }
        int[][] res = new int[a][b];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> arrayList = list.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                Integer integer = arrayList.get(j);
                res[i][j] = integer;
            }
        }
        return res;
    }

    /**
     * 解法2
     * 如果有两个连续的数之和等于target，那么相差为1，
     * (target - 1) % 2 == 0， 且数组一定是从 (target - 1) / 2开始的，数组的元素就是2个；
     * <p>
     * 如果是3个连续的数组，那么三个数之间相差为1、2，
     * (target - 1 - 2) % 3 == 0，且数组一定是从 (target - 1 - 2) / 3开始的，数组元素是3个，
     * <p>
     * 依次类推，但是注意target必须是大于0的数，且res需要倒序
     */

    public int[][] findContinuousSequence2(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;

        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] array = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    @Test
    public void test() {
        int[][] res = findContinuousSequence(9);
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
        }

        int[][] res2 = findContinuousSequence2(9);
        for (int[] re : res2) {
            for (int i : re) {
                System.out.println(i);
            }
        }
    }

}
