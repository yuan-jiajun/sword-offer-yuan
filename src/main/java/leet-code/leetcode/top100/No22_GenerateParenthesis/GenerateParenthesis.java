package leetcode.top100.No22_GenerateParenthesis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/3 16:44
 * @description @see https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        dfs(res, 0, str.toCharArray());

        // 符合结果的输出顺序
        Collections.sort(res);
        return res;

    }

    static void dfs(ArrayList<String> res, int startIndex, char[] s) {
        if (startIndex == s.length - 1) {
            res.add(String.valueOf(s)); // startIndex到达最后字符串最后一个字符，添加排列方案
            return;
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = startIndex; i < s.length; i++) {
            if (set.contains(s[i])) continue; // 重复，因此剪枝
            set.add(s[i]);
            swap(s, startIndex, i); // 交换，将 s[i] 固定在第 startIndex 位
            dfs(res, startIndex + 1, s); // 开启固定第 startIndex + 1 位字符
            swap(s, startIndex, i); // 恢复交换
        }

    }

    /**
     * 交换两个字符的位置
     */
    public static void swap(char[] output, int locate, int chose) {
        char temp = output[locate];
        output[locate] = output[chose];
        output[chose] = temp;
    }

    public void isValid(ArrayList<String> res) {
        for (String re : res) {
            int length = re.length();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < length; i++) {
                if (re.charAt(i) == '(') {
                    stack.push("(");
                } else {
                    if (!stack.empty() && stack.peek().equals("(")) {
                        stack.pop();
                    }
                }
            }
            if (stack.empty()) {
                System.out.println(re);
            }
        }
    }

    @Test
    public void test() {
        isValid(permutation("((()))"));
    }
}