package upup.theory.lambda;

import org.testng.annotations.Test;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/22 21:19
 */
public class LambdaDemo2 {
//    final static String salutation = "Hello! ";

    @Test
    public static void test1() {

        String salutation = "Hello! ";
//    final static String salutation = "Hello! ";

        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    /**
     * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
     */

    @Test
    public static void test2() {
//        final int num = 1;
        int num = 1;
//        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num++));
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
//        num=5;

        /**在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。*/


    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }


}