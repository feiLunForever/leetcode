package org.example.美团;

public class mergeTwoLists_21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode temp = l;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            }
            if (l2 == null) {
                temp.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return l.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l11 = new ListNode();
        l11.val = 2;
        l1.next = l11;
        ListNode l12 = new ListNode();
        l12.val = 4;
        l11.next = l12;

        ListNode l2 = new ListNode();
        l2.val = 1;
        ListNode l21 = new ListNode();
        l21.val = 3;
        l2.next = l21;
        ListNode l22 = new ListNode();
        l22.val = 4;
        l21.next = l22;
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println();
    }
}
