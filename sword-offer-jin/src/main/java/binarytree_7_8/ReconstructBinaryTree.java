package binarytree_7_8;

import java.util.Arrays;

public class ReconstructBinaryTree {
    /**
     * 根据二叉树的前序遍历序列和中序遍历序列(均无重复值)重建二叉树, 递归实现
     *
     * @param preOrder 前序： 根左右
     * @param inOrder  中序： 左根右
     * @return
     */
    public static BinaryTreeNode reconstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
            throw new RuntimeException("invalid input");
        }

        int rootValue = preOrder[0];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        int rootIndexInOrder = -1;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                rootIndexInOrder = i;
                break;
            }
        }
        if (rootIndexInOrder == -1) {
            throw new RuntimeException("invalid input"); //没找到
        }

        //注意数组拷贝时，前含后不含
        //递归终止条件, 左子节点
        if (rootIndexInOrder > 0) {
            int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, rootIndexInOrder);
            int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, leftInOrder.length + 1);
            //递归
            root.pLeft = reconstructBinaryTree(leftPreOrder, leftInOrder);
        }
        if (rootIndexInOrder < inOrder.length - 1) {
            int[] rightInOrder = Arrays.copyOfRange(inOrder, rootIndexInOrder + 1, inOrder.length);
            int[] rightPreOrder = Arrays.copyOfRange(preOrder, inOrder.length - rightInOrder.length, inOrder.length);
            root.pRight = reconstructBinaryTree(rightPreOrder, rightInOrder);

        }

        return root;

    }

    /**
     * 前序打印二叉树
     *
     * @param root
     */
    static void printBinaryTreePreOrder(BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + "\t");
        if (root.pLeft != null) {
            printBinaryTreePreOrder(root.pLeft);
        }
        if (root.pRight != null) {
            printBinaryTreePreOrder(root.pRight);
        }
    }

    /**
     * 中序打印二叉树
     *
     * @param root
     */
    static void printBinaryTreeInOrder(BinaryTreeNode root) {
        if (root == null)
            return;
        if (root.pLeft != null) {
            printBinaryTreeInOrder(root.pLeft);
        }
        System.out.print(root.value + "\t");
        if (root.pRight != null) {
            printBinaryTreeInOrder(root.pRight);
        }
    }


    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode binaryTreeNode = reconstructBinaryTree(preOrder, inOrder);

        //打印测试
        System.out.println("前序：");
        printBinaryTreePreOrder(binaryTreeNode);
        System.out.println();
        System.out.println("中序：");
        printBinaryTreeInOrder(binaryTreeNode);

    }

}
