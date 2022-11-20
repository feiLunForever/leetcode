//<p>You are given two lists of closed intervals, <code>firstList</code> and <code>secondList</code>, where <code>firstList[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> and <code>secondList[j] = [start<sub>j</sub>, end<sub>j</sub>]</code>. Each list of intervals is pairwise <strong>disjoint</strong> and in <strong>sorted order</strong>.</p>
//
//<p>Return <em>the intersection of these two interval lists</em>.</p>
//
//<p>A <strong>closed interval</strong> <code>[a, b]</code> (with <code>a &lt;= b</code>) denotes the set of real numbers <code>x</code> with <code>a &lt;= x &lt;= b</code>.</p>
//
//<p>The <strong>intersection</strong> of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of <code>[1, 3]</code> and <code>[2, 4]</code> is <code>[2, 3]</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2019/01/30/interval1.png" style="width: 700px; height: 194px;" /> 
//<pre>
//<strong>Input:</strong> firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
//<strong>Output:</strong> [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> firstList = [[1,3],[5,9]], secondList = []
//<strong>Output:</strong> []
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= firstList.length, secondList.length &lt;= 1000</code></li> 
// <li><code>firstList.length + secondList.length &gt;= 1</code></li> 
// <li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>9</sup></code></li> 
// <li><code>end<sub>i</sub> &lt; start<sub>i+1</sub></code></li> 
// <li><code>0 &lt;= start<sub>j</sub> &lt; end<sub>j</sub> &lt;= 10<sup>9</sup> </code></li> 
// <li><code>end<sub>j</sub> &lt; start<sub>j+1</sub></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
//
//<div>👍 342, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Interval List Intersections
 *
 * @author DY
 * @date 2022-11-20 17:04:57
 */
public class P986_IntervalListIntersections {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P986_IntervalListIntersections().new Solution();
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
                if (!(a1 > b2 || a2 < b1)) { // 相交
                    res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
                }
                if (b2 < a2) {
                    ++j;
                } else {
                    ++i;
                }
            }
            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}