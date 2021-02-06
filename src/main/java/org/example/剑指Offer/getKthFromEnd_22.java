package org.example.剑指Offer;

public class getKthFromEnd_22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode preNode = head;
        ListNode lastNode = head;
        for (int i = 0; i < k; i++) {
            preNode = preNode.next;
        }
        while (preNode != null) {
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        return lastNode;
    }

    public static void main(String[] args) {

    }
}
