package a_48_stringoperations;

/**
 * @program: swordofferjava
 * @description: 最长不含重复字符子串
 * @author: Jin Hongjian
 * @create: 2020-07-07
 **/
public class LongestSubstringWithoutDuplications {

    /**
     * 寻找最长不含重复字符子串, 其中输入只包含'a' - 'z'中的字母
     * 使用HashCode的思想
     * 滑动串口法（双指针）
     *
     * @param input
     * @return
     */
    public static String longestSubstringWithoutDuplication(String input) {
        if (input == null) {
            return null;
        }

        int longestLength = 0;
        int longestStringIndex = 0;

        //创建数据缓存字母最后出现的位置
        int[] position = new int[26];
        for (int i = 0; i < 25; i++) {
            position[i] = -1;
        }

        //遍历
        int start = 0;
        int end = 0;
        char c;
        for (; end < input.length(); end++) {
            c = input.charAt(end);
            if (position[c - 'a'] != -1) { //重复
                start = position[c - 'a'] + 1;
            } else {
                position[c - 'a'] = end;
                int len = end - start + 1;
                if (len > longestLength) {
                    longestLength = len;
                    longestStringIndex = start;
                }
            }
        }

        return input.substring(longestStringIndex, longestStringIndex + longestLength);
    }


    public static void main(String[] args) {

        String a = "pwwkew";
        System.out.println(longestSubstringWithoutDuplication(a));
        a = "bbbbb";
        System.out.println(longestSubstringWithoutDuplication(a));
        a = "abcabcbb";
        System.out.println(longestSubstringWithoutDuplication(a));


    }
}
