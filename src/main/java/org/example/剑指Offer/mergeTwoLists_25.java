package org.example.剑指Offer;

public class mergeTwoLists_25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node04 = new ListNode(4);
        node01.next = node02;
        node02.next = node04;

        ListNode node11 = new ListNode(1);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        node11.next = node13;
        node13.next = node14;

        ListNode node = mergeTwoLists(node01, node11);
        System.out.println();
    }

}
