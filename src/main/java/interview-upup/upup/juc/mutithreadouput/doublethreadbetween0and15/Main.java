package upup.juc.mutithreadouput.doublethreadbetween0and15;

/**
 * @author Yuan Jiajun
 * @date 2020/9/27 13:28
 * @description @link
 */
public class Main {
// 用java写一个多线程程序,如四个线程，其中两个对一个变量加1，另两个对一个变量减1

    public static void main(String[] args) {
        T t = new T();
        Thread add = new Thread(t, "add");
        Thread minus = new Thread(t, "minus");

        add.start();
        minus.start();
    }
}

class T implements Runnable {
    private int num;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {

                if ("add".equals(Thread.currentThread().getName()) && num < 15) {
                    num += 1;
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                } else if ("minus".equals(Thread.currentThread().getName()) && num > 0) {
                    num -= 1;
                    System.out.println(Thread.currentThread().getName() + " :: " + num);
                }

            }
        }
    }

}
