package 面试整理.链表;

public class removeElements_203 {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dHead = new ListNode(-1);
        dHead.next = head;
        ListNode cur = dHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = null;
                temp = null;
            } else {
                cur = cur.next;
            }
        }
        return dHead.next;
    }
}
