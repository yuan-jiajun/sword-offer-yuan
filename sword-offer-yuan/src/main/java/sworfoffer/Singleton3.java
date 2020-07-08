package sworfoffer;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/1 12:24
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }
}