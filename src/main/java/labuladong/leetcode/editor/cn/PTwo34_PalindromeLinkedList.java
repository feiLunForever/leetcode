/**
 * <p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence"><em>palindrome</em></span><em> or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2,2,1]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" />
 * <pre>
 * <strong>Input:</strong> head = [1,2]
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
 * <li><code>0 &lt;= Node.val &lt;= 9</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong> Could you do it in
 * <code>O(n)</code> time and
 * <code>O(1)</code> space?
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>
 *
 * <div>👍 1624, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Palindrome Linked List
 *
 * @author DY
 * @date 2023-03-03 16:22:55
 */
public class PTwo34_PalindromeLinkedList {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new PTwo34_PalindromeLinkedList().new Solution();
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
		public boolean isPalindrome(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			if (fast != null) { // 此时为奇数个，slow在正中间，因为要回文，所以slow再往前走一步
				slow = slow.next;
			}
			ListNode left = head;
			ListNode right = reverse(slow);
			while (right != null && left != null) {
				if (right.val != left.val) return false;
				left = left.next;
				right = right.next;
			}
			return true;
		}

		private ListNode reverse(ListNode root) {
			ListNode pre = null, cur = root;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			return pre;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
