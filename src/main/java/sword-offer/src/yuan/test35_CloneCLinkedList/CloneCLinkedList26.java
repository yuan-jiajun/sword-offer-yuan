package yuan.test35_CloneCLinkedList;

/**
 * @author yuanjiajun
 * @description 复制一个复杂链表
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @date 2020/8/12 2:37
 */
public class CloneCLinkedList26 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 解法一
     *
     * @param head
     * @return
     */
    public static Node Clone1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }


        cur = head;
        //复制random pCur是原来链表的结点 cur.next是复制pCur的结点
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }


        Node cloneHead = head.next;
        cur = head;
        Node cloneCur = cloneHead;
        //拆分链表
        while (cur != null) {
            cur.next = cur.next.next;

            if (cloneCur.next != null) {
                cloneCur.next = cloneCur.next.next;
            }
            cloneCur = cloneCur.next;
            cur = cur.next;
        }
        return cloneHead;
    }
}