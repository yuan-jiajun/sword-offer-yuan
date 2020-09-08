package upup.juc.synchronizeddemos;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 10:24
 * @description @see
 */
public class SynchronizedCodeBlocks {
}

class TestBean {
    private final static Object objectLock = new Object();

    void method1() {
        System.out.println("not synchronized method1");
//        synchronized (this) {
//        synchronized (objectLock) {
        synchronized (TestBean.class) {
            System.out.println("synchronized method1 start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronized method1 end  ");
        }

    }

    void method2() {
        System.out.println("not synchronized method2");
//        synchronized (this) {
//        synchronized (objectLock) {
        synchronized (TestBean.class) {
            System.out.println("synchronized method2 start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("synchronized method2 end");
        }
    }
}


class SynchronizedCodeBlocksTest {

    public static void main(String[] args) {
        TestBean testBean1 = new TestBean();
        TestBean testBean2 = new TestBean();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testBean2.method2();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testBean1.method2();
//            }
//        }).start();


    }
}


