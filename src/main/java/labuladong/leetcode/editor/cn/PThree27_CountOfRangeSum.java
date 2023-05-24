/**
 * <p>Given an integer array <code>nums</code> and two integers <code>lower</code> and <code>upper</code>, return <em>the number of range sums that lie in</em> <code>[lower, upper]</code> <em>inclusive</em>.</p>
 *
 * <p>Range sum <code>S(i, j)</code> is defined as the sum of the elements in <code>nums</code> between indices <code>i</code> and <code>j</code> inclusive, where <code>i &lt;= j</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-2,5,-1], lower = -2, upper = 2
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0], lower = 0, upper = 0
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * <li><code>-10<sup>5</sup> &lt;= lower &lt;= upper &lt;= 10<sup>5</sup></code></li>
 * <li>The answer is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树状数组 | 线段树 | 数组 | 二分查找 | 分治 | 有序集合 | 归并排序</details><br>
 *
 * <div>👍 539, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Count of Range Sum
 *
 * @author DY
 * @date 2023-05-24 21:41:48
 */
public class PThree27_CountOfRangeSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree27_CountOfRangeSum().new Solution();
        solution.countRangeSum(new int[]{-2,5,-1},-2,2);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private long[] temp;
        private int count;

        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] preSum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            temp = new long[preSum.length];
            sorts(preSum, 0, preSum.length - 1, lower, upper);
            return count;
        }

        private void sorts(long[] nums, int l, int r, int lower, int upper) {
            if (l == r) return;
            int mid = l + (r - l) / 2;
            sorts(nums, l, mid, lower, upper);
            sorts(nums, mid + 1, r, lower, upper);
            merge(nums, l, mid, r, lower, upper);
        }

        private void merge(long[] nums, int l, int mid, int r, int lower, int upper) {
            for (int i = l; i <= r; i++) {
                temp[i] = nums[i];
            }
            // 在合并有序数组之前加点私货（这段代码会超时）
            // for (int i = lo; i <= mid; i++) {
            //     for (int j = mid + 1; j <= hi; k++) {
            //         // 寻找符合条件的 nums[j]
            //         long delta = nums[j] - nums[i];
            //         if (delta <= upper && delta >= lower) {
            //             count++;
            //         }
            //     }
            // }
            int start = mid + 1, end = mid + 1;
            for (int i = l; i < mid + 1; i++) { // 维护左闭右开区间 [start, end) 中的元素和 nums[i] 的差在 [lower, upper] 中
                while (start < r + 1 && nums[start] - nums[i] < lower) {
                    ++start;
                }
                while (end < r + 1 && nums[end] - nums[i] <= upper) {
                    ++end;
                }
                count += end - start;
            }
            int i = l, j = mid + 1;
            for (int k = l; k < r + 1; k++) {
                if (i == mid + 1) {
                    nums[k] = temp[j++];
                } else if (j == r + 1) {
                    nums[k] = temp[i++];
                } else if (temp[i] <= temp[j]) {
                    nums[k] = temp[i++];
                } else {
                    nums[k] = temp[j++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
