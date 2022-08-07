//<p>Given the <code>head</code> of a singly linked list, return <em>the middle node of the linked list</em>.</p>
//
//<p>If there are two middle nodes, return <strong>the second middle</strong> node.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" />
//<pre>
//<strong>Input:</strong> head = [1,2,3,4,5]
//<strong>Output:</strong> [3,4,5]
//<strong>Explanation:</strong> The middle node of the list is node 3.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" />
//<pre>
//<strong>Input:</strong> head = [1,2,3,4,5,6]
//<strong>Output:</strong> [4,5,6]
//<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li>
//	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>
//
//<div>👍 647, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Middle of the Linked List
 *
 * @author DY
 * @date 2022-08-07 14:40:59
 */
public class P876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P876_MiddleOfTheLinkedList().new Solution();
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
        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}