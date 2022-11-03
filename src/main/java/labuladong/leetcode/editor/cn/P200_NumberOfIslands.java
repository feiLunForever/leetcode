//<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>'1'</code>s (land) and <code>'0'</code>s (water), return <em>the number of islands</em>.</p>
//
//<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//<strong>Output:</strong> 1
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//<strong>Output:</strong> 3
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>m == grid.length</code></li> 
// <li><code>n == grid[i].length</code></li> 
// <li><code>1 &lt;= m, n &lt;= 300</code></li> 
// <li><code>grid[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>
//
//<div>👍 1970, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Number of Islands
 *
 * @author DY
 * @date 2022-11-03 20:46:36
 */
public class P200_NumberOfIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P200_NumberOfIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
                return;
            if (grid[i][j] == '0')
                return;
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}