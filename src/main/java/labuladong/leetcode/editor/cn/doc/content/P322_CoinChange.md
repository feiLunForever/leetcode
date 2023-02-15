<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return <em>the fewest number of coins that you need to make up that amount</em>. If that amount of money cannot be made up by any combination of the coins, return <code>-1</code>.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> coins = [1,2,5], amount = 11
<strong>Output:</strong> 3
<strong>Explanation:</strong> 11 = 5 + 5 + 1
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> coins = [2], amount = 3
<strong>Output:</strong> -1
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> coins = [1], amount = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 动态规划</details><br>

<div>👍 2080, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，第 17 期刷题打卡 [开始报名](https://aep.xet.tech/s/2jPp5X)。**



<p><strong><a href="https://labuladong.github.io/article?qno=322" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[动态规划框架套路详解](https://www.bilibili.com/video/BV1XV411Y7oE)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 31 页。

1、**确定 base case**，显然目标金额 `amount` 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。

2、**确定「状态」，也就是原问题和子问题中会变化的变量**。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 `amount`。

3、**确定「选择」，也就是导致「状态」产生变化的行为**。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。

4、**明确 `dp` 函数/数组的定义**：输入一个目标金额 `n`，返回凑出目标金额 `n` 的最少硬币数量。

按照 `dp` 函数的定义描述「选择」，得到最终答案 `dp(amount)`。

**详细题解：[动态规划解题套路框架](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，最短路径算法**

## 解法代码

```java
class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // dp 数组全都初始化为特殊值
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);/**<extend up -200>


           ![](https://labuladong.gitee.io/pictures/动态规划详解进阶/5.jpg)
*/
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
```

**类似题目**：
  - [509. 斐波那契数 🟢](/problems/fibonacci-number)
  - [剑指 Offer II 103. 最少的硬币数目 🟠](/problems/gaM7Ch)

</details>
</div>







