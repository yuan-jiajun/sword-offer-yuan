package algorithm.sort;

import org.junit.Test;

/**
 * 堆排序
 * 完全二叉树：必须按照从上到下，从左到右的顺序添加节点
 * 完全二叉树+父节点的数大于子节点的数可以构成堆
 */
public class HeapSort {
    public static void heapSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            int lastIndex = arrayLength - 1 - i;

            // 建堆
            buildMaxdHeap(data, lastIndex);

            // 交换堆顶和最后一个元素，然后删除最后一个元素(i++)，重新树化新的结构
            swap(data, 0, lastIndex);

            System.out.println(java.util.Arrays.toString(data));
        }
    }

    // 对data数组从0到lastIndex建大顶堆
    private static void buildMaxdHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始堆化
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {/**从 x 为根节点开始建堆这里的判定条件就是大于等于 x */

            // k保存当前正在判断的节点
            int k = i;

            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int leftChild = 2 * k + 1;
                int biggerIndex = leftChild;

                // 如果leftChild小于lastIndex, 代表k节点的右子节点存在
                if (leftChild < lastIndex) {
                    int rightChild = leftChild + 1;
                    // 如果右子节点的值较大
                    if (data[leftChild] < data[rightChild]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex = rightChild;
                    }
                }

                // 如果k节点的值小于其较大子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 将较大的值交换到“子堆”堆顶
                    swap(data, k, biggerIndex);

                    /** 将biggerIndex赋给 k，可能因为上面的交换导致原来以biggerIndex为堆顶的结构需要重新堆化，
                     开始while循环的下一次循环，重新保证 k节点的值大于其左、右节点的值*/
                    k = biggerIndex;

                } else {
                    //已经满足堆的结构，跳出循环
                    break;
                }
            }
        }
    }


    // 交换data数组中i、j两个索引处的元素
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    @Test
    public void test() {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30, 293, 108, 161, 783, 376, 265, 330, 598, 646, 812};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        heapSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
