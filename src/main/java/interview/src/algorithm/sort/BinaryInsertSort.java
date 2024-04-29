package algorithm.sort;

import org.junit.Test;

/**
 * 折半插入排序
 * 插入排序的基本操作是在一个有序表中进行查找和插入,这个“查找”操作可利用“折半查找”来实现
 */

public class BinaryInsertSort {
	public static void binaryInsertSort(int[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;

		for (int i = 1; i < arrayLength; i++) {
			int temp = data[i];
			int low = 0;
			int high = i - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (temp > data[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			for (int j = i; j > low; j--) {
				data[j] = data[j - 1];
			}
			data[low] = temp;

			System.out.println(java.util.Arrays.toString(data));
		}

	}

	@Test
	public void test() {
		int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		binaryInsertSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
