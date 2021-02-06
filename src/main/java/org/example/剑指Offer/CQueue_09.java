package org.example.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue_09 {

    Deque<Integer> deque;

    public CQueue_09() {
        deque = new LinkedList<>();
    }

    public void appendTail(int value) {
        deque.addFirst(value);
    }

    public int deleteHead() {
        Integer last = deque.pollLast();
        return null == last ? -1 : last;
    }

    public static void main(String[] args) {
        CQueue_09 cQueue = new CQueue_09();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }
}
