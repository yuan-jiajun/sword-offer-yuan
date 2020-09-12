package upup.demos;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:50
 * @description
 */

public class demos2 extends Thread {
//    volatile static int x = 0;
    volatile static AtomicInteger x = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            x.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new demos2().start();
//            sleep(1000);
        }
                    sleep(1000);

        System.out.println(x);
    }


//    public static void main(String[] args) throws InterruptedException {
//
//        demos ds = null;
//        for (int i = 0; i < 5; i++) {
//            ds = new demos();
//            ds.start();
//        }
//        sleep(2000);
//        System.out.println(ds.x);
//    }

}
