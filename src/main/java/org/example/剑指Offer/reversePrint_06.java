package org.example.剑指Offer;

import java.util.Stack;

public class reversePrint_06 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int length = stack.size();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        h.next = h2;
        h2.next = h3;
        int[] ints = reversePrint(null);
        System.out.println();
    }
}
