package org.example.剑指Offer;

import java.util.Stack;

public class reverseList_24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        ListNode node = new ListNode(stack.pop());
        ListNode tempNode = node;
        while (stack.size() > 0) {
            tempNode.next = new ListNode(stack.pop());
            tempNode = tempNode.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = reverseList(null);
        System.out.println();
    }
}
