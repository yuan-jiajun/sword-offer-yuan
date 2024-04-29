package test23_FindLoopLinkEnter;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 21:07
 * @description
 */
public class FindLoopLinkEnter {

    static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode enterNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;


            /**剑指offer的方法是找到Meeting节点后，在环中循环一圈得出环的长度，再从pHead出发，快慢双指针，快的先走环的长度
             * 然后双指针同步向前走，直到双指针的对象为同一个时，该对象即是环的入口*/

            /**下面的方法是真的骚，肯定是基于数学进行推算过的，
             * 假设环前 x 个节点， 环内有 y 个节点，meeting在环内的第 z 个节点，有关系式
             * x + y + z = 2 * (x + z)  ---->     x = y - z
             * 于是可以用下面的方法，将 fast = pHead ，当 slow == fast，即使 环的入口*/

            if (slow == fast) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }
        return null;
    }
}