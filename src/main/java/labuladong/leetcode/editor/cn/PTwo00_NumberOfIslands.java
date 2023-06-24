/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0
 * 's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * <p>
 * <p>
 * Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * <p>
 * 👍 2208, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Number of Islands
 *
 * @author DY
 * @date 2023-06-24 15:24:16
 */
public class PTwo00_NumberOfIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo00_NumberOfIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') { // 如果发现岛屿，则数量+1
                        ++res;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i >= m || i < 0 || j >= n || j < 0) return;
            if (grid[i][j] == '0') return;
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
