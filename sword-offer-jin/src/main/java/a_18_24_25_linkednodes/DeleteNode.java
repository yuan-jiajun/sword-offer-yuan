package a_18_24_25_linkednodes;

import javax.print.attribute.standard.NumberUp;

/**
 * 使用O（1）的时间删除节点：
 * 思路：当前节点保存下一节点的值，删除下一节点
 */
public class DeleteNode {
    private static void deleteNode(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return;
        }
        //target是尾节点
        if (target.next == null) {
            if (target == head) { //也是头节点
                head = null;
            } else { //遍历
                while (head != null) {
                    if (head.next == target) {
                        head.next = null;
                        return;
                    } else {
                        head = head.next;
                    }
                }
            }
        } else {
            target.value = target.next.value;
            target.next = target.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[11];
        nodes[0] = new ListNode(0);
        for (int i = 0; i <= 9; i++) {
            nodes[i+1] = new ListNode(i+1);
            nodes[i].next = nodes[i+1];
        }

        ListNode head = nodes[0];
        ReverseLinkedList.printList(head);

        deleteNode(head, nodes[5]);
        ReverseLinkedList.printList(head);

        deleteNode(head, nodes[10]);
        ReverseLinkedList.printList(head);
    }
}
