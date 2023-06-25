/**
 * <p>Given a singly linked list, return a random node's value from the linked list. Each node must have the <strong>same probability</strong> of being chosen.</p>
 *
 * <p>Implement the <code>Solution</code> class:</p>
 *
 * <ul>
 * <li><code>Solution(ListNode head)</code> Initializes the object with the head of the singly-linked list <code>head</code>.</li>
 * <li><code>int getRandom()</code> Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/16/getrand-linked-list.jpg" style="width: 302px; height: 62px;" />
 * <pre>
 * <strong>Input</strong>
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * <strong>Output</strong>
 * [null, 1, 3, 2, 2, 3]
 * </pre>
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the linked list will be in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>getRandom</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * <li>What if the linked list is extremely large and its length is unknown to you?</li>
 * <li>Could you solve this efficiently without using extra space?</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>水塘抽样 | 链表 | 数学 | 随机化</details><br>
 *
 * <div>👍 343, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import labuladong.ListNode;

import java.util.Random;

/**
 * Linked List Random Node
 *
 * @author DY
 * @date 2023-06-25 12:31:12
 */
public class PThree82_LinkedListRandomNode {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree82_LinkedListRandomNode().new Solution(null);
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

        private final Random random = new Random();

        private ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            ListNode p = head;
            int i = 0,res = 0;
            while (p != null) {
                ++i;
                if (0 == random.nextInt(i)) { // 生成一个 [0, i) 之间的整数, 这个整数等于 0 的概率就是 1/i
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
