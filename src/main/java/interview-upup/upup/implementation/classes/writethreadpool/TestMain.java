package upup.implementation.classes.writethreadpool;

/**
 * @author Yuan Jiajun
 * @date 2020/9/17 10:30
 * @description @link
 */


public class TestMain {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(-5);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        // 调用销毁方法，不执行剩下的任务
        threadPool.destory(false);
    }
}