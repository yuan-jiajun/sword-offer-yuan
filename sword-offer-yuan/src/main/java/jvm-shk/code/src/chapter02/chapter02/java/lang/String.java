package java.lang;

/**
 * @author shkstart
 * @create 2020 上午 11:40
 */
public class String {

    static {
        System.out.println("我是自定义的String类的静态代码块");
    }

    //双亲委派机制
    //错误: 在类 java.lang.String 中找不到 main 方法
    public static void main(String[] args) {
        java.lang.String string = new java.lang.String();
        System.out.println("hello,String");
    }
}
