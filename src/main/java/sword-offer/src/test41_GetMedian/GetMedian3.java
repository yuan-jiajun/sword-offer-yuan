package test41_GetMedian;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 17:24
 * @description
 */
public class GetMedian3 {
    Queue<Integer> A, B;

    public GetMedian3() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

    @Test
    public void test() {
        addNum(-2);
        addNum(3);
        addNum(-4);
        System.out.println(findMedian());
    }
}