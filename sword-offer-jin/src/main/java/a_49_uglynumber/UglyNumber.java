package a_49_uglynumber;

/**
 * 寻找第n个丑数(只包含因子2，3，5的数)
 */
public class UglyNumber {
    /**
     * 采用空间换时间的方法，避免不必要计算
     *
     * @return
     */
    private static int getNthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        //保存丑数的数组
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int currentIndex = 1;

        int multiply2 = 0; //初始化指向第一个索引
        int multiply3 = 0;
        int multiply5 = 0;
        while (currentIndex < n) {
            int min = Math.min(Math.min(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3), uglyNumbers[multiply5] * 5);
            uglyNumbers[currentIndex] = min;
            //更新几个索引的值
            while (uglyNumbers[multiply2] * 2 <= uglyNumbers[currentIndex]) {
                multiply2++;
            }
            while (uglyNumbers[multiply3] * 3 <= uglyNumbers[currentIndex]) {
                multiply3++;
            }
            while (uglyNumbers[multiply5] * 5 <= uglyNumbers[currentIndex]) {
                multiply5++;
            }
            currentIndex++;
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        int n = 1500;
        System.out.println(getNthUglyNumber(n));
    }

}
