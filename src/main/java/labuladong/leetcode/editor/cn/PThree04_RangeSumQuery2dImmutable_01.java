/**
 * <p>Given a 2D matrix <code>matrix</code>, handle multiple queries of the following type:</p>
 *
 * <ul>
 * <li>Calculate the <strong>sum</strong> of the elements of <code>matrix</code> inside the rectangle defined by its <strong>upper left corner</strong> <code>(row1, col1)</code> and <strong>lower right corner</strong> <code>(row2, col2)</code>.</li>
 * </ul>
 *
 * <p>Implement the <code>NumMatrix</code> class:</p>
 *
 * <ul>
 * <li><code>NumMatrix(int[][] matrix)</code> Initializes the object with the integer matrix <code>matrix</code>.</li>
 * <li><code>int sumRegion(int row1, int col1, int row2, int col2)</code> Returns the <strong>sum</strong> of the elements of <code>matrix</code> inside the rectangle defined by its <strong>upper left corner</strong> <code>(row1, col1)</code> and <strong>lower right corner</strong> <code>(row2, col2)</code>.</li>
 * </ul>
 *
 * <p>You must design an algorithm where <code>sumRegion</code> works on <code>O(1)</code> time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/sum-grid.jpg" style="width: 415px; height: 415px;" />
 * <pre>
 * <strong>Input</strong>
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 * <strong>Output</strong>
 * [null, 8, 11, 12]
 * </pre>
 *
 * <strong>Explanation</strong>
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == matrix.length</code></li>
 * <li><code>n == matrix[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 200</code></li>
 * <li><code>-10<sup>4</sup> &lt;= matrix[i][j] &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= row1 &lt;= row2 &lt; m</code></li>
 * <li><code>0 &lt;= col1 &lt;= col2 &lt; n</code></li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>sumRegion</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 矩阵 | 前缀和</details><br>
 *
 * <div>👍 512, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Range Sum Query 2D - Immutable
 *
 * @author DY
 * @date 2023-08-11 15:57:23
 */
public class PThree04_RangeSumQuery2dImmutable_01 {
    public static void main(String[] args) {
        //测试代码
        NumMatrix solution = new PThree04_RangeSumQuery2dImmutable_01().new NumMatrix(null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private final int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m + 1][n + 1]; // 计算原点(0,0)到所有位置(i-1,j-1)的元素和
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) { //（i,j）位置的前置和等于上一行的前缀和+前一列的前缀和+当前位置的元素-左上角位置的前缀和，因为加重复了
                    //其实也可以简单的理解为和下面方法中求[row1,col1,row2,col2]的前缀和一样，通过相邻的几个矩阵相加减来求
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int x1, int y1, int x2, int y2) { // 因为我们的presum前缀和数组整体右移和下移了一位，所以presum[i][j]其实求的前置和不包括(i,j)的
            return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
