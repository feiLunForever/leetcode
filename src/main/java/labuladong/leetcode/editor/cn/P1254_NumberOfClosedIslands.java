//<p>Given a 2D&nbsp;<code>grid</code> consists of <code>0s</code> (land)&nbsp;and <code>1s</code> (water).&nbsp; An <em>island</em> is a maximal 4-directionally connected group of <code><font face="monospace">0</font>s</code> and a <em>closed island</em>&nbsp;is an island <strong>totally</strong>&nbsp;(all left, top, right, bottom) surrounded by <code>1s.</code></p>
//
//<p>Return the number of <em>closed islands</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="width: 240px; height: 120px;" /></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> 
//Islands in gray are closed because they are completely surrounded by water (group of 1s).</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png" style="width: 160px; height: 80px;" /></p>
//
//<pre>
//<strong>Input:</strong> grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//<strong>Output:</strong> 1
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [[1,1,1,1,1,1,1],
//&nbsp;              [1,0,0,0,0,0,1],
//&nbsp;              [1,0,1,1,1,0,1],
//&nbsp;              [1,0,1,0,1,0,1],
//&nbsp;              [1,0,1,1,1,0,1],
//&nbsp;              [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
//<strong>Output:</strong> 2
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li> 
// <li><code>0 &lt;= grid[i][j] &lt;=1</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>
//
//<div>👍 165, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Number of Closed Islands
 *
 * @author DY
 * @date 2022-11-03 22:03:47
 */
public class P1254_NumberOfClosedIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1254_NumberOfClosedIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
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
                    if (grid[i][j] == 0) {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }
            grid[i][j] = 1;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}