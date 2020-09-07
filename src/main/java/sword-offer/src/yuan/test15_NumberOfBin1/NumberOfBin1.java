package yuan.test15_NumberOfBin1;

/**
 * @author yuanjiajun
 * @date 2020/8/28 1:11
 * @description https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class NumberOfBin1 {
    /**
     * 思路：把一个整数减去１再和原整数 与 运算，就会把整数最右边一个１变成０
     */
    public static int numberOfBin(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}