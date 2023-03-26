/**
 * <p>A conveyor belt has packages that must be shipped from one port to another within <code>days</code> days.</p>
 *
 * <p>The <code>i<sup>th</sup></code> package on the conveyor belt has a weight of <code>weights[i]</code>. Each day, we load the ship with packages on the conveyor belt (in the order given by <code>weights</code>). We may not load more weight than the maximum weight capacity of the ship.</p>
 *
 * <p>Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within <code>days</code> days.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * <strong>Output:</strong> 15
 * <strong>Explanation:</strong> A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> weights = [3,2,2,4,1,4], days = 3
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> weights = [1,2,3,1,1], days = 4
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong>
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= weights[i] &lt;= 500</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 527, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Capacity To Ship Packages Within D Days
 *
 * @author DY
 * @date 2023-03-26 17:28:40
 */
public class POne011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne011_CapacityToShipPackagesWithinDDays().new Solution();
		System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int l = 0, r = 0;
            for (int weight : weights) {
                l = Math.max(l, weight);
                r += weight;
            }
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int cost = cal(weights, mid);
                if (cost > days) { // 花费时间长
                    l = mid + 1;
                } else if (cost < days) { // 花费时间短，缩短左边界
                    r = mid - 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }

        private int cal(int[] weights, int w) {
            int cost = 0;
            for (int i = 0; i < weights.length;) {
                int cap = w;
                while (i < weights.length && cap >= weights[i]) {
                    cap -= weights[i];
                    ++i;
                }
                ++cost;
            }
            return cost;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
