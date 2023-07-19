/**
 * <p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>
 *
 * <p>Merge the two lists in a one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>
 *
 * <p>Return <em>the head of the merged linked list</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
 * <strong>Output:</strong> [1,1,2,3,4,4]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> list1 = [], list2 = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> list1 = [], list2 = [0]
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * <li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>
 *
 * <div>👍 3176, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Merge Two Sorted Lists
 *
 * @author DY
 * @date 2023-07-19 18:14:09
 */
public class PTwo1_MergeTwoSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo1_MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode(-1);
            ListNode p = root, p1 = list1, p2 = list2;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
