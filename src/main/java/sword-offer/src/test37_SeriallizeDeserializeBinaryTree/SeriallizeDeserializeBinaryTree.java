package test37_SeriallizeDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yuan Jiajun
 * @date 2020/9/14 16:24
 * @description @link https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class SeriallizeDeserializeBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else res.append("null,");
        }

        res.deleteCharAt(res.length() - 1);
        res.append("]");

        return res.toString();
    }


    /*
    * 特例处理： 若 data 为空，直接返回 null ；
    初始化： 序列化列表 vals （先去掉首尾中括号，再用逗号隔开），指针 i = 1 ，
    根节点 root （值为 vals[0]），队列 queue（包含 root ）；
    按层构建： 当 queue 为空时跳出；
    节点出队，记为 node ；
    构建 node 的左子节点：node.left 的值为 vals[i]，并将 node.left入队；
    执行 i+=1；
    构建 node 的右子节点：node.left 的值为 vals[i] ，并将 node.left 入队；
    执行 i+=1 ；
    返回值： 返回根节点 root 即可。
*/
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

