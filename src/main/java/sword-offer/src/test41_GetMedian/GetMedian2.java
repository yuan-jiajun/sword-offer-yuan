package test41_GetMedian;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 17:10
 * @description
 */
public class GetMedian2 {
    private static int count = 0;

//    private static Queue<Integer> minHeap = new PriorityQueue<>();
//    private static Queue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2.compareTo(o1);
//        }
//    });

    private static Queue<Integer> minHeap = new PriorityQueue<>(); // 小顶堆，保存较大的一半
    private static Queue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半


    public void addNum(int num) {
        // 当数据的个数为奇数时，进入大根堆(保存较小的一半)
        if ((count & 1) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            // 当数据的个数为偶数时，进入小根堆(保存较大的一半)
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        count++;
    }

    public double findMedian() {

//        if (count == 0) {
//            return null;
//        }

        // 当数据个数是奇数时，中位数就是大根堆的顶点
        if ((count & 1) == 1) {
            return (double) minHeap.peek();
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }

    @Test
    public void test() {
//        addNum(-2);
//        addNum(3);
//        addNum(-4);
        addNum(1);
        System.out.println(findMedian());
    }
}