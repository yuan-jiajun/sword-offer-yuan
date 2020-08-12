package yuan.test26_IsSubTree;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 18:55
 * @description
 */
public class IsSubTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubStructure(TreeNode treeA, TreeNode treeB) {
        if (treeA == null || treeB == null) {
            return false;
        }

        if (isTreeATreeBEqual(treeA, treeB)) {
            return true;
        }

        return isSubStructure(treeA.left, treeB) || isSubStructure(treeA.right, treeB);
    }

    /**终止条件一定不能搞错了
     * 终止条件：
     * 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
     * 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
     * 当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
     *
     * 返回值：
     * 判断 A 和 B 的左子节点是否相等，即 recur(A.left, B.left) ；
     * 判断 A 和 B 的右子节点是否相等，即 recur(A.right, B.right) ；
     * isSubStructure(A, B) 函数：
     *
     * 特例处理： 当 树 A 为空 或 树 B 为空 时，直接返回 false ；
     *
     * 返回值： 若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
     * 以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
     * 树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
     * 树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；
     * */
    public static boolean isTreeATreeBEqual(TreeNode treeA, TreeNode treeB) {
        if (treeB == null) {
            return true;
        }

        if (treeA == null) {
            return false;
        }

        if (treeA.val != treeB.val) {
            return false;
        }

        return isTreeATreeBEqual(treeA.left, treeB.left) && isTreeATreeBEqual(treeA.right, treeB.right);
    }
}