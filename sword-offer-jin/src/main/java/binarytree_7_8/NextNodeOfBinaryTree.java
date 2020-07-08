package binarytree_7_8;

public class NextNodeOfBinaryTree {
    /**
     * 二叉树节点中序遍历序列的下一个节点
     * 思路分四步走：
     * 1：如果节点存在右子节点，则下一节点为其右子树中的最左节点
     * 2：如果节点不存在右子节点，且不存在父亲节点，则下一节点为空
     * 3：如果节点不存在右子节点，存在父亲节点，如果节点为其父亲节点的左子节点，则下一节点为其父亲节点
     * 4：如果节点不存在右子节点，存在父亲节点，如果节点为其父亲节点的右子节点，则下一节点为，从节点的父亲节点往上查找，直到知道某一节点
     * 为其父亲节点X 的左子节点，则下一节点为X，如果找不到，则下一节点为空
     *
     * @param node
     * @return
     */
    public static BinaryTreeNodeWithParentPointer nextNode(BinaryTreeNodeWithParentPointer node) {
        if (node == null)
            throw new RuntimeException("invalid input");
        //第一种情况
        if (node.pRight != null) {
            BinaryTreeNodeWithParentPointer tempNode = node.pRight;
            while (tempNode.pLeft!=null){
                tempNode = tempNode.pLeft;
            }
            return tempNode;
        } else { //不存在右子节点
            //第二种情况
            if (node.pParent == null) {
                return null;
            } else if (node == node.pParent.pLeft) {//第三种情况
                return node.pParent;
            } else { //第四种情况，存在父亲节点且为父亲节点的右子节点
                BinaryTreeNodeWithParentPointer parent = node.pParent;
                BinaryTreeNodeWithParentPointer son;
                while (parent.pParent != null) {
                    son = parent;
                    parent = parent.pParent;
                    if (son == parent.pLeft) {
                        return parent;
                    }
                }
                return null; //没找到就是null
            }
        }

    }

    public static void main(String[] args) {
        BinaryTreeNodeWithParentPointer a = new BinaryTreeNodeWithParentPointer('a');
        BinaryTreeNodeWithParentPointer b = new BinaryTreeNodeWithParentPointer('b');
        BinaryTreeNodeWithParentPointer c = new BinaryTreeNodeWithParentPointer('c');
        BinaryTreeNodeWithParentPointer d = new BinaryTreeNodeWithParentPointer('d');
        BinaryTreeNodeWithParentPointer e = new BinaryTreeNodeWithParentPointer('e');
        BinaryTreeNodeWithParentPointer f = new BinaryTreeNodeWithParentPointer('f');
        BinaryTreeNodeWithParentPointer g = new BinaryTreeNodeWithParentPointer('g');
        BinaryTreeNodeWithParentPointer h = new BinaryTreeNodeWithParentPointer('h');
        BinaryTreeNodeWithParentPointer i = new BinaryTreeNodeWithParentPointer('i');

        a.pLeft = b;
        a.pRight = c;
        b.pLeft = d;
        b.pRight = e;
        c.pLeft = f;
        c.pRight = g;
        e.pLeft = h;
        e.pRight = i;

        b.pParent = a;
        c.pParent = a;
        d.pParent = b;
        e.pParent = b;
        f.pParent = c;
        g.pParent = c;
        h.pParent = e;
        i.pParent = e;

        BinaryTreeNodeWithParentPointer root = a;

        System.out.print("a: ");
        System.out.println(nextNode(a) == null ? "null" : (char) nextNode(a).value);
        System.out.print("b: ");
        System.out.println(nextNode(b) == null ? "null" : (char)  nextNode(b).value);
        System.out.print("c: ");
        System.out.println(nextNode(c) == null ? "null" : (char)  nextNode(c).value);
        System.out.print("d: ");
        System.out.println(nextNode(d) == null ? "null" : (char)  nextNode(d).value);
        System.out.print("e: ");
        System.out.println(nextNode(e) == null ? "null" : (char)  nextNode(e).value);
        System.out.print("f: ");
        System.out.println(nextNode(f) == null ? "null" : (char)  nextNode(f).value);
        System.out.print("g: ");
        System.out.println(nextNode(g) == null ? "null" : (char)  nextNode(g).value);
        System.out.print("h: ");
        System.out.println(nextNode(h) == null ? "null" : (char)  nextNode(h).value);
        System.out.print("i: ");
        System.out.println(nextNode(i) == null ? "null" : (char)  nextNode(i).value);
    }
}





