//<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
//<strong>Output:</strong> [[1,6],[8,10],[15,18]]
//<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> intervals = [[1,4],[4,5]]
//<strong>Output:</strong> [[1,5]]
//<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>intervals[i].length == 2</code></li> 
// <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>
//
//<div>👍 1716, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Merge Intervals
 *
 * @author DY
 * @date 2022-11-20 16:07:17
 */
public class P56_MergeIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P56_MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            LinkedList<int[]> res = new LinkedList<>();
            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                int[] last = res.getLast();
                if (last[1] >= cur[0]) { // 此区间内，更新右边界
                    last[1] = Math.max(last[1], cur[1]);
                } else { // 处理下一个区间
                    res.add(cur);
                }
            }
            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}