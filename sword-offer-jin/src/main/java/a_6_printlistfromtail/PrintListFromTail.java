package a_6_printlistfromtail;

import java.util.Stack;

public class PrintListFromTail {

    /**
     * 从头到尾打印链表
     *
     * @param head 链表头
     *             两种实现方式：1是反转链表，然后从头到尾打印，这需要修改原来的链表
     *             2是借助栈来实现
     *             具体使用哪种需要跟面试官交流，确定需求
     */
    public static void printListFromTail(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().nodeValue + "  ");
        }

    }

    //测试
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            temp.next = listNode;
            temp = listNode;
        }
        printListFromTail(head);
        System.out.println(head.nodeValue);
    }
}
