package jdktheory.threadlocal;

/**
 * @author Yuan Jiajun
 * @date 2020/9/20 20:40
 * @description @link
 */
public class TestThreadLocal {

    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {//启动三个线程
            Thread t = new Thread(TestThreadLocal::add10ByThreadLocal, "Thread-" + i);
            t.start();
        }
    }

    /**
     * 线程本地存储变量加 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 1; i <= 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
    }

}
