package jdktheory.compareinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/9/20 17:48
 * @description @link
 */
public class CollectionsSort {
    @Test
    public void test1() {
        List<String> listString = new ArrayList<>();

        listString.add("5");
        listString.add("2");
        listString.add("9");
        //lists中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
        Collections.sort(listString);
        System.out.println(listString);

    }

    @Test
    public void test2() {
        List<A> listA = new ArrayList<>();
        A aa = new A();
        aa.setName("aa");
        aa.setOrder(1);
        A bb = new A();

        bb.setName("bb");
        bb.setOrder(2);
        listA.add(bb);
        listA.add(aa);
        //list中的对象A实现Comparable接口
        Collections.sort(listA);
        System.out.println(listA);
    }


    @Test
    public void test3() {
        List<B> listB = new ArrayList<>();
        B ab = new B();
        ab.setName("ab");
        ab.setOrder("1");
        B ba = new B();
        ba.setName("ba");
        ba.setOrder("2");
        listB.add(ba);
        listB.add(ab);

        //根据Collections.sort重载方法来实现
        Collections.sort(listB, new Comparator<B>() {
            @Override
            public int compare(B b1, B b2) {
                return b1.getOrder().compareTo(b2.getOrder());
            }
        });

        //根据Collections.sort重载方法来实现
        Collections.sort(listB, (b1, b2) -> b1.getOrder().compareTo(b2.getOrder()));

        //根据Collections.sort重载方法来实现
        Collections.sort(listB, Comparator.comparing(B::getOrder));

        System.out.println(listB);
    }

}

class A implements Comparable<A> {
    private String name;
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "name is " + name + " order is " + order;
    }

    @Override
    public int compareTo(A a) {
        return this.order.compareTo(a.getOrder());
    }

}

class B {
    private String name;
    private String order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "name is " + name + " order is " + order;
    }
}