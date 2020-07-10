package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/10 14:22
 */
public class ThreadClassDemo extends Thread {

    private static int num = 0;

    public ThreadClassDemo() {
    }

    @Override
    public void run() {
        synchronized (ThreadClassDemo.class) {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + num++);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getNum() {
        return num;
    }


//    @Test
//    public static void test() {

    public static void main(String[] args) {
        ThreadClassDemo thread1 = new ThreadClassDemo();
        ThreadClassDemo thread2 = new ThreadClassDemo();

        thread1.start();
        thread2.start();

    }
}

