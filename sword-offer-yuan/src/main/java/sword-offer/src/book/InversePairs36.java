package book;

import java.util.Arrays;

/**
 * 第36题
 * 数组中的两个数字如果前面一个数字大于后面一个数字，
 * 则这两个数字组成一个逆序对，输入一个数组，求逆序对的总数
 *
 * @author qgl
 * @date 2017/08/15
 */
public class InversePairs36 {
    /**
     * 获取逆序对的总数
     *
     * @param array
     * @return
     */
    public static int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return getInversePairs(array, Arrays.copyOf(array, array.length), 0, array.length - 1);
    }

    private static int getInversePairs(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = getInversePairs(array, copy, low, mid);
        int rightCount = getInversePairs(array, copy, mid + 1, high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                // 防止数值过大而求余
                count %= 1000000007;
            } else {
                copy[locCopy--] = array[j--];
            }
        }

        for (int a = i; a >= low; a--) {
            copy[locCopy--] = array[a];
        }
        for (int b = j; b > mid; b--) {
            copy[locCopy--] = array[b];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }


    /**
     * 解法二：获取逆序对的总数
     *
     * @param array 输入的数组长度较大时有bug
     * @return
     */

    /**
     * 记录逆序对的数量
     */
    private static int count = 0;

    public static int inversePairs2(int[] array) {
        if (array == null) {
            return 0;
        }

        int len = array.length;
        int[] copy = new int[len];
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = array[i];
        }

        subCount(copy, 0, array.length - 1, temp);
        return count;
    }

    private static void subCount(int[] data, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            subCount(data, left, mid, temp);
            subCount(data, mid + 1, right, temp);
            mergeCount(data, left, mid, right, temp);
        }
    }

    /**
     * 思路同归并排序
     */
    public static void mergeCount(int[] data, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        int index = left;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (temp[i] < temp[j]) {
                data[index++] = temp[i++];
            } else {
                count += mid - i + 1;
                // 防止数值过大而求余
                count %= 1000000007;
                data[index++] = data[j++];
            }
        }

        while (i <= mid) {
            data[index++] = temp[i++];
        }

        while (j <= right) {
            count += mid - i + 1;
            data[index++] = temp[j++];
        }
    }
}
