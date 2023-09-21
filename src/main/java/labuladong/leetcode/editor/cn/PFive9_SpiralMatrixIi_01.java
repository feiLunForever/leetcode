/**
 * <p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 20</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>
 *
 * <div>👍 1169, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Spiral Matrix II
 *
 * @author DY
 * @date 2023-09-21 18:43:53
 */
public class PFive9_SpiralMatrixIi_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive9_SpiralMatrixIi_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] rs = new int[n][n];
            circle(0, 0, n - 1, n - 1, 1, rs);
            return rs;
        }

        private void circle(int x1, int y1, int x2, int y2, int x, int[][] rs) {
            if (x1 > x2 || y1 > y2) return;
            if (x1 == x2) {
                for (int i = y1; i <= y2; i++) {
                    rs[x1][i] = x++;
                }
                return;
            }
            if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    rs[i][y1] = x++;
                }
                return;
            }
            for (int i = y1; i < y2; i++) rs[x1][i] = x++;
            for (int i = x1; i < x2; i++) rs[i][y2] = x++;
            for (int i = y2; i > y1; i--) rs[x2][i] = x++;
            for (int i = x2; i > y1; i--) rs[i][x1] = x++;

            circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1, x, rs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
