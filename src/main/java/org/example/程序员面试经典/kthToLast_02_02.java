package org.example.程序员面试经典;


public class kthToLast_02_02 {

    public static int kthToLast(ListNode head, int k) {
        ListNode preNode = head;
        ListNode lastNode = head;
        for (int i = 0; i < k; i++) {
            preNode = preNode.next;
        }
        while (preNode != null) {
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        return lastNode.val;
    }
}
