package yuan.test36_TreeToDoublyList;

import org.junit.Test;

/**
 * @author yuanjiajun
 * @description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/
 * @date 2020/8/11 23:28
 */
public class TreeToDoublyList {
    /**
     * 二叉树
     */
    public static class Node {
        public int val;
        public Node left;
        public Node right;
    }

    /**
     * 二叉树的转换
     */
    public static Node treeToDoublyList(Node root) {
        Node pHead = dfs(root, null);
        //指向双向链表的尾节点
        //向前遍历，找到转换后的链表的头节点
        while (pHead != null && pHead.left != null) {
//            System.out.println(pHead.val);
            pHead = pHead.left;
        }

//        System.out.println(pHead.val);
        //返回链表头节点
        return pHead;
    }

    /**
     * 就是一个存粹的中序遍历时候加上了双向链表的赋值操作
     */
    public static Node dfs(Node cur, Node lastNode) {
        if (cur == null) {
            return null;
        }

        //递归处理左子树
        if (cur.left != null) {
            lastNode = dfs(cur.left, lastNode);
        }

        //将当前节点的左指针指向已经转换好的链表的最后一个位置
        cur.left = lastNode;

        //将已经转换好的链表的最后一个节点的右指针指向当前节点
        if (lastNode != null) {
            lastNode.right = cur;
        }
        //上面的2个赋值操作完成了current节点和比它小的那个节点（left)的双向连接


        //更新已经转换好的链表的最后一个节点
        lastNode = cur;

        //递归处理右子树
        if (cur.right != null) {
            lastNode = dfs(cur.right, lastNode);
        }

        return lastNode;
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