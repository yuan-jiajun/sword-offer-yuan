package jdktheory.threadexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 10:40
 * @description @link
 * 正常情况下，如果不做特殊的处理，在主线程中是不能够捕获到子线程中的异常的。
 */
public class ThreadExceptionDemo {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new ThreadExceptionRunner());
            thread.start();
        } catch (Exception e) {
            System.out.println("========");
            e.printStackTrace();
        } finally {
        }
        System.out.println(123);


//        ExecutorService exec = Executors.newCachedThreadPool(new HandleThreadFactory());

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new ThreadExceptionRunner());

        exec.shutdown();

    }
}

class ThreadExceptionRunner implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("ThreadExceptionRunner error !!!!");
    }
}


class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught: " + e);
    }
}

class HandleThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("create thread t");
        Thread t = new Thread(r);
        System.out.println("set uncaughtException for t");
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        return t;
    }
}