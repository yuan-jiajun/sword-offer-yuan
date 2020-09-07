package upup.juc.synchronizeddemos;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 21:54
 * @description @see https://blog.csdn.net/lengxiao1993/article/details/52296220
 * <p>
 * synchronized 的含义：
 * 1. Java中每一个对象都可以成为一个监视器(Monitor), 该 Monitor由一个锁(lock),一个等待队列(阻塞队列)(waiting queue),一个入口队列 (同步队列)(entry queue).
 * 2. 对于一个对象的方法， 如果没有synchronized关键字， 该方法可以被任意数量的线程，在任意时刻调用。
 * 3. 对于添加了synchronized关键字的方法，任意时刻只能被唯一的一个获得了对象实例锁的线程调用。
 * 4. synchronized用于实现多线程的同步操作
 * <p>
 * 因 wait()而导致阻塞的线程是放在阻塞队列中的，因竞争失败导致的阻塞是放在同步队列中的，
 * notify()/notifyAll()实质上是把阻塞队列中的线程放到同步队列中去
 *
 * <p>
 * wait()功用:释放当前对象锁，并进入阻塞队列（等待队列）
 * 1. wait(), notify(), notifyAll() 和 synchonized 需要搭配使用, 用于线程同步
 * 2. wait()总是在一个循环中被调用，挂起当前线程来等待一个条件的成立。 wait调用会一直等到其他线程调用notifyAll()时才返回。
 * 3. 当一个线程在执行synchronized 的方法内部，调用了wait()后，该线程会释放该对象的锁，
 * 然后该线程会被添加到该对象的等待队列中(waiting queue), 只要该线程在等待队列中， 就会一直处于闲置状态， 不会被调度执行。
 * 要注意wait()方法会强迫线程先进行释放锁操作，所以在调用wait()时， 该线程必须已经获得锁，否则会抛出异常。
 * 由于wait()在synchonized的方法内部被执行， 锁一定已经获得，就不会抛出异常了。
 * <p>
 * notify()的功用:唤醒当前对象阻塞队列里的任一线程（并不保证唤醒哪一个）
 * 1. wait(), notify(), notifyAll() 和 synchonized 需要搭配使用， 用于线程同步
 * 2. 当一个线程调用一个对象的notify()方法时， 调度器会从所有处于该对象等待队列(waiting queue)的线程中取出任意一个线程， 将其添加到入口队列( entry queue) 中. 然后在入口队列中的多个线程就会竞争对象的锁， 得到锁的线程就可以继续执行。 如果等待队列中（waiting queue）没有线程， notify()方法不会产生任何作用
 * 3. notifyAll() 和notify()工作机制一样， 区别在于notifyAll()会将等待队列(waiting queue)中所有的线程都添加到入口队列中（entry queue）
 * 4. 注意, notifyAll()比notify()更加常用， 因为notify()方法只会唤起一个线程，且无法指定唤醒哪一个线程，所以只有在多个执行相同任务的线程在并发运行时，我们不关心哪一个线程被唤醒时，才会使用notify()
 */
public class SynchronizedPractice implements Runnable {
    private static int count;
    private static final String lock = "lock";

    public SynchronizedPractice() {
        count = 0;
    }

    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " enter");

//            try {
//                lock.wait(5 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SynchronizedPractice(), "SyncThread1");
        Thread thread2 = new Thread(new SynchronizedPractice(), "SyncThread2");
        thread1.start();
        thread2.start();
    }


}