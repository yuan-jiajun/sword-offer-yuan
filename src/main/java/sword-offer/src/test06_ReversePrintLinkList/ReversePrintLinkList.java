package test06_ReversePrintLinkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 12:50
 * @description
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrintLinkList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法一：利用栈输出
     */
    public static ArrayList<Integer> printListReverse1(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();

        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }

        return list;
    }

    /**
     * 解法二：递归（其实底层还是栈）
     */
    public static ArrayList<Integer> printListReverse2(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (headNode != null) {
            if (headNode.next != null) {
                list = printListReverse2(headNode.next);
            }
            list.add(headNode.val);
        }
        return list;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        System.out.println("解法一：利用栈输出，反转后：" + ReversePrintLinkList.printListReverse1(node1));
        System.out.println("解法二：递归，反转后：" + ReversePrintLinkList.printListReverse2(node1));
    }
}