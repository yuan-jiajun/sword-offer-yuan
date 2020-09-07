package yuan.test32_2_ZPrintTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 16:14
 * @description @see https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class ZPrintTree {

    /**
     * 剑指offer 用的两个栈来存奇数偶数行的数据
     * leetcode 用的 一个 队列， 和一个实现 addLast & addFirst 两种插入方式的链表实现的
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0)
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                else
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            res.add(tmp);
        }

        return res;
    }


}