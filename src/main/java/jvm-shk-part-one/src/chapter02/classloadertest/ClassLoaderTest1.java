package chapter02.classloadertest;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @create 2020 上午 12:02
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("**********引导类加载器**************");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:引导类加载器
        ClassLoader ProviderClassLoader = Provider.class.getClassLoader();
        System.out.println("ProviderClassLoader: " + ProviderClassLoader);


        System.out.println("\n***********扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:扩展类加载器
        ClassLoader CurveDBClassLoader = CurveDB.class.getClassLoader();
        System.out.println("CurveDBClassLoader: " + CurveDBClassLoader);//sun.misc.Launcher$ExtClassLoader@1540e19d

    }
}
