package yuan.test38_PermutationString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Yuan Jiajun
 * @date 2020/9/1 10:12
 * @description
 */
public class permutation {
    /**
     * 递归
     */
    public static ArrayList<String> permutation2(String str) {
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

    @Test
    public void test() {
        long a1 = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 100000; i++) {
            permutation2("abb");
            permutation2("787");

//            permutation1("abb");
//            permutation1("787");
        }
        long a2 = System.currentTimeMillis();
        System.out.println(a2 - a1);


    }
}