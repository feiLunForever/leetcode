/**
 * <p>You are given two lists of closed intervals, <code>firstList</code> and <code>secondList</code>, where <code>firstList[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> and <code>secondList[j] = [start<sub>j</sub>, end<sub>j</sub>]</code>. Each list of intervals is pairwise <strong>disjoint</strong> and in <strong>sorted order</strong>.</p>
 *
 * <p>Return <em>the intersection of these two interval lists</em>.</p>
 *
 * <p>A <strong>closed interval</strong> <code>[a, b]</code> (with <code>a &lt;= b</code>) denotes the set of real numbers <code>x</code> with <code>a &lt;= x &lt;= b</code>.</p>
 *
 * <p>The <strong>intersection</strong> of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of <code>[1, 3]</code> and <code>[2, 4]</code> is <code>[2, 3]</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/interval1.png" style="width: 700px; height: 194px;" />
 * <pre>
 * <strong>Input:</strong> firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * <strong>Output:</strong> [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> firstList = [[1,3],[5,9]], secondList = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= firstList.length, secondList.length &lt;= 1000</code></li>
 * <li><code>firstList.length + secondList.length &gt;= 1</code></li>
 * <li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
 * <li><code>end<sub>i</sub> &lt; start<sub>i+1</sub></code></li>
 * <li><code>0 &lt;= start<sub>j</sub> &lt; end<sub>j</sub> &lt;= 10<sup>9</sup> </code></li>
 * <li><code>end<sub>j</sub> &lt; start<sub>j+1</sub></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
 *
 * <div>👍 385, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Interval List Intersections
 *
 * @author DY
 * @date 2023-06-27 18:04:45
 */
public class PNine86_IntervalListIntersections {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine86_IntervalListIntersections().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int i = 0, j = 0;
            List<int[]> res = new ArrayList<>();
            while (i < firstList.length && j < secondList.length) {
                int a1 = firstList[i][0], a2 = firstList[i][1];
                int b1 = secondList[j][0], b2 = secondList[j][1];
                if (!(a2 < b1 || a1 > b2)) {
                    res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
                }
                if (a2 < b2) {
                    ++i;
                } else {
                    ++j;
                }
            }
            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
