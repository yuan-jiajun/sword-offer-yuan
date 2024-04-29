package test40_GetLeastNumbers;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 14:41
 * @description @link https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {

    /**
     * 主要思想是：
     * 将数组前 k 个数建立一次大顶堆，k后面的数依次和堆顶元素比较，
     * 如果比堆顶元素大，就不管，如果比堆顶元素小就和堆顶元素交换，重新树化堆
     */
    public static int[] getLeastNumbers(int[] array, int k) {
        int[] res = new int[k];
        if (array == null || k < 1 || k > array.length) {
            return res;
        }

        int[] kArray = Arrays.copyOfRange(array, 0, k);

        //根据输入数组前k个数建立最大堆
        for (int i = kArray.length / 2; i >= 0; i--) {
            maxHeapIfy(kArray, i, kArray.length);
        }

        //从k开始与根节点比较，若大于根节点，舍去，若小于，取代根节点，重排最大堆
        for (int i = k; i < array.length; i++) {
            if (array[i] < kArray[0]) {
                kArray[0] = array[i];
                maxHeapIfy(kArray, 0, kArray.length);
            }
        }


        for (int i = k - 1; i >= 0; i--) {
            res[i] = kArray[i];
        }

        return res;
    }

    private static void maxHeapIfy(int[] array, int root, int length) {
        int leftChild = 2 * root + 1;

        if (leftChild >= length) {
            return;
        }

        int maxChild = leftChild;
        if (leftChild + 1 < length && array[leftChild] < array[leftChild + 1]) {
            int rightChild = leftChild + 1;
            maxChild = rightChild;
        }

        if (array[maxChild] > array[root]) {
            swap(array, maxChild, root);
            maxHeapIfy(array, leftChild, length);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    @Test
    public void test() {
        int[] arr = new int[]{0, 1, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 1)));
    }

}