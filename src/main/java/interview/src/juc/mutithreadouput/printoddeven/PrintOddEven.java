package juc.mutithreadouput.printoddeven;

/**
 * @author Yuan Jiajun
 * @date 2020/8/31 18:50
 * @description
 */

public class PrintOddEven {
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


    //打印奇数
    static class PrintOdd implements Runnable {
        private final Counter counter;

        public PrintOdd(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                synchronized (counter) {
                    while (counter.getCount() <= 100) {
                        if (counter.getCount() % 2 == 0) {
                            counter.wait();
                        } else {
                            System.out.println("PrintOdd thread print..." + counter.getCount());
                            counter.setCount(counter.getCount() + 1);
                            counter.notify();
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //打印偶数
    static class PrintEven implements Runnable {
        private final Counter counter;

        public PrintEven(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                synchronized (counter) {
                    while (counter.getCount() <= 100) {
                        if (counter.getCount() % 2 == 1) {
                            counter.wait();
                        } else {
                            System.out.println("PrintEven thread print..." + counter.getCount());
                            counter.setCount(counter.getCount() + 1);
                            counter.notify();
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Counter counter = new Counter(1);
        PrintOdd printOdd = new PrintOdd(counter);
        PrintEven printEven = new PrintEven(counter);
        new Thread(printOdd).start();
        new Thread(printEven).start();
    }
}