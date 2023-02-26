//<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>fee</code> representing a transaction fee.</p>
//
//<p>Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.</p>
//
//<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1,3,2,8,4,9], fee = 2
//<strong>Output:</strong> 8
//<strong>Explanation:</strong> The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1,3,7,5,10,3], fee = 3
//<strong>Output:</strong> 6
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
//	<li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>
//
//<div>👍 771, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock with Transaction Fee
 *
 * @author DY
 * @date 2022-08-16 16:23:49
 */
public class P714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P714_BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - fee + prices[i]); // 今天没有持有 = Math.max(昨天也没有持有, 昨天持有但今天卖了);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 今天持有 = Math.max(昨天也持有, 昨天没有持有但今天买了);
            }
            return dp[n - 1][0];
        }

        /*public int maxProfit(int[] prices, int fee) {
            int[][] dp = new int[prices.length][2];
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - fee + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}