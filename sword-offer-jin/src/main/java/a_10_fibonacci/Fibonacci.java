package a_10_fibonacci;

public class Fibonacci {
    //求斐波那契数列值
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new RuntimeException("invalid input");
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int leftValue = 0;
            int rightValue = 1;
            int current = 0;
            for (int i = 2; i <= n; i++) {
                current = leftValue + rightValue;
                leftValue = rightValue;
                rightValue = current;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println("===============");
        System.out.println(fibonacci(-1));


    }
}
