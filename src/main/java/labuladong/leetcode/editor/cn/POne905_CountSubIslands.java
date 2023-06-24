/**
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (
 * representing water) and 1's (representing land). An island is a group of 1's
 * connected 4-directionally (horizontal or vertical). Any cells outside of the grid are
 * considered water cells.
 * <p>
 * An island in grid2 is considered a sub-island if there is an island in grid1
 * that contains all the cells that make up this island in grid2.
 * <p>
 * Return the number of islands in grid2 that are considered sub-islands.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
 * grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid
 * on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island.
 * There are three sub-islands.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]],
 * grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * Output: 2
 * Explanation: In the picture above, the grid on the left is grid1 and the grid
 * on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island.
 * There are two sub-islands.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] and grid2[i][j] are either 0 or 1.
 * <p>
 * <p>
 * Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * <p>
 * 👍 100, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Count Sub Islands
 *
 * @author DY
 * @date 2023-06-24 16:09:33
 */
public class POne905_CountSubIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne905_CountSubIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid1.length, n = grid1[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) { // 肯定不是子岛屿
                        dfs(grid2, i, j);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        ++res;
                        dfs(grid2, i, j);
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
