/**
 * <p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>
 *
 * <p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>
 *
 * <p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * <strong>Output:</strong> [10,55,45,25,25]
 * <strong>Explanation:</strong>
 * Flight labels:        1   2   3   4   5
 * Booking 1 reserved:  10  10
 * Booking 2 reserved:      20  20
 * Booking 3 reserved:      25  25  25  25
 * Total seats:         10  55  45  25  25
 * Hence, answer = [10,55,45,25,25]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
 * <strong>Output:</strong> [10,25]
 * <strong>Explanation:</strong>
 * Flight labels:        1   2
 * Booking 1 reserved:  10  10
 * Booking 2 reserved:      15
 * Total seats:         10  25
 * Hence, answer = [10,25]
 *
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>bookings[i].length == 3</code></li>
 * <li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li>
 * <li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 475, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Corporate Flight Bookings
 *
 * @author DY
 * @date 2023-08-13 15:51:32
 */
public class POne109_CorporateFlightBookings_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne109_CorporateFlightBookings_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Diff {
            private final int[] diff;

            public Diff(int[] nums) {
                diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            public void increment(int i, int j, int value) {
                diff[i] += value;
                if (j + 1 < diff.length) {
                    diff[j + 1] -= value;
                }
            }

            public int[] result() {
                int[] res = new int[diff.length];
                res[0] = diff[0];
                for (int i = 1; i < diff.length; i++) {
                    res[i] = res[i - 1] + diff[i];
                }
                return res;
            }
        }

        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] nums = new int[n];
            Diff diff = new Diff(nums);
            for (int[] booking : bookings) {
                int i = booking[0] - 1;
                int j = booking[1] - 1;
                int value = booking[2];
                diff.increment(i, j, value);
            }
            return diff.result();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
