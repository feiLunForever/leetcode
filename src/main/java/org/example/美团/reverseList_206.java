package org.example.美团;

import java.util.Stack;

public class reverseList_206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.val = 1;
        ListNode l11 = new ListNode(2);
        l11.val = 2;
        l1.next = l11;
        ListNode l12 = new ListNode(3);
        l12.val = 4;
        l11.next = l12;

        ListNode node = reverseList(l1);
        System.out.println();
    }
}
