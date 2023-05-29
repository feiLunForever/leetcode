package review;


public class deleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = null;
                break;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}
