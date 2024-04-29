package test05_ReplaceSpace;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @description https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @date 2020/8/11 15:32
 */
public class ReplaceSpace {
    /**
     * 解法一：使用StringBuffer，线程安全
     */
    public static String replaceSpace1(String input) {
        if (input == null) {
            return null;
        }
        StringBuffer outputBuffer = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                outputBuffer.append("%20");
            } else {
                outputBuffer.append(input.charAt(i));
            }
        }
        return new String(outputBuffer);
    }

    /**
     * 解法二：使用StringBuilder,非线程安全
     */
    public static String replaceSpace2(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    /**
     * 解法三：先计算新的字符串长度，再从后往前复制
     */
    public static String replaceSpace3(String input) {
        if (input == null) {
            return null;
        }
        int blankNum = 0;
        int length = input.length();
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ' ') {
                blankNum++;
            }
        }
        // 替换后的字符串长度
        newLength = length + 2 * blankNum;
        char[] newChars = new char[newLength];
        int index = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                newChars[index--] = '0';
                newChars[index--] = '2';
                newChars[index--] = '%';
            } else {
                newChars[index--] = input.charAt(i);
            }
        }
        return new String(newChars);
    }

    @Test
    public void test() {
        String beforeStr = " ab g gt r ";
        System.out.println("解法一：使用StringBuffer， 替换前：" + beforeStr + " 替换后：" + replaceSpace1(beforeStr));
        System.out.println("解法二：使用StringBuilder，替换前：" + beforeStr + " 替换后：" + replaceSpace2(beforeStr));
        System.out.println("解法三：从后往前复制，     替换前：" + beforeStr + " 替换后：" + replaceSpace3(beforeStr));
    }
}