package leetcode.GenerateParenthesis22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/9/3 16:57
 * @description
 */
public class GenerateParenthesis2 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }
}
