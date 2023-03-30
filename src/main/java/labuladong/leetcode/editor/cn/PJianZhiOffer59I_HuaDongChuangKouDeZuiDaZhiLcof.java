/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>队列 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>
 *
 * <div>👍 559, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值 LCOF
 *
 * @author DY
 * @date 2023-03-30 18:45:32
 */
public class PJianZhiOffer59I_HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer59I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            LinkedList<Integer> queue = new LinkedList<>(); // 存放当前窗口的最大值小标（防止有多个最大值）
            int[] res = new int[len - k + 1]; // 窗口个数
            for (int right = 0; right < len; right++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) { // 队列中队尾元素 <= 当前值
                    queue.removeLast(); // 剔除掉，下一步就将当前值下标加入到队列中
                }
                queue.addLast(right); // 当前值下标加入到队列中
                int left = right - k + 1; // 窗口左边界
                if (left > queue.peekFirst()) { // 左边界失效
                    queue.removeFirst();
                }
                if (right + 1 >= k) { // 窗口已经形成
                    res[left] = nums[queue.peekFirst()];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
