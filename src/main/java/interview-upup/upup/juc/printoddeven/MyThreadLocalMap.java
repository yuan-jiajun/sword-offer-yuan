package upup.juc.printoddeven;

/**
 * @author Yuan Jiajun
 * @date 2020/9/5 16:47
 * @description
 * 一个ThreadLocal在一个线程中只能存储一个变量值;
 * ThreadLocal并不会存储数据,它做的只是做获取和存放这些过程.数据本身并没有存在ThreadLocal中.
 * 存放在当前线程中即Thread中的ThreadLocalMap中.
 */
public class MyThreadLocalMap {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("hello word");
        System.out.println(local.get());
    }

//    public <T> get() {
//        //这里通过获取当前的线程
//        Thread t = Thread.currentThread();
//        //通过线程来获取ThreadLocalMap ，还记得我们上面说的Thread 里面有一个ThreadLocalMap 属性吗？就是这里用上了
//        ThreadLocalMap map = getMap(t);
//        if (map != null) {
//            ThreadLocalMap.Entry e = map.getEntry(this);
//            if (e != null) {
//                @SuppressWarnings("unchecked")
//                T result = (T)e.value;
//                return result;
//            }
//        }
//        return setInitialValue();
//    }
//
//
//    ThreadLocalMap getMap(Thread t) {
//        return t.threadLocals;
//    }

}