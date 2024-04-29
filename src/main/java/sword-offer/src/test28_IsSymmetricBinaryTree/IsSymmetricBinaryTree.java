package test28_IsSymmetricBinaryTree;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:14
 * @description @link https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
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
        if (leftNode == null && rightNode == null) {//递归结束条件
            return true;
        }

        //左右子树刚好有一个null的情况
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

            /**顺序很重要*/
            stack.push(t1.left);
            stack.push(t2.right);

            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
    }
}