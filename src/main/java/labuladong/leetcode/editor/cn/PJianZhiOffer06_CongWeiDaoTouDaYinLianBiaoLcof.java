/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>
 *
 * <div>👍 383, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import org.example.剑指Offer.ListNode;

import java.util.LinkedList;

/**
 * 从尾到头打印链表 LCOF
 *
 * @author DY
 * @date 2023-03-01 17:29:08
 */
public class PJianZhiOffer06_CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer06_CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		node1.next = node3;
		node3.next = node2;
        solution.reversePrint(node1);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<>();
            while (head != null) {
                stack.offer(head.val);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.removeLast();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}