package yuan.test27_MirrorofBinaryTree;

import java.util.Stack;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/27 2:22
 */
public class MirrorofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一：递归
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    /**
     * 解法二：非递归，利用栈
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode res = root;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 交换左右子节点
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return res;
    }
}