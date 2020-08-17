package yuan.test02_Singleton;

//懒汉式实现，第一次调用getInstance时才会创建对象，饿汉式：直接声明时创建
public class SingletonLazy {
}

class SingletonLazy1 {
    //私有化构造函数
    private SingletonLazy1() {
    }

    //唯一的对象 ，注意volatile保证变量可见性
    private volatile static SingletonLazy1 singletonLazy1 = null;

    /**
     * 获取对象，注意线程安全
     */
    public static SingletonLazy1 getInstance() {
        if (singletonLazy1 == null) {
            synchronized (SingletonLazy1.class) { // 修饰一个类，作用范围是synchronized后面括号括起来的部分。
                if (singletonLazy1 == null) { //里面也需要判断，因为JVM优化代码
                    singletonLazy1 = new SingletonLazy1();
                }
            }
        }

        return singletonLazy1;
    }
}


/**
 * 线程安全的懒汉式：静态内部类（推荐）
 */
class SingletonLazy2 {
    private static class Inner {
        private static SingletonLazy2 instance = new SingletonLazy2();
    }

    public static SingletonLazy2 getInstance() {
        return Inner.instance;
    }

    private SingletonLazy2() {
    }
}


/**
 * 线程安全的懒汉式：给方法加锁,效率不高
 */
class SingletonLazy3 {
    private static SingletonLazy3 ourInstance;

    public synchronized static SingletonLazy3 getInstance() {
        if (null == ourInstance) {
            ourInstance = new SingletonLazy3();
        }
        return ourInstance;
    }

    private SingletonLazy3() {
    }
}


/**
 * 懒汉式：非线程安全
 */
class SingletonLazy4 {
    private static SingletonLazy4 ourInstance;

    public static SingletonLazy4 getInstance() {
        if (null == ourInstance) {
            ourInstance = new SingletonLazy4();
        }
        return ourInstance;
    }

    private SingletonLazy4() {
    }
}
