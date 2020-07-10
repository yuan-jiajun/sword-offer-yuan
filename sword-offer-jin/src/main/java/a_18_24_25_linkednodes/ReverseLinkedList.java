package a_18_24_25_linkednodes;


import java.util.Stack;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    /**
     * 反转链表，不使用额外空间, 如可以使用额外空间的话直接使用栈存储一下
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode reversedLast = null;
        ListNode unReversedFirst = head;
        ListNode currentNode;
        while (unReversedFirst != null) {
            currentNode = unReversedFirst;
            unReversedFirst = unReversedFirst.next;
            currentNode.next = reversedLast;
            reversedLast = currentNode;
        }
        return reversedLast;
    }

    private static ListNode reverseLinkedListByStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node1 = null;
        while (head != null) {
            node1 = head;
            stack.push(head);
            head = head.next;
            node1.next = null; //注意此处，需要切断原链表之间的联系，否则会形成环形链表
        }

        ListNode reversedHead = stack.pop();
        ListNode node = reversedHead;
        while (!stack.empty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        //输出
        printList(head);
        //反转
        ListNode reversedHead = reverseLinkedList(head);
        printList(reversedHead);

        //基于栈的反转
        ListNode reversedHead2 = reverseLinkedListByStack(reversedHead);
        printList(reversedHead2);
    }

    static void printList(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.value + " --> ");
            else
                System.out.println(head.value);
            head = head.next;
        }
    }

}


class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }
}