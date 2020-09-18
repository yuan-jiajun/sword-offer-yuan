package yuan.test02_Singleton;

/**
 * @author yuanjiajun
 * @description
 * @date 2020/8/18 1:46
 */
public class SingletonHungry {
}

/**
 * 1.饿汉式：线程安全，耗费资源
 */
class SingletonHungry1 {
    //该对象的引用不可修改
    private static SingletonHungry1 ourInstance = new SingletonHungry1();

    private SingletonHungry1() {
    }

    public static SingletonHungry1 getInstance() {
        return ourInstance;
    }
}

/**
 * 2.饿汉式：在静态代码块实例对象
 */
class SingletonHungry2 {
    private static SingletonHungry2 ourInstance;

    private SingletonHungry2() {
    }

    static {
        ourInstance = new SingletonHungry2();
    }

    public static SingletonHungry2 getInstance() {
        return ourInstance;
    }


}