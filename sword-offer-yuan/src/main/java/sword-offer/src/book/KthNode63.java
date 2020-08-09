package book;

import java.util.Stack;

/**
 * 第63题
 * 给定一棵二叉搜索树，请找出其中的第k小的结点
 *
 * @author qgl
 * @date 2017/08/30
 */
public class KthNode63 {
    /**
     * 解法一：递归
     *
     * @param pRoot
     * @param k
     * @return
     */
    private int count = 0;
    public Common.TreeNode KthNode(Common.TreeNode pRoot, int k) {
        if(pRoot == null) {
            return null;
        }
        Common.TreeNode node = KthNode(pRoot.left, k);
        if(node != null) {
            return node;
        }
        count++;
        if(count == k) {
            return pRoot;
        }
        node = KthNode(pRoot.right, k);
        return node;
    }

    /**
     * 解法二：非递归，借用栈查找
     *
     * @param pRoot
     * @param k
     * @return
     */
    public Common.TreeNode getKthNode2(Common.TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        int index = 0;
        Common.TreeNode root = pRoot;
        Stack<Common.TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            if (!s.isEmpty()) {
                root = s.pop();
                index++;
                if (index == k) {
                    return root;
                }
                root = root.right;
            }
        }
        return null;
    }
}
