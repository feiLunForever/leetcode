/**
 * <p>The demons had captured the princess and imprisoned her in <strong>the bottom-right corner</strong> of a <code>dungeon</code>. The <code>dungeon</code> consists of <code>m x n</code> rooms laid out in a 2D grid. Our valiant knight was initially positioned in <strong>the top-left room</strong> and must fight his way through <code>dungeon</code> to rescue the princess.</p>
 *
 * <p>The knight has an initial health point represented by a positive integer. If at any point his health point drops to <code>0</code> or below, he dies immediately.</p>
 *
 * <p>Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).</p>
 *
 * <p>To reach the princess as quickly as possible, the knight decides to move only <strong>rightward</strong> or <strong>downward</strong> in each step.</p>
 *
 * <p>Return <em>the knight's minimum initial health so that he can rescue the princess</em>.</p>
 *
 * <p><strong>Note</strong> that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/13/dungeon-grid-1.jpg" style="width: 253px; height: 253px;" />
 * <pre>
 * <strong>Input:</strong> dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-&gt; RIGHT -&gt; DOWN -&gt; DOWN.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> dungeon = [[0]]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == dungeon.length</code></li>
 * <li><code>n == dungeon[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 200</code></li>
 * <li><code>-1000 &lt;= dungeon[i][j] &lt;= 1000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>
 *
 * <div>👍 742, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Dungeon Game
 *
 * @author DY
 * @date 2023-06-20 15:25:17
 */
public class POne74_DungeonGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne74_DungeonGame().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length, n = dungeon[0].length;
            int[][] dp = new int[m][n]; // dp[i][j] -> dungeon[i][j] => dungeon[m-1][n-1] 最小生命值
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return dp(dungeon, 0, 0, dp);
        }

        private int dp(int[][] dungeon, int i, int j, int[][] dp) {
            int m = dungeon.length, n = dungeon[0].length;
            if (i == m - 1 && j == n - 1) return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
            if (i == m || j == n) return Integer.MAX_VALUE;
            if (dp[i][j] != -1) return dp[i][j];
            int res = Math.min(
                    dp(dungeon, i + 1, j, dp),
                    dp(dungeon, i, j + 1, dp)
            ) - dungeon[i][j];
			dp[i][j] = res <= 0 ? 1 : res; // 最少为1
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
