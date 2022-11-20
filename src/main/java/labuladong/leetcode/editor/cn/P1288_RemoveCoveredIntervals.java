//<p>Given an array <code>intervals</code> where <code>intervals[i] = [l<sub>i</sub>, r<sub>i</sub>]</code> represent the interval <code>[l<sub>i</sub>, r<sub>i</sub>)</code>, remove all intervals that are covered by another interval in the list.</p>
//
//<p>The interval <code>[a, b)</code> is covered by the interval <code>[c, d)</code> if and only if <code>c &lt;= a</code> and <code>b &lt;= d</code>.</p>
//
//<p>Return <em>the number of remaining intervals</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,4],[3,6],[2,8]]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> Interval [3,6] is covered by [2,8], therefore it is removed.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,4],[2,3]]
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= intervals.length &lt;= 1000</code></li> 
// <li><code>intervals[i].length == 2</code></li> 
// <li><code>0 &lt;= l<sub>i</sub> &lt; r<sub>i</sub> &lt;= 10<sup>5</sup></code></li> 
// <li>All the given intervals are <strong>unique</strong>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>
//
//<div>👍 86, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Remove Covered Intervals
 *
 * @author DY
 * @date 2022-11-20 15:52:13
 */
public class P1288_RemoveCoveredIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1288_RemoveCoveredIntervals().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });
            int left = intervals[0][0];
            int right = intervals[0][1];
            int res = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (left <= interval[0] && right >= interval[1]) { // 情况一，找到覆盖区间
                    ++res;
                } else if (right >= interval[0] && right <= interval[1]) { // 情况二，找到相交区间，合并
                    right = interval[1];
                } else { // 情况三，完全不相交，更新起点和终点
                    left = interval[0];
                    right = interval[1];
                }
            }
            return intervals.length - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}