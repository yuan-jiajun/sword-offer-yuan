package yuan.test32_1_LevelPrintTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 17:06
 * @description @see https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelPrintTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelPrintTreeNodeByLeftToRight(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

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


    @Test
    public void test() throws Exception {
        TreeNode root1 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        levelPrintTreeNodeByLeftToRight(root1);
    }
}