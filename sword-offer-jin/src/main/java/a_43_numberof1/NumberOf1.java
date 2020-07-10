package a_43_numberof1;

/**
 * 寻找1-n的整数中，1出现的次数，
 */
public class NumberOf1 {

    /**
     * 思路，以输入n:21345为例：
     * 分为两个部分： 1~1345 和 1346~21345
     * 前一部分即后一部分去掉最高位就变成1345，这样方便递归
     * 后一部分 1346~21345的计算又可以分为1出现在最高位的情况和出现在其他位的情况：
     * 出现在最高位的次数（设最高位为k）：则出现次数：10000（k>1）, n%10+1 (n=1)
     * 出现在除了最高位以外的其他位的次数（设最高位为k，共a位）： K * (a-1) * 1000 , 排列组合
     *
     * @param n
     * @return
     */
    private static int getNumberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }
        //digits表示n的位数
        int digits = 0;
        int temp = n;
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        return numberOf1Core(n, digits);
    }

    private static int numberOf1Core(int n, int digits) {
        //递归终止条件，只有一位
        if (digits == 1) {
            return 1;
        }

        //首先拿到最高位 对应10000~21345部分万位上1的个数
        int num = (int) Math.pow(10, digits - 1);
        int k = n / num;
        int rest = n - k * num; //去掉最高位后余下的数
        //最高位上出现的个数
        int numberOfFirstDigit;
        if (k > 1) {
            numberOfFirstDigit = num;
        } else {
            numberOfFirstDigit = rest + 1;
        }
        //10000~21345部分后四位上1的个数
        int numberOfOtherDigits = k * (digits - 1) * (int) Math.pow(10, digits - 2);
        //递归求得1~1345部分1的个数
        int rec = numberOf1Core(rest, digits - 1);
        //返回和
        return numberOfFirstDigit + numberOfOtherDigits + rec;
    }

    public static void main(String[] args) {
        int n = 21345;
        System.out.println(getNumberOf1Between1AndN(n));
        System.out.println(getNumberOf1Between1AndN(12));
    }

}
