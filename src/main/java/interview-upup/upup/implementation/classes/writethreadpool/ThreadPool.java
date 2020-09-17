package upup.implementation.classes.writethreadpool;

/**
 * @author Yuan Jiajun
 * @date 2020/9/17 10:27
 * @description @link
 */

import java.util.LinkedList;
import java.util.List;


public class ThreadPool implements Executer {

    // 设置默认开启线程个数 5 个
    private int corePoolSize = 5;

    //线程工作组
    WorkerThread[] workThreads;

    //任务队列 用个 list 后面添加方法用同步锁定就行
    private final List<Runnable> taskQueue = new LinkedList<>();

    public ThreadPool(int corePoolSize) {
        // 小于零 说明输入错误，就不赋值，使用默认值。
        if (corePoolSize > 0) {
            this.corePoolSize = corePoolSize;
        }

        // 开启工作空间, 注意：要用成员变量
        workThreads = new WorkerThread[this.corePoolSize];

        // 循环创建所有线程, 注意：要用成员变量
        for (int i = 0; i < this.corePoolSize; i++) {
            // 创建的线程添加到 工作组 中
            workThreads[i] = new WorkerThread();

            // 创建的线程开启, 并且命名 (创建了多个线程池名称可能会冲突，后面再看了)
            new Thread(workThreads[i], "ThreadPool-worker " + (i + 1)).start();

            System.out.println("初始化线程数" + (i + 1));
        }
    }

    /**
     * 添加任务方法，即把对象添加到 队列中, 同时唤醒所有 wait中的线程
     */
    @Override
    public void execute(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notifyAll();
        }
    }

    /**
     * 销毁线程池，默认是等待线程执行完了再销毁
     */
    public void destory() {
        destory(true);
    }

    /**
     * 销毁线程池，可以指定不执行队列中剩下的任务，直接销毁线程池了。
     * true表示继续执行剩下的任务。
     */
    public void destory(boolean isRunTask) {
        // 默认是等待线程执行完了再销毁
        if (isRunTask) {
            //循环是否还存在任务，如果存在等待20毫秒处理时间
            while (!taskQueue.isEmpty()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //如果任务队列已处理完成，销毁线程，清空任务
        for (int i = 0; i < corePoolSize; i++) {
            workThreads[i].setFalseRunning();
            workThreads[i] = null;
            System.out.println("线程池销毁了");
        }

        taskQueue.clear();

        // 不能设置 taskQueue == null 其他正在调用的地方可能报 null指针异常。
        //taskQueue = null;
    }

    /**
     * 内部类：做线程工作类
     */
    class WorkerThread implements Runnable {

        // 当前线程是否可用
        private Boolean isRunning = true;

        @Override
        public void run() {
            Runnable runnable = null;

            // 死循环，除非外界调用销毁方法，设定 isRunning 为false
            while (isRunning) {
                // 上面用的list 非线程安全，所以这里要同步去任务
                synchronized (taskQueue) {
                    // 如果线程活的，但是 taskQueue 是空，线程等待 20 毫秒
                    while (isRunning && taskQueue.isEmpty()) {
                        try {
                            // wait会释放锁，其他工作线程可以继续执行同步代码块里面内容。
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // 获取任务，注意：要在同步代码块里面获取任务。
                    // 为什么还要判断 taskQueue 非空?
                    // 等待20毫秒，有任务能获取到。
                    if (!taskQueue.isEmpty()) {
                        // list模拟队列，所以获取第一个元素。
                        runnable = taskQueue.remove(0);
                    }
                }


                // 注意：执行任务要在同步代码块外面，把锁释放出来给其他线程。
                // 判断 runnable ，因为可能没有获取到任务。
                if (runnable != null) {
                    // 执行 run 方法，要任务实现Runnable接口，实际上是为了保证有 run 方法，和线程没关系。
                    runnable.run();
                }

                // 结束后置 null 方便回收。
                runnable = null;

            }
        }

        /**
         * 销毁线程，实际上就是不再死循环，正常结束了工作线程。
         */
        public void setFalseRunning() {
            this.isRunning = false;
        }

    }

}