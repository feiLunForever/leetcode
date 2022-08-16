//<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p>
//
//<p>Find the maximum profit you can achieve. You may complete at most <code>k</code> transactions.</p>
//
//<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 2, prices = [2,4,1]
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> k = 2, prices = [3,2,6,5,0,3]
//<strong>Output:</strong> 7
//<strong>Explanation:</strong> Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>0 &lt;= k &lt;= 100</code></li>
//	<li><code>0 &lt;= prices.length &lt;= 1000</code></li>
//	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
//
//<div>👍 786, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Best Time to Buy and Sell Stock IV
 *
 * @author DY
 * @date 2022-08-16 19:46:02
 */
public class P188_BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P188_BestTimeToBuyAndSellStockIv().new Solution();
        System.out.println(solution.maxProfit(2, new int[]{}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) return 0;
            int[][][] dp = new int[prices.length][k + 1][2];
//            dp[i][m][0] = Math.max(dp[i - 1][m][0], dp[i - 1][m][1] + prices[i]);
//            dp[i][m][1] = Math.max(dp[i - 1][m][1], dp[i - 1][m - 1][0] - prices[i]);
            for (int m = 1; m <= k; m++) {
                dp[0][m][0] = 0;
                dp[0][m][1] = -prices[0];
            }
            for (int i = 1; i < prices.length; i++) {
                for (int m = 1; m <= k; m++) {
                    dp[i][m][0] = Math.max(dp[i - 1][m][0], dp[i - 1][m][1] + prices[i]);
                    dp[i][m][1] = Math.max(dp[i - 1][m][1], dp[i - 1][m - 1][0] - prices[i]);
                }
            }
            return dp[prices.length - 1][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}