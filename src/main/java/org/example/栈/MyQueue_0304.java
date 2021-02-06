package org.example.栈;

import java.util.Stack;

class MyQueue_03034{
    class MyQueue {

        private Stack<Integer> stack;
        private Stack<Integer> tempStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<Integer>();
            tempStack = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return tempStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(tempStack.isEmpty()){
                while (!stack.isEmpty()){
                    tempStack.push(stack.pop());
                }
            }
            return tempStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty() && tempStack.isEmpty();
        }
    }
}