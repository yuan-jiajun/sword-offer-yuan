package singleton_2;

public class Singleton { //懒汉式实现，第一次调用getInstance时才会创建对象，饿汉式：直接声明时创建

    //私有化构造函数
    private Singleton() {
    }

    //唯一的对象 ，注意volatile保证变量可见性
    private volatile static Singleton singleton = null;

    //获取对象，注意线程安全
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) { // 修饰一个类，作用范围是synchronized后面括号括起来的部分。
                if (singleton == null) { //里面也需要判断，因为JVM优化代码
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

    //创建一个只能通过对象调用的非static函数测试单例模式
    private void testSingleton() {
        System.out.println("YES!");
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.testSingleton();
    }
}