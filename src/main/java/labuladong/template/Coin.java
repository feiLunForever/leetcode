package labuladong.template;

public class Coin {
    int maxProfit(int[] prices) {
        // dp[i][k][m] i:天数; k: 交易数的上限; m: 0不持有股票，1持有股票
        // 0 <= i <= n - 1, 1 <= k <= K
        // 今天我没有持有股票，有两种可能，我从这两种可能中求最大利润：
        //1、我昨天就没有持有，且截至昨天最大交易次数限制为 k；然后我今天选择 rest，所以我今天还是没有持有，最大交易次数限制依然为 k。
        //2、我昨天持有股票，且截至昨天最大交易次数限制为 k；但是今天我 sell 了，所以我今天没有持有股票了，最大交易次数限制依然为 k。
        // dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+price[i]);

        //今天我持有着股票，最大交易次数限制为 k，那么对于昨天来说，有两种可能，我从这两种可能中求最大利润：
        //1、我昨天就持有着股票，且截至昨天最大交易次数限制为 k；然后今天选择 rest，所以我今天还持有着股票，最大交易次数限制依然为 k。
        //2、我昨天本没有持有，且截至昨天最大交易次数限制为 k - 1；但今天我选择 buy，所以今天我就持有股票了，最大交易次数限制为 k。
        // dp[i][k][1]= Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i]);

        // dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1]+price[i]);
        // dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-price[i]);

        // bad case dp[i-1][0][1] = 0;
        // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price[i]);
        // dp[i][1] = Math.max(dp[i-1][1],-price[i]);

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
