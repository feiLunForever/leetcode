//<p>There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array <code>points</code> where <code>points[i] = [x<sub>start</sub>, x<sub>end</sub>]</code> denotes a balloon whose <strong>horizontal diameter</strong> stretches between <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code>. You do not know the exact y-coordinates of the balloons.</p>
//
//<p>Arrows can be shot up <strong>directly vertically</strong> (in the positive y-direction) from different points along the x-axis. A balloon with <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code> is <strong>burst</strong> by an arrow shot at <code>x</code> if <code>x<sub>start</sub> &lt;= x &lt;= x<sub>end</sub></code>. There is <strong>no limit</strong> to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.</p>
//
//<p>Given the array <code>points</code>, return <em>the <strong>minimum</strong> number of arrows that must be shot to burst all balloons</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> points = [[10,16],[2,8],[1,6],[7,12]]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> points = [[1,2],[3,4],[5,6],[7,8]]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> One arrow needs to be shot for each balloon for a total of 4 arrows.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> points = [[1,2],[2,3],[3,4],[4,5]]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= points.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>points[i].length == 2</code></li> 
// <li><code>-2<sup>31</sup> &lt;= x<sub>start</sub> &lt; x<sub>end</sub> &lt;= 2<sup>31</sup> - 1</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 排序</details><br>
//
//<div>👍 679, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Minimum Number of Arrows to Burst Balloons
 *
 * @author DY
 * @date 2022-11-02 14:46:52
 */
public class P452_MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P452_MinimumNumberOfArrowsToBurstBalloons().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int n = points.length;
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
            int lastEnd = points[0][1];
            int count = 1;
            for (int i = 1; i < n; i++) {
                int start = points[i][0];
                if (start > lastEnd) {
                    count++;
                    lastEnd = points[i][1];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}