package a_40_41_minknumbers;

import java.util.*;

/**
 * @program: swordofferjava
 * @description: 通过Java优先级队列解决最小的k个数问题
 * @author: Jin Hongjian
 * @create: 2020-07-05
 **/
public class MinKNumbersByPriorityQueue {
    /**
     * 复杂度：O(NlogK) + O(K)
     * 特别适合处理海量数据
     *
     * @return
     */
    public static ArrayList<Integer> getMinKNumbers(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return null;

        //维护一个size为k的大顶推，在没有到size个数时，直接进堆；如果已近存在k个数了，再次进来的元素大于等于堆顶元素直接忽略，小于的话则更新堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }


    public static void main(String[] args) {

        int[] randomNums = new int[]{90, 14, 56, 46, 21, 71, 93, 0, 6, 12};

        System.out.println(getMinKNumbers(randomNums, 3));
        System.out.println(getMinKNumbers(randomNums, 5));

        System.out.println();
        System.out.println();

        //测试熟悉下优先级队列
        Random random = new Random();

/*        for (int i = 0; i < 10; i++) {
            randomNums[i] = random.nextInt(100);
        }*/

        System.out.println(Arrays.toString(randomNums));

        //插入优先级队列，小顶堆（树的定点保存的是最小值），升序，不用比较器的默认实现就是这样
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        /*PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        for (int randomNum : randomNums) {
            maxHeap.offer(randomNum);
            System.out.print(maxHeap.peek() + "   ");
        }
        System.out.println();
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + "   ");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        //插入优先级队列，大顶堆（树的顶点保存的是最大值），降序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1)); //采用java 8 lambda的写法
        /*PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
        for (int randomNum : randomNums) {
            minHeap.offer(randomNum);
            System.out.print(minHeap.peek() + "   ");
        }
        System.out.println();
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + "   ");
        }

    }
}
