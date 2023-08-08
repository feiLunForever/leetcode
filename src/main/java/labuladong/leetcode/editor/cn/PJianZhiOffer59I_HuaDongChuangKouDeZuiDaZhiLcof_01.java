/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>队列 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>
 *
 * <div>👍 632, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值 LCOF
 *
 * @author DY
 * @date 2023-08-08 15:53:53
 */
public class PJianZhiOffer59I_HuaDongChuangKouDeZuiDaZhiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer59I_HuaDongChuangKouDeZuiDaZhiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
		class MonotonicQueue {

			private final LinkedList<Integer> queue;

			MonotonicQueue(int capacity) {
				this.queue = new LinkedList<>();
			}

			public void put(int value) {
				while (!queue.isEmpty() && queue.getLast() < value) {
					queue.removeLast();
				}
				queue.addLast(value);
			}

			public int max() {
				return queue.getFirst();
			}

			public void remove(int value) {
				if (value == queue.getFirst()) {
					queue.removeFirst();
				}
			}
		}

        public int[] maxSlidingWindow(int[] nums, int k) {
			MonotonicQueue window = new MonotonicQueue(k);
			int[] res = new int[nums.length - k + 1];
			int i = 0, j = 0;
			for (; i < k - 1; i++) {
				window.put(nums[i]);
			}
			for (; i < nums.length; i++) {
				window.put(nums[i]);
				res[j++] = window.max();
				window.remove(nums[i - k + 1]);
			}
			return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
