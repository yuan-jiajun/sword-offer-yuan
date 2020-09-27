package upup.juc.mutithreadouput.threethreadsprintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 14:59
 * @description @link
 */
public class ConditionSynchronizedThreads {
    private static int index = 1;
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    public static class ThreadA extends Thread {
        @Override
        public void run() {

            while (true) {
                lock.lock();
                try {
//                    while (index % 3 != 1) {
//                        conditionA.await();
//                    }
                    System.out.println("A进程输出" + " : " + index++);
                    conditionB.signal();
                    conditionA.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
//                    while (index % 3 != 2) {
//                        conditionB.await();
//                    }
                    System.out.println("B进程输出" + " : " + index++);
                    conditionC.signal();
                    conditionB.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static class ThreadC extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
//                    while (index % 3 != 0) {
//                        conditionC.await();
//                    }
                    System.out.println("C进程输出" + " : " + index++);
                    conditionA.signal();
                    conditionC.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}

class ConditionSynchronizedThreadsTest {
    public static void main(String[] args) {
        ConditionSynchronizedThreads.ThreadA threadA = new ConditionSynchronizedThreads.ThreadA();
        ConditionSynchronizedThreads.ThreadB threadB = new ConditionSynchronizedThreads.ThreadB();
        ConditionSynchronizedThreads.ThreadC threadC = new ConditionSynchronizedThreads.ThreadC();
        threadA.start();//（1）
        threadB.start();//（2）
        threadC.start();//（3）
    }
}


