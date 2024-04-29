package juc.join;

/**
 * @author Yuan Jiajun
 * @date 2020/9/19 21:18
 * @description @link
 */
public class JoinTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Thread thread = new Thread(new JoinDemo());
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i >= 2) {
                try {
                    //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续；
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class JoinDemo implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 0; i < 10; i++) {
            System.out.println("Join线程 第" + i + "次执行");
        }

    }
}