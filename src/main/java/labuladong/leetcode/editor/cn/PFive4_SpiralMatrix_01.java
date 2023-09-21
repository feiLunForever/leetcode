/**
 * <p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == matrix.length</code></li>
 * <li><code>n == matrix[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 10</code></li>
 * <li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>
 *
 * <div>👍 1492, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * @author DY
 * @date 2023-09-21 18:51:46
 */
public class PFive4_SpiralMatrix_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive4_SpiralMatrix_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> rs = new LinkedList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return rs;
            circle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, rs);
            return rs;
        }

        private void circle(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> rs) {
            if (x1 > x2 || y1 > y2) return;
            if (x1 == x2) {
                for (int i = y1; i <= y2; i++) {
                    rs.add(matrix[x1][i]);
                }
                return;
            }
            if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    rs.add(matrix[i][y1]);
                }
                return;
            }
            for (int i = y1; i < y2; i++) rs.add(matrix[x1][i]);
            for (int i = x1; i < x2; i++) rs.add(matrix[i][y2]);
            for (int i = y2; i > y1; i--) rs.add(matrix[x2][i]);
            for (int i = x2; i > x1; i--) rs.add(matrix[i][y1]);

            circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, rs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
