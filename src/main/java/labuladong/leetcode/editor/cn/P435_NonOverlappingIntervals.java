//<p>Given an array of intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, return <em>the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,2],[2,3],[3,4],[1,3]]
//<strong>Output:</strong> 1
//<strong>Explanation:</strong> [1,3] can be removed and the rest of the intervals are non-overlapping.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,2],[1,2],[1,2]]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> You need to remove two [1,2] to make the rest of the intervals non-overlapping.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,2],[2,3]]
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> You don't need to remove any of the intervals since they're already non-overlapping.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= intervals.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>intervals[i].length == 2</code></li> 
// <li><code>-5 * 10<sup>4</sup> &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 5 * 10<sup>4</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划 | 排序</details><br>
//
//<div>👍 826, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 *
 * @author DY
 * @date 2022-11-02 14:09:38
 */
public class P435_NonOverlappingIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P435_NonOverlappingIntervals().new Solution();
		System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 3}, {2, 4}, {3, 6}}));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
        	int n = intervals.length;
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int count = 1;
            int lastEnd = intervals[0][1];
            for (int i = 1; i < n; i++) {
                int start = intervals[i][0];
                if (start >= lastEnd) {
                    count++;
                    lastEnd = intervals[i][1];
                }
            }
            return n - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}