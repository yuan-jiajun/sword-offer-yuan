package chapter02.init;

/**
 * @create 2020 下午 8:12
 */
public class HelloLoader {

    public static void main(String[] args) {
        System.out.println(HelloLoader.class.getClassLoader());
        System.out.println("谢谢ClassLoader加载我....");
        System.out.println("你的大恩大德，我下辈子再报！");
    }
}
