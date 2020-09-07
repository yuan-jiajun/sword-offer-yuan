package yuan.test09_DoubleSQueue;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 20:25
 * @description
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class DoubleSQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public DoubleSQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 入栈
     * 时间复杂度：O(1)，空间复杂度：O(n)
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 出栈
     * 时间（摊还）复杂度：O(1)，空间复杂度：O(1)
     */
    public int deleteHead() throws Exception {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new Exception("栈为空！");
//            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}