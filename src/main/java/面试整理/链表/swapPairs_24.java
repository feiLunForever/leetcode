package 面试整理.链表;

public class swapPairs_24 {

    public static ListNode swapPairs(ListNode head) {
        // 定义虚拟指针，指向头节点
        ListNode dNode = new ListNode(-1);
        dNode.next = head;
        // 前置指针
        ListNode pre = dNode;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            // 交换node1 和 node2
            node1.next = next;
            node2.next = node1;
            pre.next = node2;

            // 将前置指针重新定位到node1上
            pre = node1;
        }
        return dNode.next;
    }
}
