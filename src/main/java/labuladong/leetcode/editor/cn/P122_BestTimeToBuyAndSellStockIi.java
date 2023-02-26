//<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
//
//<p>On each day, you may decide to buy and/or sell the stock. You can only hold <strong>at most one</strong> share of the stock at any time. However, you can buy it then immediately sell it on the <strong>same day</strong>.</p>
//
//<p>Find and return <em>the <strong>maximum</strong> profit you can achieve</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [7,1,5,3,6,4]
//<strong>Output:</strong> 7
//<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Total profit is 4 + 3 = 7.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1,2,3,4,5]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Total profit is 4.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [7,6,4,3,1]
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
//	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>
//
//<div>👍 1800, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock II
 *
 * @author DY
 * @date 2022-08-16 14:54:53
 */
public class P122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0_0 = 0;
            int dp0_1 = -prices[0];
            for (int i = 1; i < n; i++) {
                dp0_0 = Math.max(dp0_0, dp0_1 + prices[i]); // 当前没有持有 = Math.max(昨天也没有持有, 昨天持有但是今天卖了)
                dp0_1 = Math.max(dp0_1, dp0_0 - prices[i]); // 当前持有 = Math.max(昨天也持有, 昨天没有持有但是今天买了)
            }
            return dp0_0;
        }

        public int maxProfit1(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 当前没有持有 = Math.max(昨天也没有持有, 昨天持有但是今天卖了)
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 当前持有 = Math.max(昨天也持有, 昨天没有持有但是今天买了)
            }
            return dp[n - 1][0];
        }













        /*public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}