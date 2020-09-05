package juc;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
//    public static void main(String[] args) throws InterruptedException {
//        leaveClassroom();
//        county();
//    }

    @Test
    public void leaveClassroom() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ******班长最后关门走人");
    }

    @Test
    public void county() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国被灭");
                countDownLatch.countDown();
            }, Objects.requireNonNull(CountryEnum.get(i)).getRetMsg()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ******秦国一统华夏");
    }


}
