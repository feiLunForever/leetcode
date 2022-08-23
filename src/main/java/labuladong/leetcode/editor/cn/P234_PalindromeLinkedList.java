//<p>Given the <code>head</code> of a singly linked list, return <code>true</code> if it is a palindrome.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
//<pre>
//<strong>Input:</strong> head = [1,2,2,1]
//<strong>Output:</strong> true
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
//<pre>
//<strong>Input:</strong> head = [1,2]
//<strong>Output:</strong> false
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
//	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>
//
//<div>👍 1483, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Palindrome Linked List
 *
 * @author DY
 * @date 2022-08-23 09:47:08
 */
public class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P234_PalindromeLinkedList().new Solution();
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
		ListNode left;
        public boolean isPalindrome(ListNode head) {
            left = head;
            return reverse(head.next);
        }

        private boolean reverse(ListNode right) {
            if (right == null) return true;
            boolean res = reverse(right.next);
            res = res && left.val == right.val;
            left = left.next;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}