package yuan.test09_DoubleSQueue;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/12 20:25
 * @description
 */
public class DoubleSQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public DoubleSQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 入栈
     * 时间复杂度：O(1)，空间复杂度：O(n)
     *
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 出栈
     * 时间（摊还）复杂度：O(1)，空间复杂度：O(1)
     *
     * @return
     * @throws Exception
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