package thread;

import org.junit.jupiter.api.Test;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/8 21:30
 */
public class InstructionRearrangement {
    int a, b, x, y = 0;

    //这里并没有指令重排
    @Test
    public void testInstructionRearrangement() {
        new Thread(() -> {
            x = a;
            b = 1;
        }, "A").start();

        new Thread(() -> {
            y = b;
            a = 2;
        }, "B").start();

        System.out.println(a);
        System.out.println(b);
        System.out.println(x);
        System.out.println(y);
    }
}