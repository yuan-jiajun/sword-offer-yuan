package NearestNeighbor;

import java.util.*;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/1b2c9a2ba11746958036b29f2e9ee72b?tpId=113&&tqId=33517&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/22 0:49
 */
public class Solution {
    /**
     * 远亲不如近邻
     *
     * @param n int整型 居民个数
     * @param m int整型 方案个数
     * @param a int整型一维数组 居民的位置
     * @param x int整型一维数组 方案对应的位置
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a, int[] x) {
        // write code here
        if (n <= 0) return new int[0];

        int[] res = new int[m];
        Arrays.sort(a);
        for (int i = 0; i < m; ++i) {
            int insertIndex = Arrays.binarySearch(a, x[i]);
            if (insertIndex < 0) {
                insertIndex = -insertIndex - 1;//插入点
                if (insertIndex == 0) res[i] = Math.abs(x[i] - a[0]);
                else if (insertIndex == n) res[i] = Math.abs(x[i] - a[n - 1]);
                else res[i] = Math.min(a[insertIndex] - x[i], x[i] - a[insertIndex - 1]);
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

}