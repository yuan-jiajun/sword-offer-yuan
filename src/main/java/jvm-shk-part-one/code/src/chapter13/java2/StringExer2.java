package chapter13.java2;


/**
 * @author shkstart  shkstart@126.com
 * @create 2020  20:26
 */
public class StringExer2 {
    public static void main(String[] args) {
        //方法1
        String s1 = new String("ab");//执行完以后，会在字符串常量池中会生成"ab",返回堆中s1对象的地址
        s1.intern();//这步操作其实啥没做，因为s1的引用指向的对象创建的时候就在串池中创建了对象，指向s1引用的对象

        //方法2
//        String s1 = new String("a") + new String("b");//执行完以后，不会在字符串常量池中会生成"ab"
//        s1.intern();//串池中没有创建字符串"ab",而是创建一个引用，指向new String("ab")，将此引用返回

        String s2 = "ab";//执行完以后，不会再次在字符串常量池中会生成"ab",因为本身就有"ab",返回常量池中"ab"的地址

        /**两种方式，串池种的内容是不一样的，方法1串池种存的是"ab"，方法2串池种存的是 new String("ab")的地址*/
        System.out.println(s1 == s2);//false,s1和s2虽然都是"ab"，但是地址不同，s1堆中s1对象的地址，s2常量池中"ab"的地址

        System.out.println(s1.intern() == s1);//false
        System.out.println(s1 == "ab".intern());//false
        System.out.println(s1.intern() == "ab");//true

        System.out.println(s1.intern() == s2.intern());//true
        System.out.println(s1.intern() == s2);//true
        System.out.println(s1.intern().toString() == s2.toString());//true

        System.out.println(s1.intern() + "" == s2 + "");//false
        System.out.println((s1.intern() + "yuan").intern() == s2 + "yuan");//false

        System.out.println((s1.intern() + "yuan").intern() == (s2 + "yuan").intern());//true
    }
}
