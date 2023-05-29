package review;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? nodeB : nodeA.next;
            nodeB = nodeB == null ? nodeA : nodeB.next;
        }
        return nodeA;
    }
}
