/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (
 * representing land) connected 4-directionally (horizontal or vertical.) You may assume
 * all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,
 * 1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,
 * 0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-
 * directionally.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * <p>
 * <p>
 * Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * <p>
 * 👍 975, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Max Area of Island
 *
 * @author DY
 * @date 2023-06-24 15:50:41
 */
public class PSix95_MaxAreaOfIsland {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSix95_MaxAreaOfIsland().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) return 0;
            if (grid[i][j] == 0) return 0;
            grid[i][j] = 0;
            return dfs(grid, i - 1, j)
                    + dfs(grid, i + 1, j)
                    + dfs(grid, i, j - 1)
                    + dfs(grid, i, j + 1) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
