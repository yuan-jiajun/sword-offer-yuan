package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * `Demos.CountDownLatch`的问题是不能复用。比如`count=3`，那么加到3，就不能继续操作了。
 * 而`Semaphore`可以解决这个问题，比如6辆车3个停车位，对于`Demos.CountDownLatch`**只能停3辆车**，
 * 而`Semaphore`可以停6辆车，车位空出来后，其它车可以占有，
 * 这就涉及到了`Semaphore.accquire()`和`Semaphore.release()`方法。*/

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
//                    countDownLatch.countDown();
                }
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t所有车停车后离开");

    }
}
