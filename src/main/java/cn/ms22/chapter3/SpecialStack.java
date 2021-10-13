package cn.ms22.chapter3;

import java.util.Stack;

public class SpecialStack {
    private Stack<Integer> normalStack = new Stack<>();
    private Stack<Integer> minNumStack = new Stack<>();

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(1);
        specialStack.push(3);
        System.out.println(specialStack.pop());
        System.out.println("min:"+specialStack.getMin());
        System.out.println(specialStack.pop());
        specialStack.push(4);
        specialStack.push(2);
        System.out.println("min:"+specialStack.getMin());
        specialStack.push(8);
        System.out.println(specialStack.pop());
        System.out.println(specialStack.pop());
        specialStack.push(5);
        System.out.println("min:"+specialStack.getMin());
    }

    public void push(int v) {
        normalStack.push(v);
        if (minNumStack.empty()) {
            minNumStack.push(v);
        } else {
            Integer minNum = minNumStack.peek();
            if (minNum <= v) {
                minNumStack.push(minNum);
            } else {
                minNumStack.push(v);
            }
        }
    }

    public int pop() {
        minNumStack.pop();
        return normalStack.pop();
    }

    public int getMin() {
        return minNumStack.peek();
    }
}
