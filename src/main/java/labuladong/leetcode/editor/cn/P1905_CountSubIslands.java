//<p>You are given two <code>m x n</code> binary matrices <code>grid1</code> and <code>grid2</code> containing only <code>0</code>'s (representing water) and <code>1</code>'s (representing land). An <strong>island</strong> is a group of <code>1</code>'s connected <strong>4-directionally</strong> (horizontal or vertical). Any cells outside of the grid are considered water cells.</p>
//
//<p>An island in <code>grid2</code> is considered a <strong>sub-island </strong>if there is an island in <code>grid1</code> that contains <strong>all</strong> the cells that make up <strong>this</strong> island in <code>grid2</code>.</p>
//
//<p>Return the <em><strong>number</strong> of islands in </em><code>grid2</code> <em>that are considered <strong>sub-islands</strong></em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/test1.png" style="width: 493px; height: 205px;" /> 
//<pre>
//<strong>Input:</strong> grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//<strong>Output:</strong> 3
//<strong>Explanation: </strong>In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
//The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/06/03/testcasex2.png" style="width: 491px; height: 201px;" /> 
//<pre>
//<strong>Input:</strong> grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
//<strong>Output:</strong> 2 
//<strong>Explanation: </strong>In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
//The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>m == grid1.length == grid2.length</code></li> 
// <li><code>n == grid1[i].length == grid2[i].length</code></li> 
// <li><code>1 &lt;= m, n &lt;= 500</code></li> 
// <li><code>grid1[i][j]</code> and <code>grid2[i][j]</code> are either <code>0</code> or <code>1</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>
//
//<div>👍 83, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Count Sub Islands
 *
 * @author DY
 * @date 2022-11-04 12:42:58
 */
public class P1905_CountSubIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1905_CountSubIslands().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid1.length, n = grid1[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                        dfs(grid2, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        count++;
                        dfs(grid2, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid2, int i, int j) {
            if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length) {
                return;
            }
            if (grid2[i][j] == 0) {
                return;
            }
            grid2[i][j] = 0;
            dfs(grid2, i - 1, j);
            dfs(grid2, i + 1, j);
            dfs(grid2, i, j - 1);
            dfs(grid2, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}