package b_1_add_mult_with_string;

/**
 * @program: swordofferjava
 * @description: 基于String做大数的加法和乘法，参考 https://blog.csdn.net/iteye_1429/article/details/82134877
 * @author: Jin Hongjian
 * @create: 2020-07-02
 **/
public class BigNumberAddAndMultiply {

    /**
     * 两个字符串表示的大数相加，传入字符串必须为纯数字，不带正负号
     *
     * @param num1 第一个数
     * @param num2 第二个数
     * @return sum
     */
    private static String bigAdd(String num1, String num2) {
        int carry = 0;  //记录进位数
        StringBuilder sb = new StringBuilder(); //StringBuilder一位一位的记录结果，先记录的是低位，后记录的是高位，因此最后需要反转一次
        for (int i = 1; i <= (Math.max(num1.length(), num2.length())); i++) { //循环从第 1 位开始到 大的那个数的位数 结束
            int c = (num1.length() >= i ? num1.charAt(num1.length() - i) - '0' : 0)  //短的字符串数字高位用0补齐
                    + (num2.length() >= i ? num2.charAt(num2.length() - i) - '0' : 0)
                    + carry;
            sb.append(c % 10); //当前位拼接到字符串
            carry = c / 10;    //进位留到下一次运算
        }
        if (carry > 0) {
            sb.append(carry); //最后一次运算若有进位，拼接到字符串
        }
        return sb.reverse().toString();
    }

    /**
     * 将较短的一个数numShorter拆分为每位的单数后与较长的那个数numLonger相乘，结果补齐的位数的0的个数，与前一次循环的结果求和
     * 即 numShorter = 213  numLonger=7653234 时：
     * 213 * 7653234    =   3 * 7653234 + 10 * 7653234 + 200 * 7653234
     * =   3 * 7653234 + 1 * 7653234 * 10 (补1个0) + 2 * 7653234 * 100 (补2个0)
     * 加法就用已有的实现
     *
     * @param num1 第一个数
     * @param num2 第二个数
     * @return 积
     */
    private static String bigMultiplication(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new RuntimeException("invalid input");
        }
        //考虑存在负数的情况
        int minusNum = 0;
        if (num1.charAt(0) == '-') {
            minusNum++;
            num1 = num1.substring(1);
        }
        if (num2.charAt(0) == '-') {
            minusNum++;
            num2 = num2.substring(1);
        }

        //模拟人工的计算，我们总是希望把长的那个数放在上面，短的那个数放在下面，这样计算加法的次数少
        String numShorter;
        String numLonger;
        if (num1.length() < num2.length()) {
            numShorter = num1;
            numLonger = num2;
        } else {
            numShorter = num2;
            numLonger = num1;
        }

        String reStr = "0";
        int carry;  //记录进位数
        int loopS, loopL, loopM;
        String zeros = "";  //低位补齐0
        StringBuilder sb = new StringBuilder(); //用来记录循环中每次一个大数与一个一位的数相乘
        for (int i = 0; i < numShorter.length(); i++) { //从较短的数的最后一位开始每位进行计算
            sb.delete(0, sb.length());  //先清空上次遍历的结果内容，在这里能够清除numShorter位为0时直接跳过时的sb
            carry = 0;                  //进位置0
            sb.append(zeros);           //在计算前添加0，因为是从低位开始计算的，最后会倒置一次，所以将0放在最前面，第一次进入时没有
            zeros += "0";               //遍历一次追加一个零
            loopS = numShorter.charAt(numShorter.length() - 1 - i) - '0'; //拿到numShorter的每一位
            if (loopS == 0) {  //numShorter位为0时直接跳过本次循环
                continue;
            }
            for (int j = 0; j < numLonger.length(); j++) { //循环计算numShorter的一位与numsLonger的乘积
                loopL = numLonger.charAt(numLonger.length() - 1 - j) - '0';
                loopM = loopS * loopL + carry;
                sb.append(loopM % 10);
                carry = loopM / 10;
            }
            if (carry > 0) {
                sb.append(carry); //最后一次运算若有进位，拼接到字符串
            }
            reStr = bigAdd(reStr, sb.reverse().toString()); //累加本次乘积
        }
        return minusNum == 1 ? "-" + reStr : reStr;
    }


    public static void main(String[] args) {
        String a = "-9065656000545454510006546498", b = "56765450000000444";
        System.out.println(bigMultiplication(a, b));
        System.out.println("=========================");
        System.out.println(bigMultiplication(b, a));
    }
}