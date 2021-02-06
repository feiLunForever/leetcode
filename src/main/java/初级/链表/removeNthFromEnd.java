package 初级.链表;

import org.example.剑指Offer.deleteNode_18;

public class removeNthFromEnd {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode pre = null;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            pre = second;
            first = first.next;
            second = second.next;
        }

        if (pre == null) {
            return head.next;
        }
        pre.next = second.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        h1.next = h2;
        h2.next = h3;
        removeNthFromEnd(h1, 2);
        System.out.println();
    }

}
