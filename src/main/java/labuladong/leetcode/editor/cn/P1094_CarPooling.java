//<p>There is a car with <code>capacity</code> empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).</p>
//
//<p>You are given the integer <code>capacity</code> and an array <code>trips</code> where <code>trips[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code> indicates that the <code>i<sup>th</sup></code> trip has <code>numPassengers<sub>i</sub></code> passengers and the locations to pick them up and drop them off are <code>from<sub>i</sub></code> and <code>to<sub>i</sub></code> respectively. The locations are given as the number of kilometers due east from the car&#39;s initial location.</p>
//
//<p>Return <code>true</code><em> if it is possible to pick up and drop off all passengers for all the given trips, or </em><code>false</code><em> otherwise</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 4
//<strong>Output:</strong> false
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 5
//<strong>Output:</strong> true
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= trips.length &lt;= 1000</code></li>
//	<li><code>trips[i].length == 3</code></li>
//	<li><code>1 &lt;= numPassengers<sub>i</sub> &lt;= 100</code></li>
//	<li><code>0 &lt;= from<sub>i</sub> &lt; to<sub>i</sub> &lt;= 1000</code></li>
//	<li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列）</details><br>
//
//<div>👍 200, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Car Pooling
 *
 * @author DY
 * @date 2022-08-25 19:13:03
 */
public class P1094_CarPooling {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1094_CarPooling().new Solution();
        System.out.println(solution.carPooling(new int[][]{{9, 0, 1}, {3, 3, 7}}, 4));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            Difference difference = new Difference(new int[1001]);
            for (int[] trip : trips) {
                // 乘客数量
                int val = trip[0];
                // 第 trip[1] 站乘客上车
                int i = trip[1];
                // 第 trip[2] 站乘客已经下车，
                // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
                int j = trip[2] - 1;
                difference.adjust(i, j, val);
            }
            return difference.check(capacity);
        }

        class Difference {
            private int[] diff;

            public Difference(int[] array) {
                diff = new int[array.length];
                diff[0] = array[0];
                for (int i = 1; i < array.length; i++) {
                    diff[i] = array[i] - array[i - 1];
                }
            }

            public void adjust(int i, int j, int value) {
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

            public boolean check(int capacity) {
                int[] res = new int[diff.length];
                res[0] = diff[0];
                if (res[0] > capacity) return false;
                for (int i = 1; i < diff.length; i++) {
                    res[i] = res[i - 1] + diff[i];
                    if (res[i] > capacity) return false;
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}