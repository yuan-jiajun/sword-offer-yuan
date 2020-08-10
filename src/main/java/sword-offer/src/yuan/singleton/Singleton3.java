package yuan.singleton;

/**
 * @author Yuan Jiajun
 * @description 饿汉式
 * @date 2020/7/1 12:24
 */
public class Singleton3 {
    private Singleton3() {
    }

    private static class SingletonHodler {
        private static Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHodler.singleton3;
    }


}