package juc;

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "ThreadA").start();
//        new Thread(new HoldLockThread(lockB, lockA), "ThreadB").start();
    }
}

class HoldLockThread implements Runnable {
    private final String lockA;
    private final String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获取：" + lockB);
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获取：" + lockB + " 成功");
            }

        }
    }
}
