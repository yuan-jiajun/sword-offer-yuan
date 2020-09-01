package yuan.test32_LevelPrintTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 17:06
 * @description
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
}