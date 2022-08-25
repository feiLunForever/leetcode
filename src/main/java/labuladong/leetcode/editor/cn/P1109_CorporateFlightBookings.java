//<p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>
//
//<p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>
//
//<p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//<strong>Output:</strong> [10,55,45,25,25]
//<strong>Explanation:</strong>
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
//<strong>Output:</strong> [10,25]
//<strong>Explanation:</strong>
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
//	<li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li>
//	<li><code>bookings[i].length == 3</code></li>
//	<li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li>
//	<li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
//
//<div>👍 396, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Corporate Flight Bookings
 *
 * @author DY
 * @date 2022-08-25 18:09:55
 */
public class P1109_CorporateFlightBookings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1109_CorporateFlightBookings().new Solution();
        solution.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] corpFlightBookings(int[][] bookings, int n) {
            Difference difference = new Difference(new int[n]);
            for (int[] booking : bookings) {
                difference.adjust(booking[0] - 1, booking[1] - 1, booking[2]);
            }
            return difference.result();
        }

        class Difference {
            private int[] diff;

            public Difference(int[] nums) {
                diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            public void adjust(int i, int j, int value) { //[i, j]上加上value值
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

    }
//leetcode submit region end(Prohibit modification and deletion)

}