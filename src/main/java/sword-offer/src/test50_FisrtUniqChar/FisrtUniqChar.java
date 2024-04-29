package test50_FisrtUniqChar;

/**
 * @author Yuan Jiajun
 * @date 2020/8/24 9:30
 * @description
 * 实时输入信息处理
 */
public class FisrtUniqChar {
    static char[] chars = new char[256];
    static StringBuilder sb = new StringBuilder();

    public static void insertChars(char[] inputChars) {
        for (char ch : inputChars) {
            sb.append(ch);
            chars[ch]++;
        }
    }

    public static Character firstUniqChar() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if (chars[c] == 1) {
                return c;
            }
        }
        return null;
    }
}