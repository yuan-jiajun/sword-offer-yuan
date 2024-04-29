package test02_Singleton;

/**
 * @author yuanjiajun
 * @date 2020/9/17 23:46
 * @description @link
 */
public class SingletonEnum {


    private SingletonEnum() {

    }

    /**
     * 因为枚举类型是线程安全的，并且只会装载一次，
     * 设计者充分的利用了枚举的这个特性来实现单例模式，枚举的写法非常简单，
     * 而且枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式。
     */
    private enum Singleton {
        INSTANCE;

        private final SingletonEnum instance;

        Singleton() {
            instance = new SingletonEnum();
        }

        private SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

}

