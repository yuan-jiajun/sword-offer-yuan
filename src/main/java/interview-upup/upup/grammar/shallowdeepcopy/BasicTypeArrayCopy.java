package upup.grammar.shallowdeepcopy;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.Arrays;

/**
 * @author yuanjiajun
 * @date 2020/9/10 0:14
 * @description @link
 */

public class BasicTypeArrayCopy {


    @Test//数组除了默认实现了clone()方法之外，还提供了Arrays.copyOf方法用于拷贝，这两者都是浅拷贝。
    //基本数据类型数组
    public void test() {
        int[] src1 = new int[]{0, 1, 2, 3, 4, 5};
        int[] clone1 = Arrays.copyOf(src1, src1.length);

        clone1[0] = 1;

        boolean isEqual1 = src1[0] == clone1[0];
        System.out.println("src1[0]=" + src1[0] + "  clone1[0]=" + clone1[0] + "  " + isEqual1);

        int[] src2 = new int[]{0, 1, 2, 3, 4, 5};
        int[] clone2 = src2.clone();

        clone2[0] = 1;

        boolean isEqual2 = src2[0] == clone2[0];
        System.out.println("src2[0]=" + src2[0] + "  clone2[0]=" + clone2[0] + "  " + isEqual2);
    }
}