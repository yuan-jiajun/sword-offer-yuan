package chapter05.java2;

/**
 * 体会 invoke dynamic指令
 *
 * @author shkstart
 * @create 2020 下午 3:09
 */

@FunctionalInterface
interface Func {
    public String func(String str);
}

public class LambdaDemo {
    public void lambda(Func func) {
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();

        Func func = s -> {
            System.out.println("yuanjiajun");
            return "yuanjiajun";
        };

        System.out.println();
        lambdaDemo.lambda(func);

        lambdaDemo.lambda(s -> "true");
    }
}

