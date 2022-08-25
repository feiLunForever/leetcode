//<p>Given a 2D matrix <code>matrix</code>, handle multiple queries of the following type:</p>
//
//<ul>
//	<li>Calculate the <strong>sum</strong> of the elements of <code>matrix</code> inside the rectangle defined by its <strong>upper left corner</strong> <code>(row1, col1)</code> and <strong>lower right corner</strong> <code>(row2, col2)</code>.</li>
//</ul>
//
//<p>Implement the <code>NumMatrix</code> class:</p>
//
//<ul>
//	<li><code>NumMatrix(int[][] matrix)</code> Initializes the object with the integer matrix <code>matrix</code>.</li>
//	<li><code>int sumRegion(int row1, int col1, int row2, int col2)</code> Returns the <strong>sum</strong> of the elements of <code>matrix</code> inside the rectangle defined by its <strong>upper left corner</strong> <code>(row1, col1)</code> and <strong>lower right corner</strong> <code>(row2, col2)</code>.</li>
//</ul>
//
//<p>You must design an algorithm where <code>sumRegion</code> works on <code>O(1)</code> time complexity.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/sum-grid.jpg" style="width: 415px; height: 415px;" />
//<pre>
//<strong>Input</strong>
//[&quot;NumMatrix&quot;, &quot;sumRegion&quot;, &quot;sumRegion&quot;, &quot;sumRegion&quot;]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
//<strong>Output</strong>
//[null, 8, 11, 12]
//
//<strong>Explanation</strong>
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>m == matrix.length</code></li>
//	<li><code>n == matrix[i].length</code></li>
//	<li><code>1 &lt;= m, n &lt;= 200</code></li>
//	<li><code>-10<sup>4</sup> &lt;= matrix[i][j] &lt;= 10<sup>4</sup></code></li>
//	<li><code>0 &lt;= row1 &lt;= row2 &lt; m</code></li>
//	<li><code>0 &lt;= col1 &lt;= col2 &lt; n</code></li>
//	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>sumRegion</code>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 矩阵 | 前缀和</details><br>
//
//<div>👍 428, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Range Sum Query 2D - Immutable
 *
 * @author DY
 * @date 2022-08-25 16:48:11
 */
public class P304_RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        //测试代码
        System.out.println(new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}).sumRegion(2, 1, 4, 3));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    static class NumMatrix {

        private int[][] preSum; // [0, 0, i-1, j-1]

        public NumMatrix(int[][] matrix) {
            preSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}