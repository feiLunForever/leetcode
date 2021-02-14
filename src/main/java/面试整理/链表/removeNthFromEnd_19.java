package 面试整理.链表;

public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dNode = new ListNode(-1);
        dNode.next = head;
        ListNode fastNode = dNode;  // 定义快指针
        ListNode slowNode = dNode;  // 定义慢指针
        for (int i = 0; i < n + 1; i++)
            fastNode = fastNode.next;  // 快指针先走n+1个节点(新增了头结点)
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        ListNode tempNode = slowNode.next;
        slowNode.next = tempNode.next;
        tempNode = null;
        return dNode.next;
    }
}
