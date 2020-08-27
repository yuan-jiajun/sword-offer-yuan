package yuan.test15_NumberOfBin1;

/**
 * @author yuanjiajun
 * @date 2020/8/28 1:11
 * @description
 */
public class NumberOfBin1 {
    /**
     * 思路：把一个整数减去１再和原整数与，就会把整数最右边一个１变成０
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