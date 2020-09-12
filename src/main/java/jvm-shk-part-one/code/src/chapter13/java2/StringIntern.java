package chapter13.java2;


/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？
 * 有两种方式：
 * 方式一： String s = "";//字面量定义的方式
 * 方式二： 调用intern()
 * String s = new String("").intern();
 * String s = new StringBuilder("").toString().intern();
 *
 * @create 2020  18:49
 */
public class StringIntern {
    public static void main(String[] args) {

        String s = new String("1");//返回的是堆空间中的对象的地址
        s.intern();//调用此方法之前，字符串常量池中已经存在了"1"
        String s2 = "1";//返回的是字符串常量池中的地址
        System.out.println(s == s2);//jdk6：false   jdk7/8：false


//        String s = new String("1");
//        s.intern();//调用此方法之前，字符串常量池中已经存在了"1"
//        String s2 = "1";
//        System.out.println(s.intern() == s2);//jdk6：true   jdk7/8：true


        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
        //执行完上一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
//        s3.intern();//在字符串常量池中生成"11"。
//        如何理解：jdk6:在方法区（永久代）常量池中创建了一个新的对象"11",也就有新的地址
//                jdk7:调用intern()方法在常量池中并没有创建"11",而是创建一个指向堆空间中new String("11")创建的对象的地址
        String s4 = "11";//s4变量记录的地址：使用的是上一行代码代码执行时，在常量池中生成的"11"的地址
        System.out.println(s3 == s4);//jdk6：false  jdk7/8：true


//        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
//        //执行完上一行代码以后，字符串常量池中，是否存在"11"呢？答案：不存在！！
//        String s4 = "11";
//        System.out.println(s3 == s4);//jdk6：false  jdk7/8：false


    }


}
