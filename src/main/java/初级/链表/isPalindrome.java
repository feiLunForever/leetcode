package 初级.链表;

import org.example.美团.reverseList_206;

public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode firstHalfEnd = getHalfEnd(head);
        ListNode secondHalfEnd = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfEnd;

        while (p2 != null) {
            if (p1.val != p2.val) {
                firstHalfEnd.next = reverseList(secondHalfEnd);
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static ListNode getHalfEnd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(1);
        l1.next = l11;
        ListNode l12 = new ListNode(2);
        l11.next = l12;
        ListNode l13 = new ListNode(1);
        l12.next = l13;
        l13.next = null;
        System.out.println(isPalindrome(l1));
    }
}
