package juc;

import org.testng.annotations.Test;

import java.util.concurrent.*;

/*
 *第4种获得/使用java多线程的方式，通过线程池
 * （其他三种是：继承Thread类；实现Runnable接口，但是Runnable没有返回值，不抛异常；
 * 实现Callable接口，有返回值，会跑出异常）
 * */

//Array Arrays  辅助工具类
//Collection Collections
//Executor Executors

/**
 * 体系：`Executor`→`ExecutorService`→`AbstractExecutorService`→`ThreadPoolExecutor`
 * <p>
 * `ThreadPoolExecutor`是线程池创建的核心类。类似`Arrays`、`Collections`工具类，`Executor`也有自己的工具类`Executors`。
 */


/**
 * 第四种使用Java多线程的方式，线程池
 */

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        customThreadPool();
//        cachedThreadPool();
//        singleThreadPool();
//        fixedThreadPool();

    }

    @Test
    private static void customThreadPool() {
        System.out.println("Custom Thread Pool");
        ExecutorService threadPool =
                new ThreadPoolExecutor(2,
                        5,
                        3L,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(3),
                        Executors.defaultThreadFactory(),
//                        new ThreadPoolExecutor.AbortPolicy()
//                        new ThreadPoolExecutor.CallerRunsPolicy()
//                        new ThreadPoolExecutor.DiscardOldestPolicy()
                        new ThreadPoolExecutor.DiscardPolicy()
                );

        try {
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务" + finalI);
//                    System.out.println(Thread.currentThread().getName() + "\t办理业务");

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    @Test
    private static void cachedThreadPool() {
        //不定量线程
        System.out.println("Cached Thread Pool");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");

                    //线程内暂停2秒
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });

                //线程间暂停2秒
//                TimeUnit.SECONDS.sleep(2);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    @Test
    private static void singleThreadPool() {
        //一池1个线程
        System.out.println("Single Thread Pool");
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                    //线程内暂停2秒
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    @Test
    private static void fixedThreadPool() {
        //一池5个线程
        System.out.println("Fixed Thread Pool");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一般常用try-catch-finally
        //模拟10个用户来办理业务，每个用户就是一个线程

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
//                    threadPool.shutdownNow();
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
