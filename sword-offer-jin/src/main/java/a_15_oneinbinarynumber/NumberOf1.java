package a_15_oneinbinarynumber;

/**
 * 二进制中1的个数
 */
public class NumberOf1 {

    private static int getNumberOf1(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        //Java的移位就是按位平移，如果将1移到符号位上去了，就会变成负数
        int a = 1;
        a <<= 30;
        System.out.println(a);
        a <<= 1;
        System.out.println(a);
        a <<= 1;
        System.out.println(a);
        a <<= 1;
        System.out.println(a);

        System.out.println("==============");
        a = 12; //1100
        System.out.println(getNumberOf1(a--));
        System.out.println(getNumberOf1(a--)); //1011
        System.out.println(getNumberOf1(a));
    }
}
