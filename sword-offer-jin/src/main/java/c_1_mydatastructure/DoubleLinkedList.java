package c_1_mydatastructure;

/**
 * @program: swordofferjava
 * @description: 自己实现的双向链表
 * @author: Jin Hongjian
 * @create: 2020-07-07
 **/
public class DoubleLinkedList {
    /*双向链表*/

    private Node head;
    private Node last;
    private int length;

    public DoubleLinkedList() {
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    /**
     * 往链表头部添加
     *
     * @param node
     */
    public boolean addHead(Node node) {
        if (node == null) {
            return false;
        }
        if (isEmpty()) { //链表为空
            head = node;
            last = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        length++;
        return true;
    }

    /**
     * 往链表尾部添加
     *
     * @param node
     */
    public boolean addTail(Node node) {
        if (node == null) {
            return false;
        }

        if (isEmpty()) { //链表为空
            head = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        length++;
        return true;
    }

    /**
     * 往链表尾部添加
     *
     * @param node
     */
    public boolean addAfterNode(Node node, Node newNode) {
        if (node == null || isEmpty()) {
            return false;
        }

        Node cNode = head;
        while (cNode != null) {
            if (cNode == node) {
                Node next = cNode.next;
                //链接前一个节点
                newNode.prev = cNode;
                cNode.next = newNode;
                //链接后一个节点
                newNode.next = next;
                if (next != null) {
                    next.prev = newNode;
                }
                length++;
                return true;
            }
            cNode = cNode.next;
        }
        return false;
    }


    /**
     * 从链表尾部获取
     */
    public Node removeTail() {
        if (isEmpty()) {
            return null;
        }
        Node node = last;
        if (length == 1) {
            head = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        length--;
        return node;
    }

    /**
     * 从链表头部获取
     */
    public Node removeHead() {
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        if (length == 1) {
            head = null;
            last = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        length--;
        return node;
    }


}

/*节点类*/
class Node<T> {
    Node<T> prev;
    Node<T> next;
    T data;

    Node(T data) {
        this.data = data;
    }
}
