package upup.juc.synchronizedqueue.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 15:30
 * @description @link
 */

 public class ThreeThreadsLoopPrintABC {
    private char chars = 'A';
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void PrintA() {
        lock.lock();
        try {
            while (chars != 'A') {
                //等待
                condition1.await();
            }
            System.out.print(chars);
            chars = 'B';
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintB() {
        lock.lock();
        try {
            while (chars != 'B') {
                condition2.await();
            }
            System.out.print(chars);
            chars = 'C';
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintC() {
        lock.lock();
        try {
            while (chars != 'C') {
                condition3.await();
            }
            System.out.print(chars);
            chars = 'A';
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ThreeThreadsLoopPrintABCTest {
    public static void main(String[] args) {
        ThreeThreadsLoopPrintABC threeThreadsLoopPrintABC = new ThreeThreadsLoopPrintABC();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                threeThreadsLoopPrintABC.PrintA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                threeThreadsLoopPrintABC.PrintB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                threeThreadsLoopPrintABC.PrintC();
            }
        }).start();
    }
}
