package test56_FindNumAppearOnce;

/**
 * @author yuanjiajun
 * @description
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * @date 2020/8/18 1:54
 */
public class FindNumAppearOnce {

    public static int[] findNumAppearOnce(int[] array) {
        int[] onceNumber = new int[2];
        if (array == null) {
            return null;
        }

        int number = 0;
        for (int i : array) {
            number ^= i;
        }

        int index = findFirstBitIs1(number);

        for (int i : array) {
            // 第index位是0的数，即第一个数
            if (isBit1(i, index)) {
                onceNumber[0] ^= i;
            } else {
                // 第index位是1的数，即第二个数
                onceNumber[1] ^= i;
            }
        }
        return onceNumber;
    }

    /**
     * 获取二进制中最右边是1的位置
     */
    private static int findFirstBitIs1(int number) {
        int indexBit = 0;

        while ((number & 1) == 0) {
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    /**
     * 判断从右边起，第index位是不是0
     *
     * @param number
     * @param index
     * @return
     */
    private static boolean isBit1(int number, int index) {
        number = number >> index;
        return (number & 1) == 0;
    }
}