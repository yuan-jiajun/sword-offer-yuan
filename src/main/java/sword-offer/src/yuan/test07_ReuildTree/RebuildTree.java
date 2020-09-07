package yuan.test07_ReuildTree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yuanjiajun
 * @description
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * @date 2020/8/12 0:50
 */
public class RebuildTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法一：递归（传入数组的拷贝）
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree2(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree2(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }


    /**
     * 解法二：递归：传入子数组的边界索引
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private static TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        int length = 0;
        while (length <= inR && inorder[inL + length] != rootVal) {
            length++;
        }

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, preL + 1, preL + length, inorder, inL, inL + length - 1);
        root.right = helper(preorder, preL + length + 1, preR, inorder, inL + length + 1, inR);

        return root;
    }

    @Test
    public void test() {
        // 前序遍历结果
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        // 中序遍历结果
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = buildTree(pre, in);
        System.out.println();
    }
}
