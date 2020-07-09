package thread;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        syncTest(phone);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

    }

    private static void syncTest(Phone phone) {

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}

/*
 * 可重入锁（也就是递归锁）：指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 * 也就是说，线程可以进入任何一个它已经拥有的锁所有同步着的代码块。
 * */

class Phone implements Runnable {
    //Synchronized TEST  sync 和 Reentrant 都是可重入锁

    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t" + "sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t" + "sendEmail()");
    }


    //Reentrant TEST

    Lock lock = new ReentrantLock();
//    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        System.out.println("::");

        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t" + "get()");
            set();
        } finally {
            lock.unlock();
//            lock.unlock();
        }
        System.out.println(":");
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t" + "set()");
        } finally {
            lock.unlock();
        }
    }
}
