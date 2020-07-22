package MagicString;

/**
 * @author yuanjiajun
 * @description https://www.nowcoder.com/practice/7c76ecb05da44b0aa696a9f4d23a3730?tpId=117&&tqId=33614&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * @date 2020/7/23 2:28
 *
 * 超时
 */

import java.util.*;


public class Solution {
    /**
     * @param S1 string字符串 S1
     * @param S2 string字符串 S2
     * @return string字符串
     */
    public String CycleString(String S1, String S2) {
        // write code here
        String tmp = null;
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < S1.length(); i++) {
            tmp = ACycleProcess(S1, i);
            if (tmp.contains(S2)) {
                set.add(tmp);
            }
        }

        return set.first();

    }

    public String ACycleProcess(String string, int offset) {
        String first = string.substring(0, offset);
        String tail = string.substring(offset, string.length());
        return tail+first;
    }

    public static void main(String[] args) {
//        String a = "yuanjiaun";
//        System.out.println(a.substring(0, 1));

        System.out.println(new Solution().CycleString("aaabaaa", "aaaa"));
        System.out.println(new Solution().CycleString("yuanjiajun", "y"));
    }
}