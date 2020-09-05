package chapter05.java3;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * 面试题：
 * 方法中定义的局部变量是否线程安全？具体情况具体分析
 * <p>
 * 何为线程安全？
 * 如果只有一个线程才可以操作此数据，则必是线程安全的。
 * 如果有多个线程操作此数据，则此数据是共享数据。如果不考虑同步机制的话，会存在线程安全问题。
 *
 * @create 2020 下午 7:48
 */
public class StringBuilderTest {

    int num = 10;

    //StringBuilder:线程不安全

    @Test
    //s1的声明方式是线程安全的
    public static void method1() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        //...
    }

    @Test
    //s1的操作：是线程安全的
    public static String method4() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");
        return s1.toString();
    }

    /**
     * 逃逸
     */

    @Test
    //sBuilder的操作过程：是线程不安全的
    public static void method2(StringBuilder sBuilder) {
        sBuilder.append("a");
        sBuilder.append("b");
        //...
    }

    @Test
    //s1的操作：是线程不安全的
    public static StringBuilder method3() {
        StringBuilder s1 = new StringBuilder();
        s1.append("a");
        s1.append("b");

        /**其他地方调用导致不安全*/
        return s1;
    }


    public static void main(String[] args) throws InterruptedException {
        StringBuilder s = new StringBuilder();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                s.append("a\n");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                s.append("b\n");
            }
        }).start();

//        method2(s);
        TimeUnit.SECONDS.sleep(1);

        System.out.println(s.toString());
    }

}
