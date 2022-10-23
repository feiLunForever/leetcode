//<p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>
//
//<p><strong>Note:</strong> You can only move either down or right at any point in time.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" /> 
//<pre>
//<strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
//<strong>Output:</strong> 7
//<strong>Explanation:</strong> Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
//<strong>Output:</strong> 12
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>m == grid.length</code></li> 
// <li><code>n == grid[i].length</code></li> 
// <li><code>1 &lt;= m, n &lt;= 200</code></li> 
// <li><code>0 &lt;= grid[i][j] &lt;= 100</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>
//
//<div>👍 1377, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Minimum Path Sum
 *
 * @author DY
 * @date 2022-10-23 14:49:18
 */
public class P64_MinimumPathSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P64_MinimumPathSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return dp(grid, grid.length - 1, grid[0].length - 1, dp);
        }

        private int dp(int[][] grid, int i, int j, int[][] dp) {
            if (i == 0 && j == 0) return grid[0][0];
            if (i < 0 || j < 0) return Integer.MAX_VALUE;
            if (dp[i][j] != -1) return dp[i][j];
            dp[i][j] = Math.min(
                    dp(grid, i - 1, j, dp),
                    dp(grid, i, j - 1, dp)) + grid[i][j];
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}