package yuan.test31_IsStackPopOrder;

import java.util.Stack;

/**
 * @author Yuan Jiajun
 * @date 2020/8/26 16:08
 * @description
 */
public class IsStackPopOrder {
    public static boolean isStackPopOrder(int[] pushList, int[] popList) {
        if (pushList == null || popList == null) {
            return false;
        }

        int point = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < pushList.length; i++) {
            stack.push(pushList[i]);
            while (!stack.isEmpty() && stack.peek() == popList[point]) {
                stack.pop();
                point++;
            }
        }

        return stack.isEmpty();
    }

}