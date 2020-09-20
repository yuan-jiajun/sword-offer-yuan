package upup.commonly.api;

import org.junit.Test;
import upup.jdktheory.shallowdeepcopy.Subject;

import java.util.Arrays;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 10:29
 * @description
 */
public class ArraysAPI {
    @Test
    public void test1() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] clone1 = new int[5];
        int[] clone2 = new int[5];
        int[] clone3 = new int[5];

        clone1 = a.clone();
        System.out.println(Arrays.toString(clone1) + (clone1[1] == a[1]));

        clone2 = Arrays.copyOfRange(a, 0, a.length);
        System.out.println(Arrays.toString(clone2) + (clone2[1] == a[1]));

        System.arraycopy(a, 0, clone3, 0, a.length);
        System.out.println(Arrays.toString(clone3) + (clone3[1] == a[1]));
    }


    @Test
    public void test2() {
        Subject[] a = new Subject[5];
        for (int i = 1; i <= 5; i++) {
            a[i - 1] = new Subject("" + i);
        }
        Subject[] clone1 = new Subject[5];
        Subject[] clone2 = new Subject[5];
        Subject[] clone3 = new Subject[5];

        clone1 = a.clone();
        System.out.println(Arrays.toString(clone1) + (clone1[1] == a[1]));

        clone2 = Arrays.copyOfRange(a, 0, a.length);
        System.out.println(Arrays.toString(clone2) + (clone2[1] == a[1]));

//        System.arraycopy()确实是浅拷贝，不会进行递归拷贝，所以产生的结果是基本数据类型是值拷贝，对象只是引用拷贝
        System.arraycopy(a, 0, clone3, 0, a.length);
        System.out.println(Arrays.toString(clone3) + (clone3[1] == a[1]));
    }
}