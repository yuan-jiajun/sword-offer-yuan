package juc.synchronizeddemos;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 9:57
 * @description @link
 */

public class SynchronizedInstanceMethod {
    //TestBean中有两个实例方法，method1和method2
    public synchronized void method1() {
        System.out.println("method1 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1 end");
    }

    //    public void method2() {
    //    public  static void method2() {
    synchronized public static void method2() {
        System.out.println("method2 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2 end");
    }

    public void method3() {
        synchronized (SynchronizedInstanceMethod.class) {
            System.out.println(Thread.currentThread().getName() + " enter");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SynchronizedMethodTest1 {
    /**
     * 如果method2()的synchronized修饰符去掉,不用等锁释放，就会立刻执行method2()。
     */
    public static void main(String[] args) {
        SynchronizedInstanceMethod testBean = new SynchronizedInstanceMethod();
//        第一个线程，执行synchronized method1(), 第二个线程，执行synchronized method2()
//        必须等到拥有锁的线程释放锁后其他线程才能执行
        new Thread(testBean::method1).start();
//        new Thread(testBean::method1).start();
        new Thread(SynchronizedInstanceMethod::method2).start();

//        先后进入
//        new Thread(testBean::method3).start();
//        new Thread(testBean::method3).start();
    }
}

/**
 * 可以看出synchronized修饰普通方法，锁作用于类的对象上，其他线程来访问synchronized修饰的其他方法时需要已经拥有锁的线程先把锁释放。
 */
class SynchronizedMethodTest2 {
    /**
     * TestBean.java类保持不变，两个方法均由synchronized修饰，但有两个不同的实例对象。
     */
    public static void main(String[] args) {
        SynchronizedInstanceMethod testBean1 = new SynchronizedInstanceMethod();
        SynchronizedInstanceMethod testBean2 = new SynchronizedInstanceMethod();

        //第一个线程，执行method1()
        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean1.method1();
            }
        }).start();
        //第二个线程，执行method2()
        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean2.method2();
            }
        }).start();
    }
}


