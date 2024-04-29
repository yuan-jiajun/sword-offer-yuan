package chapter02.classloadertest;

/**
 * @create 2020 上午 10:59
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            //1.
            ClassLoader StringClassLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println("StringClassLoader: " + StringClassLoader);//null

            //2.
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            //3.
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
