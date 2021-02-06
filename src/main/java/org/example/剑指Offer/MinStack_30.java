package org.example.剑指Offer;

import java.util.Stack;

public class MinStack_30 {

    private Stack<Integer> stack, minStack;

    public MinStack_30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == (minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        Integer a = -1024;
        Integer b = -1024;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        MinStack_30 minStack = new MinStack_30();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        //System.out.println(minStack.top());
        //System.out.println(minStack.min());

    }
}
