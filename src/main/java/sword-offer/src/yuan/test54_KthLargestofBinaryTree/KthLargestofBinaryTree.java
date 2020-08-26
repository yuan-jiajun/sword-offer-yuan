package yuan.test54_KthLargestofBinaryTree;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:24
 * @description
 */
public class KthLargestofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        /**
         * 解法一：递归
         */
        private int count = 0;

        public TreeNode kthLargest(TreeNode root, int k) {
            if (root == null) {
                return null;
            }
            TreeNode node = kthLargest(root.left, k);
            if (node != null) {
                return node;
            }
            count++;
            if (count == k) {
                return root;
            }
            node = kthLargest(root.right, k);
            return node;
        }

        /**
         * 解法二：非递归中序遍历反过来，借用栈查找
         */
        public TreeNode kthLargest2(TreeNode root, int k) {
            if (root == null || k < 1) {
                return null;
            }
            int index = 0;
            Stack<TreeNode> s = new Stack<>();
            while (root != null || !s.isEmpty()) {
                while (root != null) {
                    s.push(root);
                    root = root.right;/**和中序遍历反过来*/
                }

                if (!s.isEmpty()) {
                    root = s.pop();
                    index++;
                    if (index == k) {
                        return root;
                    }
                    root = root.left;/**和中序遍历反过来*/
                }
            }

            return null;
        }
    }
}