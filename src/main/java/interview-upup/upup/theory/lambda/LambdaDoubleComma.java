package upup.theory.lambda;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/22 22:00
 */
public class LambdaDoubleComma {


    // constructor methods
    LambdaDoubleComma() {
    }

    LambdaDoubleComma(String s) {
        System.out.println("调用了构造器");
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    void endWith() {
    }

    public static void main(String[] args) {
        // static methods
        IConvert<String, String> converter = null;

        converter = LambdaDoubleComma::startsWith;
        System.out.println(converter.convert("Hello"));

        // object methods
        LambdaDoubleComma comma = new LambdaDoubleComma();
        converter = comma::endWith;
        System.out.println(converter.convert("Java"));


        // constructor methods
        IConvert<String, LambdaDoubleComma> convert = LambdaDoubleComma::new;
        LambdaDoubleComma lambdaDoubleComma = convert.convert("constructors");
    }

}

/**
 * 总结：我们可以把类Something中的方法
 * static String startsWith(String s){...}
 * String endWith(String s){...}
 * Something(String something){...}
 * <p>
 * 看作是接口IConvert的实现，因为它们都符合接口定义的那个“模版”，
 * 有传参类型F以及返回值类型T。
 * <p>
 * 比如构造方法Something(String something)，它传参为String类型，返回值类型为Something。
 * <p>
 * 注解@FunctionalInterface保证了接口有且仅有一个抽象方法，所以JDK能准确地匹配到相应方法。
 */
@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}