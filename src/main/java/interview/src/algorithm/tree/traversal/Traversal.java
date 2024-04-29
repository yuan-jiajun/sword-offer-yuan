package algorithm.tree.traversal;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @description https://www.jianshu.com/p/456af5480cee
 * @date 2020/8/9 22:15
 */
public class Traversal {
    static class TreeNode {
        int val;
        //左子树
        TreeNode left;
        //右子树
        TreeNode right;

        //构造方法
        TreeNode(int x) {
            val = x;
        }
    }

    // 递归先序遍历
    public static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    // 递归中序遍历
    public static void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.print(root.val + " ");
            recursionMiddleorderTraversal(root.right);
        }
    }

    // 递归后序遍历
    public static void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 非递归先序遍历
    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;

        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }

            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    // 非递归中序遍历
    public static void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }


    // 非递归后序遍历
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            //上面的代码基本上是一样的


            //查看当前栈顶元素
            node = treeNodeStack.peek();/**这一步很重要*/

            //如果其右子树也为空，或者右子树已经访问，则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                //将node设置为null，防止根节点重复压入左孩子节点。
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println("recursionPreorderTraversal: ");
        recursionPreorderTraversal(root);
        System.out.println("\npreorderTraversal: ");
        preorderTraversal(root);

        System.out.println("\nrecursionMiddleorderTraversal: ");
        recursionMiddleorderTraversal(root);
        System.out.println("\nmiddleorderTraversal: ");
        middleorderTraversal(root);

        System.out.println("\nrecursionPostorderTraversal: ");
        recursionPostorderTraversal(root);
        System.out.println("\npostorderTraversal: ");
        postorderTraversal(root);
    }

    private static TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        node1.left = node3;

        TreeNode node4 = new TreeNode(4);
        node3.left = node4;

        return root;
    }


}