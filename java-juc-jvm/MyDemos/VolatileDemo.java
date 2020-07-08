package MyDemos;

import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    int number = 0;

}

/*
1 验证volatile的可见性
    1.1 假如int number=0，number变量之前根本没有添加volatile关键字修饰,没有可见性
    1.2 添加了volatile，可以解决可见性问题
2 验证volatile不保证原子性

    2.1 原子性是不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者分割。
    需要整体完成，要么同时成功，要么同时失败。

    2.2 volatile不可以保证原子性演示

    2.3 如何解决原子性
        *加sync
        *使用我们的JUC下AtomicInteger

* */
public class VolatileDemo {
    public static void main(String[] args) {
        //实现Runnal接口的lambda表达式
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "AAA").start();

    }
}
