package chapter09.java1;

/**
 * 《深入理解Java虚拟机》中的案例：
 * staticObj、instanceObj、localObj存放在哪里？
 *
 * @create 2020  11:39
 */

public class StaticObjTest {
    static class Test {
        //new ObjectHolder(); new出来的对象都在 堆中
        //staticObj随着Test类的类型信息放在方法区（jdk6和以前在永久代，jdk7及以后在堆中）
        //instanceObj（main函数创建的对象）放在Java堆中
        //localObj则是存放在foo()方法栈帧的局部变量表中

        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new StaticObjTest.Test();
        test.foo();
    }
}
