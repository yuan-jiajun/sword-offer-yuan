import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 *
 * */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);  //模拟3个车位
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {  //模拟6部车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");

                    TimeUnit.SECONDS.sleep(3);

                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t所有车停车后离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
