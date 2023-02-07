//<p>Given the <code>head</code> of a linked list and a value <code>x</code>, partition it such that all nodes <strong>less than</strong> <code>x</code> come before nodes <strong>greater than or equal</strong> to <code>x</code>.</p>
//
//<p>You should <strong>preserve</strong> the original relative order of the nodes in each of the two partitions.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/partition.jpg" style="width: 662px; height: 222px;" />
//<pre>
//<strong>Input:</strong> head = [1,4,3,2,5,2], x = 3
//<strong>Output:</strong> [1,2,2,4,3,5]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> head = [2,1], x = 2
//<strong>Output:</strong> [1,2]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in the list is in the range <code>[0, 200]</code>.</li>
//	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
//	<li><code>-200 &lt;= x &lt;= 200</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>
//
//<div>👍 605, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

/**
 * Partition List
 *
 * @author DY
 * @date 2022-08-06 23:26:23
 */
public class P86_PartitionList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P86_PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            ListNode big = new ListNode(-1), small = new ListNode(-1);
            ListNode p = head, p1 = big, p2 = small;
            while (p != null) {
                if (p.val < x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
                p = p.next;
            }
            p1.next = null;
            p2.next = big.next;
            return small.next;
        }


        /*public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(-1);
            ListNode big = new ListNode(-1);
            ListNode p1 = small, p2 = big, p = head;
            while (p != null) {
                if (p.val < x) {
                    p1.next = p;
                    p1 = p1.next;
                } else {
                    p2.next = p;
                    p2 = p2.next;
                }
                p = p.next;
            }
            p1.next = big.next;
            p2.next = null;
            return small.next;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}