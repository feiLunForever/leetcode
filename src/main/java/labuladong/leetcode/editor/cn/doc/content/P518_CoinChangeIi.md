<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the number of combinations that make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>0</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>The answer is <strong>guaranteed</strong> to fit into a signed <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> amount = 5, coins = [1,2,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> amount = 3, coins = [2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> the amount of 3 cannot be made up just with coins of 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> amount = 10, coins = [10]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= coins.length &lt;= 300</code></li> 
 <li><code>1 &lt;= coins[i] &lt;= 5000</code></li> 
 <li>All the values of <code>coins</code> are <strong>unique</strong>.</li> 
 <li><code>0 &lt;= amount &lt;= 5000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 940, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 12 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后一天报名；点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=518" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 196 页。

我们可以把这个问题转化为背包问题的描述形式：

有一个背包，最大容量为 `amount`，有一系列物品 `coins`，每个物品的重量为 `coins[i]`，**每个物品的数量无限**。请问有多少种方法，能够把背包恰好装满？

第一步要明确两点，「状态」和「选择」，状态有两个，就是「背包的容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」。

`dp[i][j]` 的定义：若只使用前 `i` 个物品（可以重复使用），当背包容量为 `j` 时，有 `dp[i][j]` 种方法可以装满背包。

最终想得到的答案是 `dp[N][amount]`，其中 `N` 为 `coins` 数组的大小。

**如果你不把这第 `i` 个物品装入背包**，也就是说你不使用 `coins[i]` 这个面值的硬币，那么凑出面额 `j` 的方法数 `dp[i][j]` 应该等于 `dp[i-1][j]`，继承之前的结果。

**如果你把这第 `i` 个物品装入了背包**，也就是说你使用 `coins[i]` 这个面值的硬币，那么 `dp[i][j]` 应该等于 `dp[i][j-coins[i-1]]`。

**详细题解：[经典动态规划：完全背包问题](https://labuladong.github.io/article/fname.html?fname=背包零钱)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[背包问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122018870755491844)**

## 解法代码

```java
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i-1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }
}
```

</details>
</div>



