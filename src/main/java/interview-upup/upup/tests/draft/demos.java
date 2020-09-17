package upup.tests.draft;

/**
 * @author Yuan Jiajun
 * @date 2020/9/2 20:50
 * @description
 */

public class demos extends Thread {
    static int x = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            x++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new demos().start();
        }
        sleep(2);
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
