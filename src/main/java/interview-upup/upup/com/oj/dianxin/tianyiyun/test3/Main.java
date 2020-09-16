package upup.com.oj.dianxin.tianyiyun.test3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/16 21:15
 * @description @link
 */
public class Main {
    private static Stack<Integer> A = new Stack<>();
    private static Stack<Integer> B = new Stack<>();

    public Main() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public static void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public static void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public static int top() {
        return A.peek();
    }

    public static int getMin() {
        return B.peek();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        while (count > 0) {
            String string = in.nextLine();
            if (string.contains("push")) {
                int num = Integer.parseInt(string.split(" ")[1]);
                push(num);
            }
            if (string.contains("pop")) {
                pop();
            }
            if (string.contains("top")) {
                System.out.println(top());
            }
            if (string.contains("getMin")) {
                System.out.println(getMin());
            }
            count--;
        }
    }
}