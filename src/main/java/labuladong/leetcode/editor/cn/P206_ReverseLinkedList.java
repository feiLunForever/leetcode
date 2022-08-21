//<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>Input:</strong> head = [1,2,3,4,5]
//<strong>Output:</strong> [5,4,3,2,1]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
//<pre>
//<strong>Input:</strong> head = [1,2]
//<strong>Output:</strong> [2,1]
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = []
//<strong>Output:</strong> []
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
//	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>
//<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>
//
//<div>👍 2701, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Reverse Linked List
 *
 * @author DY
 * @date 2022-08-18 18:00:58
 */
public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P206_ReverseLinkedList().new Solution();
        ListNode last = new ListNode(5);
        ListNode last1 = new ListNode(4, last);
        ListNode last2 = new ListNode(3, last1);
        ListNode last3 = new ListNode(2, last2);
        ListNode last4 = new ListNode(1, last3);

        ListNode listNode = solution.reverseList(last4, 6);
        System.out.println();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        ListNode successor;
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        public ListNode reverseList(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            if (head == null || head.next == null) return head;
            ListNode last = reverseList(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}