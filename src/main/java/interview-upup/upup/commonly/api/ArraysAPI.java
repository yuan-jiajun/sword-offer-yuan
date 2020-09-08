package upup.commonly.api;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 10:29
 * @description
 */
public class ArraysAPI {
    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        a.clone();

        Arrays.copyOfRange(a, 1, 1);
    }
}