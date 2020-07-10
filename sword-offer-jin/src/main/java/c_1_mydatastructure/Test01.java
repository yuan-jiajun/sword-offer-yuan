package c_1_mydatastructure;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @program: swordofferjava
 * @description: 测试
 * @author: Jin Hongjian
 * @create: 2020-07-07
 **/
public class Test01 {

    @Test
    void test01() {
        HashSet<Object> objects = new HashSet<>();


        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        Node<String> node1 = new Node<>("111");
        Node<String> node2 = new Node<>("222");
        Node<String> node3 = new Node<>("333");
        Node<String> node4 = new Node<>("444");
        Node<String> node5 = new Node<>("555");
        Node<String> node6 = new Node<>("666");
        Node<String> node = new Node<>("aaaaaaa");


        doubleLinkedList.addTail(node1);
        doubleLinkedList.addTail(node2);
        doubleLinkedList.addTail(node3);
        doubleLinkedList.addTail(node4);
        doubleLinkedList.addTail(node5);
        doubleLinkedList.addTail(node6);

        doubleLinkedList.addAfterNode(node4,node);

        while (!doubleLinkedList.isEmpty()){
            System.out.println(doubleLinkedList.removeHead().data);
        }


    }


}
