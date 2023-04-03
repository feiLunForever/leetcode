/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>
 *
 * <div>👍 336, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 股票的最大利润  LCOF
 *
 * @author DY
 * @date 2023-04-03 15:02:39
 */
public class PJianZhiOffer63_GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer63_GuPiaoDeZuiDaLiRunLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
			if (prices.length < 2) return 0; // 没有卖出的可能性
            int dp0_0 = 0;
            int dp0_1 = -prices[0];
            for (int i = 1; i < prices.length; i++) {
				dp0_0 = Math.max( // 第i天不持有股票
						dp0_0, // 前一天也不持有股票
						dp0_1 + prices[i]); // 前一天持有股票，但是今天卖了
				dp0_1 = Math.max( // 第i天持有股票
						dp0_1, // 前一天也持有股票
						- prices[i] // 前一天不持有股票，但是今天买了
                );
            }
            return dp0_0;
        }

        public int maxProfit1(int[] prices) {
			if (prices.length < 2) return 0; // 没有卖出的可能性
            int[][] dp = new int[prices.length][2]; // i 代表 0..i天；j 代表 0 : 不持有股票，1 ：持有股票 最大利益
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max( // 第i天不持有股票
                        dp[i - 1][0], // 前一天也不持有股票
                        dp[i - 1][1] + prices[i]); // 前一天持有股票，但是今天卖了
                dp[i][1] = Math.max( // 第i天持有股票
                        dp[i - 1][1], // 前一天也持有股票
						- prices[i] // 前一天不持有股票，但是今天买了
                );
            }
            return dp[prices.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
