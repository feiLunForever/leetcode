/**
 * <p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>
 *
 * <p>Return <em>the fewest number of coins that you need to make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>-1</code>.</p>
 *
 * <p>You may assume that you have an infinite number of each kind of coin.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> coins = [1,2,5], amount = 11
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 11 = 5 + 5 + 1
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> coins = [2], amount = 3
 * <strong>Output:</strong> -1
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> coins = [1], amount = 0
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= coins.length &lt;= 12</code></li>
 * <li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * <li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 动态规划</details><br>
 *
 * <div>👍 2486, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Coin Change
 *
 * @author DY
 * @date 2023-07-23 16:34:49
 */
public class PThree22_CoinChange_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree22_CoinChange_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }

        public int coinChange1(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -666);
            return dp(coins, amount, memo);
        }

        private int dp(int[] coins, int amount, int[] memo) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            if (memo[amount] != -666) return memo[amount];

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = dp(coins, amount - coin, memo);
                if (subProblem == -1) continue;
                res = Math.min(res, subProblem + 1);
            }

            memo[amount] = res == Integer.MAX_VALUE ? -1 : res;

            return memo[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
