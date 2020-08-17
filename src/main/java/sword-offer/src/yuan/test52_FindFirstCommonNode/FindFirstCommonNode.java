package yuan.test52_FindFirstCommonNode;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/18 0:30
 */
public class FindFirstCommonNode {
    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }


    /**
     * 解法一：长链表先走，需要遍历链表
     */
    public static ListNode findFirstCommonNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int length1 = getListLength(p1);
        int length2 = getListLength(p2);
        int diff = 0;
        /**使2条链表的长度变得一样长*/
        if (length1 - length2 > 0) {
            diff = length1 - length2;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            diff = length2 - length1;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }


        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static int getListLength(ListNode root) {
        int result = 0;
        if (root == null)
            return result;
        ListNode point = root;

        while (point != null) {
            point = point.next;
            result++;
        }
        return result;
    }

    /**
     * 解法二：不需要遍历链表
     */
    public static ListNode findFirstCommonNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {/**类似于A + B = B + A*/
            p1 = (p1 != null ? p1.next : headB);
            p2 = (p2 != null ? p2.next : headA);
        }
        return p1;
    }

}