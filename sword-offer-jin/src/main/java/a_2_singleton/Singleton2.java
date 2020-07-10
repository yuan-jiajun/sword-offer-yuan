package a_2_singleton;

/**
 * 基于静态内部类实现单例模式，懒汉模式
 */
public class Singleton2 {
    //首先定义静态内部类
    private static class SingletonHolder {
        private static Singleton2 singleton2Instance = new Singleton2();
    }

    private Singleton2() {
    }

    //在getInstance函数中直接返回静态内部类中声明的静态变量即可，有JVM保证线程安全
    public static Singleton2 getInstance() {
        return SingletonHolder.singleton2Instance;
    }


    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
    }

}
