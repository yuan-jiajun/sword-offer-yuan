package a_16_power;

public class PowerOfInteger {
    //


    private static double power(double base, int exponent) throws Exception {
        //判断非法输入，base =0，expo < 0
        if (Math.abs(base) < 1e-6 && exponent < 0) {
            throw new RuntimeException("invalid input");
        }
        return exponent < 0 ? (1.0d / powerCore(base, -exponent)) : powerCore(base, exponent);
    }

    //确保传到powerCore函数中的base和exponent都是正数, 这个可以递归优化
    private static double powerCore(double base, int exponent) {
        double result = 1.0d;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        try {
            System.out.println(power(2, 3));
            System.out.println(power(2, -3));
            System.out.println(power(-2, -3));
            System.out.println(power(-2, 3));
            System.out.println(power(0, 3));
            System.out.println(power(0, -3));
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
