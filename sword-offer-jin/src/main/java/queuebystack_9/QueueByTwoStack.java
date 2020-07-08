package queuebystack_9;

import java.util.Stack;

public class QueueByTwoStack<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueByTwoStack() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    //入队列
    public void enqueue(T ele) {
        stack1.push(ele);
    }

    //出队列
    public T dequeue() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.empty() ? null : stack2.pop();
    }

    //测试
    public static void main(String[] args) {
        QueueByTwoStack<Integer> integerQueueByTwoStack = new QueueByTwoStack<Integer>();
        integerQueueByTwoStack.enqueue(1);
        integerQueueByTwoStack.enqueue(2);
        integerQueueByTwoStack.enqueue(3);
        integerQueueByTwoStack.enqueue(4);
        System.out.println(integerQueueByTwoStack.dequeue());
        System.out.println(integerQueueByTwoStack.dequeue());
        System.out.println(integerQueueByTwoStack.dequeue());
        System.out.println(integerQueueByTwoStack.dequeue());
        System.out.println(integerQueueByTwoStack.dequeue());
    }
}
