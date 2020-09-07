package yuan.test20_IsNumber;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 15:30
 * @description https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class IsNumber {
    /**
     * 解法一：逐个字符进行判断
     */
    public static boolean isNumber1(char[] str) {
        if (str == null) {
            return false;
        }

        int index = 0;
        int eCount = 0;
        int point = 0;

        // 如果第一个字符是符号就跳过
        if (str[0] == '-' || str[0] == '+')
            index++;

        for (int i = index; i < str.length; i++) {
            if (str[i] == '-' || str[i] == '+') {
                if (str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                continue;
            }

            if (str[i] == 'e' || str[i] == 'E') {
                eCount++;
                if (eCount > 1)
                    return false;
                if (i == 0 || str[i - 1] < 48 || str[i - 1] > 57 || i == str.length - 1)
                    return false;
                point++;
                continue;
            }

            if (str[i] == '.') {
                point++;
                if (point > 1)
                    return false;
                continue;
            }

            // 出现非数字且不是e/E则返回false（小数点和符号用continue跳过了）
            if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E'))
                return false;
        }
        return true;
    }

    /**
     * 解法二：正则表达式
     * ？ 表示零次或一次匹配前面的字符或子表达式    * 表示零次或多次匹配前面的字符或子表达式
     * + 表示一次或多次匹配前面的字符或子表达式    . 表示匹配除了换行符的任何单个字符
     */
    public static boolean isNumber2(String s) {

        boolean flag1 = s.matches("[+-]?[0-9\\s]*(\\.[0-9\\s]*)?([eE][+-]?[0-9\\s]+)?");
        boolean flag2 = s.matches("(\\s)?\\.(\\s)?");
        boolean flag3 = s.matches("[eE][+-]?[0-9]+");
        boolean flag4 = s.matches("\\s?");

        return flag1 & !flag2 & !flag3 & !flag4;
    }

    @Test
    public void test() {
        boolean a = isNumber2("");
        System.out.println(a);
    }
}