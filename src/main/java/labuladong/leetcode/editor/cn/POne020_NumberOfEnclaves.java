/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
 * represents a land cell.
 * <p>
 * A move consists of walking from one land cell to another adjacent (4-
 * directionally) land cell or walking off the boundary of the grid.
 * <p>
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not
 * enclosed because its on the boundary.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 * <p>
 * <p>
 * Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * <p>
 * 👍 217, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Number of Enclaves
 *
 * @author DY
 * @date 2023-06-24 15:41:12
 */
public class POne020_NumberOfEnclaves {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne020_NumberOfEnclaves().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < n; i++) {
                dfs(grid, 0, i);
                dfs(grid, m - 1, i);
            }
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res += 1;
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) return;
            if (grid[i][j] == 0) return;
            grid[i][j] = 0;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
