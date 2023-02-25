//<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
//
//<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>
//
//<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [7,1,5,3,6,4]
//<strong>Output:</strong> 5
//<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> prices = [7,6,4,3,1]
//<strong>Output:</strong> 0
//<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 2497, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock
 *
 * @author DY
 * @date 2022-08-16 14:30:54
 */
public class P121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 今天没有持有  = Math.max(昨天也没有持有, 昨天持有但今天卖了)
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]); // 今天持有  = Math.max(昨天也持有, 昨天没持有但今天买了)
            }
            return dp[n - 1][0];
        }

        /*public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            }
            return dp[prices.length - 1][0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}