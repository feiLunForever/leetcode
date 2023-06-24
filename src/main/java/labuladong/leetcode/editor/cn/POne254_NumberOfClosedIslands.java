/**
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4-
 * directionally connected group of 0s and a closed island is an island totally (
 * all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,
 * 1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (
 * group of 1s).
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * <p>
 * <p>
 * Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * <p>
 * 👍 248, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Number of Closed Islands
 *
 * @author DY
 * @date 2023-06-24 15:32:56
 */
public class POne254_NumberOfClosedIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne254_NumberOfClosedIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < n; i++) {
                dfs(grid, 0, i); // 把靠上边的岛屿淹掉
                dfs(grid, m - 1, i); // 把靠上边的岛屿淹掉
            }
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0); // 把靠左边的岛屿淹掉
                dfs(grid, i, n - 1); // 把靠右边的岛屿淹掉
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        ++res;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) return;
            if (grid[i][j] == 1) return;
            grid[i][j] = 1;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
