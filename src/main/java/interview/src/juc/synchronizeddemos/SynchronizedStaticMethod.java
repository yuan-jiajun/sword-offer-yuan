package juc.synchronizeddemos;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 10:17
 * @description @link
 */
public class SynchronizedStaticMethod {
    //TestBean中有一个静态方法，method
    synchronized public static void method(String threadName) {
        System.out.println("method start by " + threadName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method end by " + threadName);
    }
}

/**
 * 两个线程虽然使用的是两个不同的对象，但是访问的方法是静态的，
 * 两个线程最终还是发生了互斥（即一个线程访问，另一个线程只能等着），
 * 因为静态方法是依附于类而不是对象的，当synchronized修饰静态方法时，锁是 class 对象。
 */
class SynchronizedStaticMethodTest {
    public static void main(String[] args) {
//        SynchronizedStaticMethod synchronizedStaticMethod1 = new SynchronizedStaticMethod();
//        SynchronizedStaticMethod synchronizedStaticMethod2 = new SynchronizedStaticMethod();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SynchronizedStaticMethod.method("thread1");
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SynchronizedStaticMethod.method("thread2");
//            }
//        }).start();

        new Thread(() -> SynchronizedStaticMethod.method("thread1")).start();
        new Thread(() -> SynchronizedStaticMethod.method("thread2")).start();
    }
}
