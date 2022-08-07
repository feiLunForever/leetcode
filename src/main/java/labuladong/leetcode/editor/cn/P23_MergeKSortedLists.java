//<p>You are given an array of <code>k</code> linked-lists <code>lists</code>, each linked-list is sorted in ascending order.</p>
//
//<p><em>Merge all the linked-lists into one sorted linked-list and return it.</em></p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> lists = [[1,4,5],[1,3,4],[2,6]]
//<strong>Output:</strong> [1,1,2,3,4,4,5,6]
//<strong>Explanation:</strong> The linked-lists are:
//[
//  1-&gt;4-&gt;5,
//  1-&gt;3-&gt;4,
//  2-&gt;6
//]
//merging them into one sorted list:
//1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> lists = []
//<strong>Output:</strong> []
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> lists = [[]]
//<strong>Output:</strong> []
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>k == lists.length</code></li>
//	<li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li>
//	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
//	<li><code>-10<sup>4</sup> &lt;= lists[i][j] &lt;= 10<sup>4</sup></code></li>
//	<li><code>lists[i]</code> is sorted in <strong>ascending order</strong>.</li>
//	<li>The sum of <code>lists[i].length</code> will not exceed <code>10<sup>4</sup></code>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>链表 | 分治 | 堆（优先队列） | 归并排序</details><br>
//
//<div>👍 2095, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k Sorted Lists
 *
 * @author DY
 * @date 2022-08-07 09:10:53
 */
public class P23_MergeKSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P23_MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode listNode = new ListNode(-1);
            ListNode p = listNode;
            Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);


            for (ListNode item : lists) {
                if (item != null) {
                    queue.offer(item);
                }
            }

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;
                if (node.next != null) {
                    queue.add(node.next);
                }
                p = p.next;
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}