package upup.juc.mutithreadouput.doublethreadbetween0and15.solution2_lock;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yuan Jiajun
 * @date 2020/8/31 18:55
 * @description
 */

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Counter counter = new Counter(0);
        new Thread(new Add(lock, condition, counter)).start();
        new Thread(new Minus(lock, condition, counter)).start();
    }


}

class Counter {
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


class Add implements Runnable {
    private volatile Counter counter;
    private final ReentrantLock lock;
    private final Condition condition;

    public Add(ReentrantLock lock, Condition condition, Counter counter) {
        this.lock = lock;
        this.condition = condition;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
//                Random rd = new Random(); // creating Random object
//                System.out.println(rd.nextBoolean() + "add");
//                if (rd.nextBoolean() || counter.getCount() == 15) {
                if (counter.getCount() == 15) {
                    condition.await();
                } else {
                    counter.setCount(counter.getCount() + 1);
                    System.out.println("Add thread print..." + counter.getCount());
                    condition.signalAll();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

//偶数
class Minus implements Runnable {
    private volatile Counter counter;
    private final ReentrantLock lock;
    private final Condition condition;

    public Minus(ReentrantLock lock, Condition condition, Counter counter) {
        this.lock = lock;
        this.condition = condition;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
//                Random rd = new Random(); // creating Random object
//                if ((rd.nextBoolean() || counter.getCount() == 0)) {
                if (counter.getCount() == 0) {
                    condition.await();
                } else {
                    counter.setCount(counter.getCount() - 1);
                    System.out.println("Minus thread print..." + counter.getCount());
                    condition.signalAll();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}