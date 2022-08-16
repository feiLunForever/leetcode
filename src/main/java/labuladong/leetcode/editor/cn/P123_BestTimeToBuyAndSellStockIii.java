//<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
//
//<p>Find the maximum profit you can achieve. You may complete <strong>at most two transactions</strong>.</p>
//
//<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [3,3,5,0,0,3,1,4]
//<strong>Output:</strong> 6
//<strong>Explanation:</strong> Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1,2,3,4,5]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [7,6,4,3,1]
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> In this case, no transaction is done, i.e. max profit = 0.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>0 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 1202, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock III
 *
 * @author DY
 * @date 2022-08-16 17:09:36
 */
public class P123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[][][] dp = new int[prices.length][3][2];
//            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
//            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            dp[0][2][1] = -prices[0];
            dp[0][2][0] = 0;
            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                for (int k = 2; k >= 1; k--) {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
            return dp[prices.length - 1][2][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}