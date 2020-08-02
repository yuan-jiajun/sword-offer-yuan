package nowcoder.MagicTrucks;

/**
 * @author yuanjiajun
 * @description
 * https://www.nowcoder.com/practice/bf3044df9839488689cb48e1a17cfeba?tpId=113&&tqId=33524&rp=1&ru=/ta/job-code-basic&qru=/ta/job-code-basic/question-ranking
 * @date 2020/7/22 1:43
 *
 * 运行时间： 182 ms
 * 占用内存：49412K
 */


public class Solution {
    /**
     * @param n int整型
     * @param m int整型
     * @param x int整型一维数组
     * @return int整型
     */
    public int Holy(int n, int m, int[] x) {
        // write code here
        int res = 0;
        int total = 0;
        int max = -1;

        for (int i = 0; i < m; i++) {
            total += x[i];
            if (x[i] > max)
                max = x[i];
            if (total >= n) {
                return 0;
            }
        }

        while (!(total >= n)) {
            res++;
            total += max;
            max = max << 1;
        }

        return res;
    }
}