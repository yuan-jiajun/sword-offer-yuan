package yuan.test36_treeToDoublyList;

import org.junit.Test;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/12 0:40
 */
public class TreeToDoublyList2 {
    /**
     * 二叉树
     */
    public static class Node {
        public int val;
        public Node left;
        public Node right;
    }

    Node lastNode, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        cur.left = lastNode;
        if (lastNode != null) lastNode.right = cur;
        else head = cur;
        lastNode = cur;
        dfs(cur.right);
    }

    @Test
    public void test() throws Exception {
        Node root1 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        root1.val = 6;
        node1.val = 2;
        node2.val = 7;
        node3.val = 1;
        node4.val = 4;
        node5.val = 3;
        node6.val = 5;

        treeToDoublyList(root1);
    }
}