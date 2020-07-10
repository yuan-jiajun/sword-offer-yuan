package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
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
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
