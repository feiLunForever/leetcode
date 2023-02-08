//<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>Input:</strong> head = [1,2,3,4,5], n = 2
//<strong>Output:</strong> [1,2,3,5]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = [1], n = 1
//<strong>Output:</strong> []
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = [1,2], n = 1
//<strong>Output:</strong> [1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the list is <code>sz</code>.</li>
//	<li><code>1 &lt;= sz &lt;= 30</code></li>
//	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
//	<li><code>1 &lt;= n &lt;= sz</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Follow up:</strong> Could you do this in one pass?</p>
//<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>
//
//<div>👍 2161, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Remove Nth Node From End of List
 *
 * @author DY
 * @date 2022-08-07 14:16:05
 */
public class P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
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

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = new ListNode(-1);
            root.next = head;
            ListNode fast = root, slow = root;
            for (int i = 0; i < n + 1; i++) { // 先走n + 1步（找到倒数第n + 1个节点）
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return root.next;
        }

        /*public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode listNode = new ListNode(-1);
			listNode.next = head;
			ListNode fast = listNode, slow = listNode;
			for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return listNode.next;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}