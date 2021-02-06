package 中级.链表;

public class oddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        // 奇数
        ListNode odd = head;
        // 偶数
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            // even.next是下一个奇数结点
            odd.next = even.next;
            // odd 推进到下一个奇数结点
            odd = odd.next;
            // 下一个奇数结点的next是下一个偶数结点
            even.next = odd.next;
            // even 推进到下一个偶数结点
            even = even.next;
        }
        // 奇链连上偶链
        odd.next = evenHead;
        return head;
    }
}
