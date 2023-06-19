/**
 * <p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>
 *
 * <p>Return <em>the number of combinations that make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>0</code>.</p>
 *
 * <p>You may assume that you have an infinite number of each kind of coin.</p>
 *
 * <p>The answer is <strong>guaranteed</strong> to fit into a signed <strong>32-bit</strong> integer.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> amount = 5, coins = [1,2,5]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> amount = 3, coins = [2]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> the amount of 3 cannot be made up just with coins of 2.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> amount = 10, coins = [10]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= coins.length &lt;= 300</code></li>
 * <li><code>1 &lt;= coins[i] &lt;= 5000</code></li>
 * <li>All the values of <code>coins</code> are <strong>unique</strong>.</li>
 * <li><code>0 &lt;= amount &lt;= 5000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
 *
 * <div>👍 1098, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Coin Change II
 *
 * @author DY
 * @date 2023-06-19 14:52:33
 */
public class PFive18_CoinChangeIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive18_CoinChangeIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1]; // 若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包
            // dp[0][...] = 0
            // dp[...][0] = 1
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1; // 容量为0，什么硬币都不放
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= amount; j++) {
                    if (j - coins[i - 1] < 0) { // 容量不够
                        dp[i][j] = dp[i - 1][j]; // 不放入当前硬币
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // 当前硬币放入或者不放入的方法次数都加上
                    }
                }
            }
            return dp[n][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
