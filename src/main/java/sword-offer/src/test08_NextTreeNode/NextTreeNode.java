package test08_NextTreeNode;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/28 0:45
 * 给定一个二叉树的某个结点，请找出中序遍历顺序的下一个结点并且返回
 */
public class NextTreeNode {
    /**
     * 二叉树
     */
    public static class TreeLinkNode {
        public int val;
        public TreeLinkNode left = null;
        public TreeLinkNode right = null;
        public TreeLinkNode parent = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 获取输入节点的下一个节点
     *
     * 如果节点存在右子树：那么它的下一个节点就是右子树中的最左节点；
     * 如果节点没有右子树：
     *     节点为其父节点的左子节点，那么其父节点就是它的下一个节点；
     *     节点为其父节点的右子节点，那么需要沿其父指针一直向上遍历，一直找到某个节点是其父节点的左子节点为止，那么这个节点的父节点即是需要寻找的下一个节点。
     */
    public static TreeLinkNode getTreeLinkNextNode(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        //节点右子树为空时
        while (pNode.parent != null) {
            // 找第一个当前节点是父节点左孩子的节点
            if (pNode.parent.left == pNode)
                return pNode.parent;

            pNode = pNode.parent;
        }

        return null;
    }
}