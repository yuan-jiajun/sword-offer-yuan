package chapter02.classloadertest;

/**
 * @author shkstart
 * @create 2020 上午 9:22
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        //获取系统类加载器(应用类加载器）
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader: " + systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("extClassLoader: " + extClassLoader);//sun.misc.Launcher$ExtClassLoader@1540e19d

        //获取其上层：获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("bootstrapClassLoader: " + bootstrapClassLoader);//null

        //对于用户自定义类来说：默认使用应用类加载器进行加载
        ClassLoader userClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("userClassLoader: " + userClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类使用引导类加载器进行加载的。---> Java的核心类库都是使用引导类加载器进行加载的。
        ClassLoader StringClassLoader = String.class.getClassLoader();
        System.out.println("StringClassLoader: " + StringClassLoader);//null


    }
}
