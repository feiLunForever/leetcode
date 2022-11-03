//<p>You are given an <code>m x n</code> binary matrix <code>grid</code>, where <code>0</code> represents a sea cell and <code>1</code> represents a land cell.</p>
//
//<p>A <strong>move</strong> consists of walking from one land cell to another adjacent (<strong>4-directionally</strong>) land cell or walking off the boundary of the <code>grid</code>.</p>
//
//<p>Return <em>the number of land cells in</em> <code>grid</code> <em>for which we cannot walk off the boundary of the grid in any number of <strong>moves</strong></em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves1.jpg" style="width: 333px; height: 333px;" /> 
//<pre>
//<strong>Input:</strong> grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves2.jpg" style="width: 333px; height: 333px;" /> 
//<pre>
//<strong>Input:</strong> grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> All 1s are either on the boundary or can reach the boundary.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>m == grid.length</code></li> 
// <li><code>n == grid[i].length</code></li> 
// <li><code>1 &lt;= m, n &lt;= 500</code></li> 
// <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>
//
//<div>👍 189, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Number of Enclaves
 *
 * @author DY
 * @date 2022-11-03 22:19:24
 */
public class P1020_NumberOfEnclaves {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1020_NumberOfEnclaves().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            for (int i = 0; i < n; i++) {
                dfs(grid, 0, i);
                dfs(grid, m - 1, i);
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}