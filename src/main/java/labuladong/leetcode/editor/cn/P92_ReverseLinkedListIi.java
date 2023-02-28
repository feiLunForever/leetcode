/**
 * <p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
 * <strong>Output:</strong> [1,4,3,2,5]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [5], left = 1, right = 1
 * <strong>Output:</strong> [5]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the list is <code>n</code>.</li>
 * <li><code>1 &lt;= n &lt;= 500</code></li>
 * <li><code>-500 &lt;= Node.val &lt;= 500</code></li>
 * <li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you do it in one pass?
 *
 * <details><summary><strong>Related Topics</strong></summary>链表</details><br>
 *
 * <div>👍 1504, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Reverse Linked List II
 *
 * @author DY
 * @date 2023-02-27 20:11:04
 */
public class P92_ReverseLinkedListIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1, head);
            ListNode root = dummy;
            for (int i = 1; i < left; i++) { // 找到需要反转的那一段的上一个节点。
                root = root.next;
            }
            ListNode pre = null, cur = root.next; // root.next就是需要反转的这段的起点
            for (int i = left; i <= right; i++) { // 反转m到n这一段
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            root.next.next = cur; // 将反转的起点的next指向next
            root.next = pre; // 需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}