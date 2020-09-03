package upup.juc.printoddeven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuan Jiajun
 * @date 2020/8/31 18:55
 * @description
 */

public class PrintOddEven2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Counter counter = new Counter(1);
        new Thread(new PrintOdd(lock, condition, counter)).start();
        new Thread(new PrintEven(lock, condition, counter)).start();
    }

    static class Counter {
        private Integer count;

        public Counter(Integer count) {
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }


    static class PrintOdd implements Runnable {
        private volatile Counter counter;
        private ReentrantLock lock;
        private Condition condition;

        public PrintOdd(ReentrantLock lock, Condition condition, Counter counter) {
            this.lock = lock;
            this.condition = condition;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.getCount() <= 100) {
                lock.lock();
                try {
                    if (counter.getCount() % 2 == 0) {
                        condition.await();
                    } else {
                        System.out.println("PrintOdd thread print..." + counter.getCount());
                        counter.setCount(counter.getCount() + 1);
                        condition.signal();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintEven implements Runnable {
        private volatile Counter counter;
        private ReentrantLock lock;
        private Condition condition;

        public PrintEven(ReentrantLock lock, Condition condition, Counter counter) {
            this.lock = lock;
            this.condition = condition;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.getCount() <= 100) {
                lock.lock();
                try {
                    if (counter.getCount() % 2 == 1) {
                        condition.await();
                    } else {
                        System.out.println("PrintEven thread print..." + counter.getCount());
                        counter.setCount(counter.getCount() + 1);
                        condition.signal();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}