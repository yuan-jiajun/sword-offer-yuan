package yuan.test62_CircleLastRemain;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:39
 * @description
 */
public class CircleLastRemain {
    /**
     * 解法一：借助链表
     * 尝试了下 LinkedList 会超时，我猜是因为 LinkedList 虽然删除指定节点的时间复杂度是 O(1) 的，
     * 但是在 remove 时间复杂度仍然是 O(n) 的，因为需要从头遍历到需要删除的位置。
     * 那 ArrayList 呢？索引到需要删除的位置，时间复杂度是 O(1)，删除元素时间复杂度是 O(n)
     * （因为后续元素需要向前移位）， remove 整体时间复杂度是 O(n)的。
     * <p>
     * 看起来LinkedList 和 ArrayList 单次删除操作的时间复杂度是一样的 ？所累哇多卡纳(这可说不定呐)
     * ArrayList 的 remove 操作在后续移位的时候，其实是内存连续空间的拷贝的！
     * 所以相比于LinkedList大量非连续性地址访问，ArrayList的性能是很 OK 的！
     */
    public static int lastRemain1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
//            index = (index + m - 1) % list.size();
//            list.remove(index);

            index = (index + 1) % list.size();
            if (index % m == 0)
                list.remove(index);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

    /**
     * 解法二：公式法
     */
    public static int lastRemain2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            // i个人时删除数的索引等于i-1个人时删除数的索引+k(再对i取余)
            last = (last + m) % i;
        }
        return last;
    }

    @Test
    public void test45() throws Exception {
        int n = 700;
        int m = 5;
        System.out.println("解法一，借助链表，圈圈里剩下的最后一个数字：" + lastRemain1(n, m));
        System.out.println("解法二，公式法，圈圈里剩下的最后一个数字：" + lastRemain2(n, m));
    }
}