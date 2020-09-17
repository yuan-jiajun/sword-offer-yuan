package upup.com.interview.myself.huawei.turn2;

import java.util.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/17 14:02
 * @description @link https://blog.csdn.net/weixin_42212257/article/details/105530758
 */
public class Main {
    public static String removeDuplicateLetters(String s) {

        // 栈用来存放最后的结果，
        Stack<Character> stack = new Stack<>();
        // hashmap用来存放每个字母出现的次数，
        Map<Character, Integer> map = new HashMap<>();
        // set用来存放不重复的字母
        Set<Character> set = new HashSet<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
//            System.out.println(c + ":" + map.get(c));

        }

        for (Character c : s.toCharArray()) {

            if (!set.contains(c)) {
                //这里的判定是一个难点,并且判断是否为空要在peek之前
                //并且我们判定的是stack栈中前一个字符与现在所遍历到的字符的关系，并且判定前一个字符是否重复
                //并且这个判定一直持续到否为止，这时贪心算法的关键

                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) >= 1) {
                    set.remove(stack.peek());
                    stack.pop();
                }

                stack.push(c);
                set.add(c);
            }

            //在这里，会一直把当前遍历的字符在map中的个数减去1操作
            map.put(c, map.get(c) - 1);

        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) stringBuilder.append(stack.pop());
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));//acdb
    }
}