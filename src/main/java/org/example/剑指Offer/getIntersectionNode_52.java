package org.example.剑指Offer;

public class getIntersectionNode_52 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        ListNode headA2 = new ListNode(6);
        ListNode headA3 = new ListNode(4);
        headA.next = headA2;
        headA2.next = headA3;
        ListNode headB = new ListNode(1);
        ListNode headB2 = new ListNode(2);
        ListNode headB3 = new ListNode(6);
        ListNode headB4 = new ListNode(4);
        headB.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        System.out.println(getIntersectionNode(headA, headB));
    }
}
