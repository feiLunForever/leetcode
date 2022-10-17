//<p>Given an <code>n x n</code> array of integers <code>matrix</code>, return <em>the <strong>minimum sum</strong> of any <strong>falling path</strong> through</em> <code>matrix</code>.</p>
//
//<p>A <strong>falling path</strong> starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position <code>(row, col)</code> will be <code>(row + 1, col - 1)</code>, <code>(row + 1, col)</code>, or <code>(row + 1, col + 1)</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing1-grid.jpg" style="width: 499px; height: 500px;" /> 
//<pre>
//<strong>Input:</strong> matrix = [[2,1,3],[6,5,4],[7,8,9]]
//<strong>Output:</strong> 13
//<strong>Explanation:</strong> There are two falling paths with a minimum sum as shown.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing2-grid.jpg" style="width: 164px; height: 365px;" /> 
//<pre>
//<strong>Input:</strong> matrix = [[-19,57],[-40,-5]]
//<strong>Output:</strong> -59
//<strong>Explanation:</strong> The falling path with a minimum sum is shown.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == matrix.length == matrix[i].length</code></li> 
// <li><code>1 &lt;= n &lt;= 100</code></li> 
// <li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>
//
//<div>👍 197, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Minimum Falling Path Sum
 *
 * @author DY
 * @date 2022-10-15 18:09:06
 */
public class P931_MinimumFallingPathSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P931_MinimumFallingPathSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int res = Integer.MAX_VALUE;
            int n = matrix.length;
            int[][] cache = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cache[i], Integer.MAX_VALUE);
            }
            for (int j = 0; j < n; j++) {
                res = Math.min(res, dp(matrix, n - 1, j, cache));
            }
            return res;
        }

        private int dp(int[][] matrix, int i, int j, int[][] cache) {
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
                return 999999;
            }
            if (i == 0) {
                return matrix[0][j];
            }
            if (cache[i][j] != Integer.MAX_VALUE) {
                return cache[i][j];
            }
            cache[i][j] = matrix[i][j] + Math.min(Math.min(dp(matrix, i - 1, j, cache),
                    dp(matrix, i - 1, j - 1, cache)), dp(matrix, i - 1, j + 1, cache));
            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}