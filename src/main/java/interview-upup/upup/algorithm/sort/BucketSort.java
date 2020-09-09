package upup.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 * <p>
 * 复杂度分析
 * 1. 时间复杂度：O(N + C)
 * 对于待排序序列大小为 N，共分为 M 个桶，主要步骤有：
 * N 次循环，将每个元素装入对应的桶中
 * M 次循环，对每个桶中的数据进行排序（平均每个桶有 N/M 个元素）
 * 一般使用较为快速的排序算法，时间复杂度为 O(NlogN)，实际的桶排序过程是以链表形式插入的。
 * 整个桶排序的时间复杂度为：
 * O(N)+O(M∗(N/M∗log(N/M)))=O(N∗(log(N/M)+1))O(N)+O(M∗(N/M∗log(N/M)))=O(N∗(log(N/M)+1))
 * 当 N = M 时，复杂度为 O(N)
 * <p>
 * 2. 额外空间复杂度：O(N + M)
 * <p>
 * 稳定性分析
 * 桶排序的稳定性取决于桶内排序使用的算法。
 */
public class BucketSort {
    public static void bucketSort(int[] arr) {
        // 计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
//		ArrayList<Integer[]> bucketArr = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);//计算放入的桶的id
            bucketArr.get(num).add(arr[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
		for (ArrayList<Integer> integers : bucketArr) {
			for (Integer integer : integers) {
				arr[index++] = integer;
			}
		}
    }

    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + Arrays.toString(data));
        bucketSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
