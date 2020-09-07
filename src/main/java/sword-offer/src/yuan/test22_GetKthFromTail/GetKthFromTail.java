package yuan.test22_GetKthFromTail;

/**
 * @author yuanjiajun
 * @date 2020/8/18 1:22
 * @description https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */
public class GetKthFromTail {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一：一快一慢两个指针，快指针先走k步，然后两个指针同时走
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 1) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 解法二：不推荐，O(n^2)，先获取链表长度，在用链表长度减去k的值，求得该值处的节点
     */
    public static ListNode findKthToTail2(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode target = null;
        if (length == k) {
            target = head;
        }

        for (int i = 0; i < length - k; i++) {
            head = head.next;
            target = head;
        }
        return target;
    }
}