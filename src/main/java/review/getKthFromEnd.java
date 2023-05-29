package review;

public class getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode preNode = head;
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            preNode = preNode.next;
        }
        while (preNode != null) {
            preNode = preNode.next;
            node = node.next;
        }
        return node;
    }
}
