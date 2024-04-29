package chapter02.classloadertest;

/**
 * @create 2020 上午 11:39
 */
public class StringTest {

    public static void main(String[] args) {
        java.lang.String str = new java.lang.String();
        System.out.println("hello");

        StringTest test = new StringTest();
        System.out.println(test.getClass().getClassLoader());
    }
}
