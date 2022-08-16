<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p>

<p>Find the maximum profit you can achieve. You may complete at most <code>k</code> transactions.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [2,4,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [3,2,6,5,0,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= k &lt;= 100</code></li>
	<li><code>0 &lt;= prices.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 786, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；第十期刷题打卡挑战 [开始报名](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q)。**



<p><strong><a href="https://labuladong.github.io/article?qno=188" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程和 base case：

```python
状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

base case：
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

这题算是股票问题的终极形态，理论上把上面的状态转移方程实现就行了，但一个关键点在于限制 `k` 的大小，否则会出现内存超限的错误。

一次交易由买入和卖出构成，至少需要两天，所以说有效的限制 `k` 应该不超过 `n/2`，如果超过，就没有约束作用了，相当于 `k = +infinity`，这是 [122. 买卖股票的最佳时机 II](/problems/best-time-to-buy-and-sell-stock-ii) 解决过的。

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[三维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        if (max_k > n / 2) {
            // 交易次数 k 没有限制的情况
            return maxProfit_k_inf(prices);
        }

        // base case：
        // dp[-1][...][0] = dp[...][0][0] = 0
        // dp[-1][...][1] = dp[...][0][1] = -infinity
        int[][][] dp = new int[n][max_k + 1][2];
        // k = 0 时的 base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 i = -1 时的 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                // 状态转移方程
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }

    // 第 122 题，k 无限的解法
    private int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

**类似题目**：
  - [121. 买卖股票的最佳时机 🟢](/problems/best-time-to-buy-and-sell-stock)
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>



