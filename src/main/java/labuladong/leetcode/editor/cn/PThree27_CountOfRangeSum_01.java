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
 * <div>👍 570, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Count of Range Sum
 *
 * @author DY
 * @date 2023-11-29 10:07:48
 */
public class PThree27_CountOfRangeSum_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree27_CountOfRangeSum_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count;
        private long[] temp;
        private int lower, upper;

        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] preSum = new long[nums.length + 1];
            temp = new long[nums.length + 1];
            this.lower = lower;
            this.upper = upper;
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            sort(preSum, 0, preSum.length - 1);
            return count;
        }

        private void sort(long[] preSum, int lo, int hi) {
            if (lo == hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(preSum, lo, mid);
            sort(preSum, mid + 1, hi);
            merge(preSum, lo, mid, hi);
        }

        private void merge(long[] preSum, int lo, int mid, int hi) {
            for (int i = lo; i <= hi; i++) {
                temp[i] = preSum[i];
            }
            /*
            for (int i = lo; i <= mid; i++) {
                for (int j = mid + 1; j <= hi; j++) {
                    long delta = preSum[j] - preSum[i];
                    if (delta >= lower && delta <= upper) {
                        ++count;
                    }
                }
            }*/
            int start = mid + 1, end = mid + 1;
            for (int i = lo; i <= mid; i++) {
                while (start <= hi && preSum[start] - preSum[i] < lower) {
                    ++start;
                }
                while (end <= hi && preSum[end] - preSum[i] <= upper) {
                    ++end;
                }
                count += end - start;
            }

            int i = lo, j = mid + 1;
            for (int p = lo; p <= hi; p++) {
                if (i == mid + 1) {
                    preSum[p] = temp[j++];
                } else if (j == hi + 1) {
                    preSum[p] = temp[i++];
                } else if (temp[i] <= temp[j]) {
                    preSum[p] = temp[i++];
                } else {
                    preSum[p] = temp[j++];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
