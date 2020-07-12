package book;

/**
 * @author Yuan Jiajun
 * @description 链表
 * @date 2020/7/10 12:47
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }


    /**
     * 获取链表的所有节点
     *
     * @param head
     * @return
     */
    public static String getAllListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" → ");
            head = head.next;
        }
        return sb.length() < 1 ? null : sb.substring(0, sb.length() - 2);
    }
}