package juc.mutithreadouput.doublethreadbetween0and15.solution1_synchronized;

/**
 * @author Yuan Jiajun
 * @date 2020/9/27 12:56
 * @description @link
 */

/**
 * 加一线程与减一线程共同操作一个数 两个问题： 1、线程同步--synchronized 2、线程之间如何共享同一个j变量--内部类
 *
 * @author liuwei
 */
public class Main {
    int j = 0;

    public synchronized void inc() {
        if (j == 15) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc-->" + j);
        notifyAll();
    }

    public synchronized void dec() {
        if (j == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec-->" + j);
        notifyAll();
    }

    class T1 implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                inc();
            }
        }
    }

    class T2 implements Runnable {
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dec();
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        T1 t1 = t.new T1();
        T2 t2 = t.new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();

    }
}