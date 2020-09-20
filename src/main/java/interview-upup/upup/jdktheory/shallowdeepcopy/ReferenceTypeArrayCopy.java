package upup.jdktheory.shallowdeepcopy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yuanjiajun
 * @date 2020/9/10 0:14
 * @description @link
 */

public class ReferenceTypeArrayCopy {

    @Test
    public void test5() {
        People[] src1 = new People[5];
        src1[0] = new People();
        People[] clone1 = src1;

        boolean isEqual1 = src1[0] == clone1[0];
        System.out.println("src1[0]=" + src1[0] + "\nclone1[0]=" + clone1[0] + "\n" + isEqual1 + "\n");

        People[] src2 = new People[5];
        src2[0] = new People();
        People[] clone2 = Arrays.copyOf(src2, src2.length);

        boolean isEqual2 = src2[0] == clone2[0];
        System.out.println("src2[0]=" + src2[0] + "\nclone2[0]=" + clone2[0] + "\n" + isEqual2 + "\n");

        People[] src3 = new People[5];
        src3[0] = new People();
        People[] clone3 = src3.clone();

        boolean isEqual3 = src2[0] == clone2[0];
        System.out.println("src3[0]=" + src3[0] + "\nclone3[0]=" + clone3[0] + "\n" + isEqual3 + "\n");
    }

    public static class People implements Cloneable {
        int age;
        Holder holder;

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static class Holder {
            int holderValue;
        }
    }
}