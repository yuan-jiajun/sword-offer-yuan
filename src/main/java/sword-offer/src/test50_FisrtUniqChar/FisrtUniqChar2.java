package test50_FisrtUniqChar;

import org.junit.Test;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 9:30
 * @description 对传入的字符串进行处理
 */
public class FisrtUniqChar2 {
    public static char firstUniqCharOrderByAlphabet(String s) {
        char[] chars = new char[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1)
                return (char) i;/**这种表达方式很重要*/
        }

        return ' ';
    }

    public static char firstUniqCharOrderByString(String s) {
        char[] chars = new char[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return ' ';
    }


    @Test
    public void test() {
        System.out.println(firstUniqCharOrderByAlphabet("eabaccdff"));
        System.out.println(firstUniqCharOrderByString("eabaccdff"));
    }
}