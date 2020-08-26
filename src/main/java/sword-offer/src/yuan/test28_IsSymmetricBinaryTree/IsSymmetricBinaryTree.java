package yuan.test28_IsSymmetricBinaryTree;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:14
 * @description
 */
public class IsSymmetricBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isCommon(pRoot.left, pRoot.right);
    }

    /**
     * 判断左右子树是否相等
     */
    public static boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        return leftNode.val == rightNode.val && isCommon(leftNode.left, rightNode.right) && isCommon(leftNode.right, rightNode.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
    }
}