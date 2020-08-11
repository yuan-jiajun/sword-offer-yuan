package yuan.test65_add;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuan Jiajun
 * @description
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @date 2020/8/11 15:48
 */
public class add {
    public static int add1(int num1, int num2) {
        while (num2 != 0) {//每次需要判定是否有进位，直到不产生进位为止
            int temp = num1 ^ num2;//不进位求和， 相同位置0，相反位置1
            num2 = (num1 & num2) << 1;//判断是否有进位的部分，
            num1 = temp;//把非进位的求和值作为临时值，加上进位部分的num2
        }
        return num1;
    }

    public int add2(int num1, int num2) {
        AtomicInteger ai = new AtomicInteger(num1);
        return ai.addAndGet(num2);
    }


    @Test
    public void test47() throws Exception {
        int num1 = 5;
        int num2 = 11;
        System.out.println("求和：" + num1 + " + " + num2 + " = " + add1(num1, num2));
        System.out.println("求和：" + num1 + " + " + num2 + " = " + add2(num1, num2));
    }
}