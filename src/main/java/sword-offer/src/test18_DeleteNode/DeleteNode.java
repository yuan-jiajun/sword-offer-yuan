package test18_DeleteNode;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 15:00
 * @description https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 剑指offer原题情形的解法
     * 传入的是要删除的节点的指针，而不是值
     * 不需要从头开始遍历链表
     * 只需要将要删除的节点的后面一个节点的值复制给要删除的节点，
     * 删除节点的下一个节点指向原来的下下个节点
     */
    public static void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null)
            return;

        if (head == deListNode) {
            head = null;
        } else {
            // 若删除节点是末尾节点，往后移一个
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }


    /**
     * leetcode题目的解法
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点，返回删除后的链表的头节点。
     * 说明：题目保证链表中节点的值互不相同
     * 传入的是要删除的节点的值
     */

    /**
     * 一个重要的结论，在链表删除的时候，如果使用单指针进行操作，指向的 只能是 deleteNode.next
     * 如果只是单纯的用一个next指针，即使找到了要删除的节点，就像下面的方法deleteNode2，
     * 需要考虑的东西太过于复杂，且无法处理要删除的节点是最后一个节点的情况，因为deleteNode是
     * 栈上指向被删除节点的引用变量，单deleteNode是最后一个节点的时候，无法直接将deleteNode赋值为null
     * 这样只是将栈空间的变量使得其不指向任何对象，而原来的链表没有将最后一个节点删除
     */

    //测试不通过
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;

//        if (head.val == val) return head.next;

        ListNode deleteNode = head;
        while (deleteNode != null && deleteNode.val != val) {
            deleteNode = deleteNode.next;
        }

        if (deleteNode == head)
            return head.next;
        else if (deleteNode == null) {
            return head;
        } else {//deleteNode != null
            if (deleteNode.next != null) {
                deleteNode.val = deleteNode.next.val;
                deleteNode.next = deleteNode.next.next;
            } else {
                deleteNode = null;//todo:这里是这个方法的bug点
            }
        }
        return head;

    }

    /**
     * 只能使用deleteNode.next
     */
    public ListNode deleteNode3(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;

        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }


    @Test
    public void test() throws Exception {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode2(head, 5);


//        ListNode head = new ListNode(-3);
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(-99);
//        head.next = node2;
//        node2.next = node3;
//        deleteNode2(head, -99);

        // 输出链表的值
        printListNode(head);
    }

    /**
     * 输出链表的所有值
     *
     * @param head
     */
    public void printListNode(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

}

