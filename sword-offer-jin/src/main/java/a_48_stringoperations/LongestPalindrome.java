package a_48_stringoperations;

/**
 * @program: swordofferjava
 * @description: 最长回文子串
 * @author: Jin Hongjian
 * @create: 2020-07-07
 **/
public class LongestPalindrome {

    /**
     * 查找最长回文子字符串，中心扩展算法 O（n^2）
     * 判断从i开始至j结束(含)的字串是不是回文串的状态转移方程：S(i)表示在索引i处的字符
     * P(i,i) = true
     * P(i,i+1) = S(i)==S(i+1)
     * P(i,j) = P(i+1,j-1) && S(i)==S(j)
     *
     * @param input
     * @return
     */
    public static String longestPalindrome(String input) {
        if (input == null) {
            return null;
        }

        int maxLength = 0;
        int maxStartIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            int lengthOne = expandAroundCenter(input, i, i);
            int lengthTwo = expandAroundCenter(input, i, i + 1);
            int cLen = Math.max(lengthOne, lengthTwo);
            if (cLen > maxLength) {
                maxLength = cLen;
                maxStartIndex = i - (cLen - 1) / 2; //clen是偶数时先减一再除，奇数时这个减一没有影响
            }
        }
        return input.substring(maxStartIndex, maxLength + maxStartIndex);
    }

    private static int expandAroundCenter(String input, int start, int end) {
        while (start >= 0 && end < input.length() && input.charAt(start) == input.charAt(end)) {
            start--;
            end++;
        }
        // end - start + 1 - 2（减去多进去循环那一次）
        return end - start - 1;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("gdfdababa1dwa"));
        System.out.println(longestPalindrome("gdfdababbab1dwa"));
    }
}
