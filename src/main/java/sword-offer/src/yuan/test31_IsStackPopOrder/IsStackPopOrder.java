package yuan.test31_IsStackPopOrder;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:08
 * @description @see https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class IsStackPopOrder {
    public static boolean isStackPopOrder(int[] pushList, int[] popList) {
        if (pushList == null || popList == null) {
            return false;
        }

        int point = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int pushElement : pushList) {
            stack.push(pushElement);
            while (!stack.isEmpty() && stack.peek() == popList[point]) {
                stack.pop();
                point++;
            }
        }

        return stack.isEmpty();
    }

}