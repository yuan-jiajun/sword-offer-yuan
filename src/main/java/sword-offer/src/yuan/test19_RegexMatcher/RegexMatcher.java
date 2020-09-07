package yuan.test19_RegexMatcher;

/**
 * 我是ACM黑铁选手，我的战斗力只有80，这个人战斗力起码超过了1000
 * @author Yuan Jiajun
 * @date 2020/9/7 11:31
 * @description https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class RegexMatcher {

    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();

        boolean[][] f = new boolean[n + 1][m + 1];//f[i][j] 代表 A 的前 i 个和 B 的前 j 个能否匹配

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (j == 0) {//分成空正则和非空正则两种
                    f[i][j] = i == 0;//空串和空正则是匹配的，f[0][0] = true,非空串和空正则必不匹配，f[1][0]=...=f[n][0]=false

                } else {//非空正则分为两种情况 * 和 非 *

                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }

                    } else {//碰到 * 了，分为 是 和 不是 两种情况

                        //不是，直接砍掉正则串的后面两个， f[i][j] = f[i][j-2]
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }

                        //是，正则串不动，主串前移一个，f[i][j] = f[i-1][j]
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }

        return f[n][m];
    }
}