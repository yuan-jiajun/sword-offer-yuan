package yuan.test38_PermutationString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 10:12
 * @description @link https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class PermutationString {

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

    /**
     * 回溯
     */
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
            swap(s, startIndex, i); // 恢复交换（回溯）
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

    @Test
    public void test() {
        long a1 = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 100000; i++) {
            permutation("abb");
            permutation("787");

//            permutation1("abb");
//            permutation1("787");
        }
        long a2 = System.currentTimeMillis();
        System.out.println(a2 - a1);


    }
}