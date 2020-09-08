package upup.juc.threadlocal;

/**
 * @author Yuan Jiajun
 * @date 2020/9/5 14:49
 * @description Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。
 * ThreadLocal的实现原理是，在每个线程中维护一个Map，键是ThreadLocal类型，值是Object类型。
 * 当想获取ThreadLocal的值时，就从当前线程中拿出Map，然后在把ThreadLocal本身作为键从Map中拿出值返回。
 * <p>
 * 优缺点
 * 优点：提供线程内的局部变量。每个线程都自己管理自己的局部变量，互不影响
 * 缺点：内存泄漏问题。可以看到ThreadLocalMap中的Entry是继承WeakReference的，
 * 其中ThreadLocal是以弱引用形式存在Entry中，如果ThreadLocal在外部没有被强引用，
 * 那么垃圾回收的时候就会被回收掉，又因为Entry中的value是强引用，就会出现内存泄漏。
 * 虽然ThreadLocal源码中的会对这种情况进行了处理，但还是建议不需要用TreadLocal的时候，手动调remove方法。
 * <p>
 * <p>
 * <p>
 * *****************************************
 * ThreadLocal用于保存某个线程共享变量：对于同一个static ThreadLocal，
 * 不同线程只能从中get，set，remove自己的变量，而不会影响其他线程的变量。
 * <p>
 * 1、ThreadLocal.get: 获取ThreadLocal中当前线程共享变量的值。
 * 2、ThreadLocal.set: 设置ThreadLocal中当前线程共享变量的值。
 * 3、ThreadLocal.remove: 移除ThreadLocal中当前线程共享变量的值。
 * 4、ThreadLocal.initialValue: ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值。
 * <p>
 * 线程共享变量缓存如下：
 * Thread.ThreadLocalMap<ThreadLocal, Object>;
 * <p>
 * 1、Thread: 当前线程，可以通过Thread.currentThread()获取。
 * 2、ThreadLocal：我们的static ThreadLocal变量。
 * 3、Object: 当前线程共享变量。
 * <p>
 * 我们调用ThreadLocal.get方法时，实际上是从当前线程中获取ThreadLocalMap<ThreadLocal, Object>，
 * 然后根据当前ThreadLocal获取当前线程共享变量Object。
 * ThreadLocal.set，ThreadLocal.remove实际上是同样的道理。
 * <p>
 * 这种存储结构的好处：
 * 1、线程死去的时候，线程共享变量ThreadLocalMap则销毁。
 * 2、ThreadLocalMap<ThreadLocal,Object>键值对数量为ThreadLocal的数量，
 * 一般来说ThreadLocal数量很少，相比在ThreadLocal中用Map<Thread, Object>键值对存储线程共享变量
 * （Thread数量一般来说比ThreadLocal数量多），性能提高很多。
 * <p>
 * 关于ThreadLocalMap<ThreadLocal, Object>弱引用问题：
 * 当线程没有结束，但是ThreadLocal已经被回收，则可能导致线程中存在ThreadLocalMap<null, Object>的键值对，造成内存泄露。（ThreadLocal被回收，ThreadLocal关联的线程共享变量还存在）。
 * 虽然ThreadLocal的get，set方法可以清除ThreadLocalMap中key为null的value，
 * 但是get，set方法在内存泄露后并不会必然调用，所以为了防止此类情况的出现，我们有两种手段。
 * 1、使用完线程共享变量后，显示调用ThreadLocalMap.remove方法清除线程共享变量；
 * 2、JDK建议ThreadLocal定义为private static，这样ThreadLocal的弱引用问题则不存在了。
 */

public class MyThreadLocal {
    private static final ThreadLocal<Object> MY_THREAD_LOCAL = new ThreadLocal<Object>() {
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args) {
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();

        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable {
        private String name;

        MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // ThreadLocal.get方法获取线程变量
                if (null == MyThreadLocal.MY_THREAD_LOCAL.get()) {
                    // ThreadLocal.et方法设置线程变量
                    MyThreadLocal.MY_THREAD_LOCAL.set(0);
                    System.out.println("线程" + name + ": 0");
                } else {
                    int num = (Integer) MyThreadLocal.MY_THREAD_LOCAL.get();
                    MyThreadLocal.MY_THREAD_LOCAL.set(num + 1);
                    System.out.println("线程" + name + ": " + MyThreadLocal.MY_THREAD_LOCAL.get());

                    if (i == 3) {
                        MyThreadLocal.MY_THREAD_LOCAL.remove();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static class MyStringTask implements Runnable {
        private String name;

        MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == MyThreadLocal.MY_THREAD_LOCAL.get()) {
                    MyThreadLocal.MY_THREAD_LOCAL.set("a");
                    System.out.println("线程" + name + ": a");
                } else {
                    String str = (String) MyThreadLocal.MY_THREAD_LOCAL.get();
                    MyThreadLocal.MY_THREAD_LOCAL.set(str + "a");
                    System.out.println("线程" + name + ": " + MyThreadLocal.MY_THREAD_LOCAL.get());
                }

                if (i == 3) {
                    MyThreadLocal.MY_THREAD_LOCAL.remove();
                }

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}