package blankreplace_5;

import java.util.Arrays;

/**
 * 替换空格
 */
public class BlankReplace {
    /**
     * 替换空格，在原字符串基础上进行替换，C字符数组的方式，使用Java的话不可避免内存拷贝，使用StringBuilder+遍历原字符串即可
     *
     * @param sourceString 源字符串
     * @param target       空格替换为target字符串
     */
    public static void replaceAllBlackWith(char[] sourceString, char[] target) {
        if (sourceString == null || target == null)
            throw new RuntimeException("Invalid input");

        /*
            注意面试题，如果target为空或者为单字符，直接遍历替换即可
         */

        //首先遍历统计出字符串中空格的个数，计算出替换之后需要的总内存（面试要求内存原数组是够用的）
        int blankNum = 0;
        int originalLength = 0;
        for (char c : sourceString) {
            originalLength++; //最后计算出的长度包含结束符'\0'
            if (c == ' ') {
                blankNum++;
            }
            if (c == '\0') {
                break;
            }
        }
        int totalCharNum = originalLength + blankNum * (target.length - 1);

        //替换
        int left = originalLength;
        int right = totalCharNum;
        for (; left >= 0 && left < right; left--) { //注意这里的循环结束条件
            if (sourceString[left] == ' ') {
                for (int i = target.length - 1; i >= 0; i--) {
                    sourceString[right--] = target[i];
                }
            } else {
                sourceString[right--] = sourceString[left];
            }
        }

    }

    public static void main(String[] args) {
        String source = "We are happy";
        char[] charArray = source.toCharArray();
        char[] finalCharArray = new char[charArray.length * 2];//保证足够大内存
        for (int i = 0; i < charArray.length; i++) {
            finalCharArray[i] = charArray[i];
        }
        finalCharArray[charArray.length] = '\0';

        char[] chars = "%20".toCharArray();

        System.out.println(finalCharArray);
        replaceAllBlackWith(finalCharArray, chars);
        System.out.println(finalCharArray);

    }

}
