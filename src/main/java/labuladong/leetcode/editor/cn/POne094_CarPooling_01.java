/**
 * <p>There is a car with <code>capacity</code> empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).</p>
 *
 * <p>You are given the integer <code>capacity</code> and an array <code>trips</code> where <code>trips[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code> indicates that the <code>i<sup>th</sup></code> trip has <code>numPassengers<sub>i</sub></code> passengers and the locations to pick them up and drop them off are <code>from<sub>i</sub></code> and <code>to<sub>i</sub></code> respectively. The locations are given as the number of kilometers due east from the car's initial location.</p>
 *
 * <p>Return <code>true</code><em> if it is possible to pick up and drop off all passengers for all the given trips, or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 4
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 5
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= trips.length &lt;= 1000</code></li>
 * <li><code>trips[i].length == 3</code></li>
 * <li><code>1 &lt;= numPassengers<sub>i</sub> &lt;= 100</code></li>
 * <li><code>0 &lt;= from<sub>i</sub> &lt; to<sub>i</sub> &lt;= 1000</code></li>
 * <li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列）</details><br>
 *
 * <div>👍 268, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Car Pooling
 *
 * @author DY
 * @date 2023-08-13 16:09:00
 */
public class POne094_CarPooling_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne094_CarPooling_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Diff {
            private final int[] diff;

            public Diff(int[] nums) {
                this.diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            public void increment(int i, int j, int val) {
                diff[i] += val;
                if (j + 1 < diff.length) {
                    diff[j + 1] -= val;
                }
            }

            public boolean check(int target) {
                int pre = diff[0];
                if (pre > target) return false;
                for (int i = 1; i < diff.length; i++) {
                    pre += diff[i];
                    if (pre > target) return false;
                }
                return true;
            }
        }

        public boolean carPooling(int[][] trips, int capacity) {
            int[] nums = new int[1001];
            Diff diff = new Diff(nums);
            for (int[] trip : trips) {
                int val = trip[0];
                int i = trip[1];
                int j = trip[2] - 1;
                diff.increment(i, j, val);
            }
            return diff.check(capacity);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
