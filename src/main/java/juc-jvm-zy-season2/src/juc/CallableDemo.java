package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        /**
         * FutureTask可用于异步获取执行结果或取消执行任务的场景。
         * 通过get()方法可以异步获取执行结果，不论FutureTask调用多少次run()或者call()方法，它都能确保只执行一次Runable或Callable任务。
         * 因此，FutureTask非常适合用于耗时高并发的计算，另外可以通过cancel()方法取消执行任务。*/
        new Thread(futureTask, "BB").start();
        new Thread(futureTask2, "CC").start();
        int result01 = 100;
        while (!futureTask.isDone()) {

        }
        int result02 = futureTask.get();//建议放在最后，要求获得Callable线程的计算结果，如果没有计算完成，会导致阻塞。知道完成
        System.out.println("result = " + (result01 + result02));
    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tcallable come in ...");
//        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
