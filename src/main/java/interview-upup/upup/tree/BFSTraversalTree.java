package upup.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 17:06
 * @description 广度优先遍历：从根节点出发，在横向遍历二叉树层段节点的基础上纵向遍历二叉树的层次。
 */
public class BFSTraversalTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代，队列
     */
    public static List<List<Integer>> BFSPrintTreeNodeByLeftToRight1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //队列存的是下一行的TreeNode
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> tmp = new ArrayList<>();
        int start = 0;
        int end = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            start++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }

        return res;
    }

    /**
     * 递归
     */
    public static List<List<Integer>> BFSPrintTreeNodeByLeftToRight2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        traversal(1, root, res);

        return res;
    }

    /**
     * @param index 用于判定行数，并将每一行的Node放入一个List
     * @param root
     * @param res
     * @return: void
     * @description:
     */
    static void traversal(int index, TreeNode root, List<List<Integer>> res) {
        if (res.size() < index) {
            res.add(new ArrayList<Integer>());
        }

        res.get(index - 1).add(root.val);

        if (root.left != null) {
            traversal(index + 1, root.left, res);
        }
        if (root.right != null) {
            traversal(index + 1, root.right, res);
        }
    }

    @Test
    public void test() throws Exception {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        /*
                原二叉树
                     8
                   /   \
                  9     7
                /   \
               10    2
                    / \
                   4   1
        */


        System.out.println("层序输出的二叉树：" + BFSTraversalTree.BFSPrintTreeNodeByLeftToRight1(root));
        System.out.println("层序输出的二叉树：" + BFSTraversalTree.BFSPrintTreeNodeByLeftToRight2(root));
    }
}