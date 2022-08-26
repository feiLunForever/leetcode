//<p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;" />
//<pre>
//<strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//<strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>m == matrix.length</code></li>
//	<li><code>n == matrix[i].length</code></li>
//	<li><code>1 &lt;= m, n &lt;= 10</code></li>
//	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>
//
//<div>👍 1191, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * @author DY
 * @date 2022-08-26 16:14:49
 */
public class P54_SpiralMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P54_SpiralMatrix().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new LinkedList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return res;
            circle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, res);
            return res;
        }

        private void circle(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> res) {
            if (x1 > x2 || y1 > y2) return;
            if (x1 == x2) { // 只剩下 y1 --> y2
                for (int i = y1; i <= y2; i++) {
                    res.add(matrix[x1][i]);
                }
                return;
            }
            if (y1 == y2) { // 只剩下 x1 --> x2
                for (int i = x1; i <= x2; i++) {
                    res.add(matrix[i][y1]);
                }
                return;
            }
            // 按照 右 --> 下 --> 左 --> 上 的顺序遍历
            for (int i = y1; i < y2; i++) res.add(matrix[x1][i]);
            for (int i = x1; i < x2; i++) res.add(matrix[i][y2]);
            for (int i = y2; i > y1; i--) res.add(matrix[x2][i]);
            for (int i = x2; i > x1; i--) res.add(matrix[i][y1]);

            circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res); // 缩小圈
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}