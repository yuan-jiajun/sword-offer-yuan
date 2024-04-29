package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 */
public class MultiKeyRadixSort {

    /**
     * 基数排序（多关键字排序）
     * 稳定
     */
    private void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp = 1;//指数
        int bucket_num = 10;

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= bucket_num) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];

            //分桶个数
            int[] buckets = new int[bucket_num];

            //将数据出现的次数存储在相应的buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % bucket_num]++;
            }

            /**下面类似于计数排序*/
            //更改buckets[i]，累加buckets[]，方便数据存储时直接根据取余后的值得到
            for (int i = 1; i < bucket_num; i++) {
                buckets[i] += buckets[i - 1];
            }


            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
//            for (int i = 0; i < arr.length; i++) {//不能这样
                temp[buckets[(arr[i] / exp) % bucket_num] - 1] = arr[i];//下标需要减 1
                buckets[(arr[i] / exp) % bucket_num]--;//放了一个数字后，桶里面的计数值减 1
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
            Arrays.fill(buckets, 0);
        }

    }

    public static void radixSort2(int[] data, int bucket_num, int length) {
        System.out.println("开始排序：");
        int arrayLength = data.length;
        int[] temp = new int[arrayLength];
        int[] buckets = new int[bucket_num];
        for (int i = 0, rate = 1; i < length; i++, rate *= bucket_num) {

            for (int j = 0; j < arrayLength; j++) {
                int hash = (data[j] / rate) % bucket_num;
                buckets[hash]++;
            }
            for (int j = 1; j < bucket_num; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }
            for (int m = arrayLength - 1; m >= 0; m--) {
                int hash = (data[m] / rate) % bucket_num;
                temp[buckets[hash] - 1] = data[m];
                buckets[hash]--;
            }

            System.out.println("对" + rate + "位上子关键字排序：" + Arrays.toString(temp));

            // 当data数组的元素复制到temp数组中进行缓存
            System.arraycopy(temp, 0, data, 0, arrayLength);
            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);

        }
    }


    @Test
    public void test() {
        int[] data2 = {9, 30, 23, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + Arrays.toString(data2));
        radixSort2(data2, 10, 3);
        System.out.println("排序之后：\n" + Arrays.toString(data2));

        System.out.println("**************");
        int[] data = {9, 30, 23, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        radixSort(data);
        System.out.println(Arrays.toString(data));

    }

}

