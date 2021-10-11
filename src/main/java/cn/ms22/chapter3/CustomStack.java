package cn.ms22.chapter3;

public class CustomStack<T> {
    private int size;
    private T[] arr;
    //指向待插入位置的Index
    private int cur;

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(4);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        customStack.push(4);
        System.out.println(customStack.pop());
        customStack.push(3);
        System.out.println(customStack.peek());
        System.out.println(customStack.pop());
        customStack.push(10);
        System.out.println(customStack.peek());
        System.out.println(customStack.pop());
    }

    public int size() {
        return cur;
    }

    public T peek() {
        if (cur == 0) {
            throw new RuntimeException("到栈底了。");
        }
        return arr[cur - 1];
    }

    public boolean empty() {
        return cur == 0;
    }

    public CustomStack(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
    }

    public T pop() {
        if (cur == 0) {
            throw new NullPointerException("已经到栈底。");
        }
        return arr[--cur];
    }

    public void push(T t) {
        if (cur == size) {
            throw new NullPointerException("已经超过栈顶。");
        }
        arr[cur++] = t;
    }

}
