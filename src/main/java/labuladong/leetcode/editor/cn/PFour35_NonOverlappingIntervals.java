/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-
 * overlapping.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-
 * overlapping.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= intervals.length <= 10⁵
 * intervals[i].length == 2
 * -5 * 10⁴ <= starti < endi <= 5 * 10⁴
 * <p>
 * <p>
 * Related Topics贪心 | 数组 | 动态规划 | 排序
 * <p>
 * 👍 990, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.sql.Array;
import java.util.Arrays;

/**
 * Non-overlapping Intervals
 *
 * @author DY
 * @date 2023-06-23 21:24:55
 */
public class PFour35_NonOverlappingIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour35_NonOverlappingIntervals().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            if (n == 0) return 0;
            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int count = 1;
            int end = intervals[0][1]; // 第一个区间的结束时间
            for (int i = 1; i < n; i++) {
                int start = intervals[i][0];
                if (start >= end) {
                    count++;
                    end = intervals[i][1];
                }
            }
            return n - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
