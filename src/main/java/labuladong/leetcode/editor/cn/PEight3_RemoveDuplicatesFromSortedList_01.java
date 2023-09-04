/**
 * <p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,1,2]
 * <strong>Output:</strong> [1,2]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,1,2,3,3]
 * <strong>Output:</strong> [1,2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * <li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>链表</details><br>
 *
 * <div>👍 1033, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Remove Duplicates from Sorted List
 *
 * @author DY
 * @date 2023-09-04 19:47:32
 */
public class PEight3_RemoveDuplicatesFromSortedList_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight3_RemoveDuplicatesFromSortedList_01().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (slow.val == fast.val) {
                    fast = fast.next;
                } else {
                    slow.next = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
            }
			slow.next = null;
			return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
