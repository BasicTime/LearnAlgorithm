package cn.ms22.chapter3;

import java.util.Stack;

/**
 * 栈有push、pop、peek，只有栈顶一个指针，LIFO
 * 队列，有add、pull，两个指针，FIFO
 *
 * @param <T>
 */
public class StackToQueue<T> {
    private Stack<T> inStack = new Stack<>();
    private Stack<T> outStack = new Stack<>();

    public static void main(String[] args) {
        StackToQueue<Integer> queue = new StackToQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        queue.add(6);
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        queue.add(7);
        queue.add(8);
        queue.add(9);
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        System.out.println(queue.pull());
        System.out.println(queue.pull());


    }

    public void add(T t) {
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        inStack.push(t);
    }

    public T pull() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

}
