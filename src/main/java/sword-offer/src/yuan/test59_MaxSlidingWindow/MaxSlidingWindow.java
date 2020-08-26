package yuan.test59_MaxSlidingWindow;

import org.junit.Test;

import java.util.*;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/27 0:13
 */
public class MaxSlidingWindow {
    /**
     * 解法一：两个for循环
     */
    public static ArrayList<Integer> maxSlidingWindow(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size < 1 || num.length < size)
            return list;
        int length = num.length - size + 1;//滑动的次数

        for (int i = 0; i < length; i++) {
            int max = num[i];
            for (int j = i; j < i + size; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }

        return list;
    }

    public static int[] maxSlidingWindowForLeetcode(int[] nums, int k) {

        if (nums.length <= 0)
            return new int[]{};

        int length = nums.length - k + 1;//滑动的次数
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }

        return res;
    }

    /**
     * 解法二：时间复杂度更低的双端队列
     */
    public static ArrayList<Integer> maxSlidingWindow2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            int begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
            else if (begin > q.peekFirst())
                q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }

    public static int[] maxSlidingWindow2ForLeetcode(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]

            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast(); // 保持 deque 递减
            }

            deque.addLast(nums[j]);

            if (i >= 0)
                res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3));
        System.out.println(maxSlidingWindow2(nums, 3));
        System.out.println(Arrays.toString(maxSlidingWindowForLeetcode(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow2ForLeetcode(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowForLeetcode(new int[]{}, 0)));
    }


}