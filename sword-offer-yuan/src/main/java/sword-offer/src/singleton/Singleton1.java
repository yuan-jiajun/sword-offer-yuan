package singleton;

/**
 * @author Yuan Jiajun
 * @description 饿汉式
 * @date 2020/7/1 12:24
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }
}