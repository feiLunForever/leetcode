//<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
//
//<p>Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:</p>
//
//<ul>
//	<li>After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).</li>
//</ul>
//
//<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1,2,3,0,2]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> transactions = [buy, sell, cooldown, buy, sell]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [1]
//<strong>Output:</strong> 0
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= prices.length &lt;= 5000</code></li>
//	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 1294, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * @author DY
 * @date 2022-08-16 15:07:18
 */
public class P309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[1][0] = Math.max(0, prices[1] - prices[0]);
            dp[1][1] = Math.max(-prices[0], -prices[1]); // 要么昨天持有，要么今天持有
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 今天没有持有 = Math.max(昨天也没有持有, 昨天持有但今天卖了);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]); // 今天持有 = Math.max(昨天也持有, 前天没持有但今天买了（冷冻期一天）);
            }
            return dp[n - 1][0];
        }

        /*public int maxProfit(int[] prices) {
            // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            if (prices.length == 1) return 0;
            if (prices.length == 2) return Math.max(0, prices[1] - prices[0]);
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[1][0] = Math.max(0, prices[1] - prices[0]);
            dp[1][1] = Math.max(-prices[0], -prices[1]);
            for (int i = 2; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}