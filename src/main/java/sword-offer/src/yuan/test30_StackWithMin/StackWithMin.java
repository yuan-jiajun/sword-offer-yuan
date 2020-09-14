package yuan.test30_StackWithMin;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 15:59
 * @description @link https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class StackWithMin {
    Stack<Integer> A, B;

    public StackWithMin() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}