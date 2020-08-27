package yuan.test39_MoreThanHalfNum;

/**
 * @author Yuan Jiajun
 * @date 2020/8/27 16:42
 * @description
 */
public class MoreThanHalfNum {
    /**
     * 获取数组中出现次数超过数组长度一半的数字
     */
    public static int moreThanHalfNum(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return checkMoreThanHalf(nums, candidate) ? candidate : 0;
    }

    /**
     * 检查输入的数字出现的次数是否超过数组长度一半
     */
    private static boolean checkMoreThanHalf(int[] array, Integer number) {
        int times = 0;
        for (int i : array) {
            if (i == number) {
                times++;
            }
        }
        return times * 2 >= array.length;
    }
}