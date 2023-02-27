<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are <strong>arranged in a circle.</strong> That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and&nbsp;<b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <strong>without alerting the police</strong></em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 1131, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 最后一天报名！**



<p><strong><a href="https://labuladong.github.io/article?qno=213" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 201 页。

首先，首尾房间不能同时被抢，那么只可能有三种不同情况：要么都不被抢；要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢。

![](https://labuladong.gitee.io/pictures/robber/3.jpg)

这三种情况哪个结果最大，就是最终答案。其实，情况一的结果肯定最小，我们只要比较情况二和情况三就行了，**因为这两种情况对于房子的选择余地比情况一大，房子里的钱数都是非负数，所以选择余地大，最优决策结果肯定不会小**。

把 [打家劫舍 I](#198) 的解法稍加改造即可。

**详细题解：[一个方法团灭 LeetCode 打家劫舍问题](https://labuladong.github.io/article/fname.html?fname=抢房子)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        // 两次调用使用两个不同的备忘录
        return Math.max(
                dp(nums, 0, n - 2, memo1),
                dp(nums, 1, n - 1, memo2)
        );
    }

    // 定义：计算闭区间 [start,end] 的最优结果
    int dp(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }
        // 状态转移方程
        int res = Math.max(
                dp(nums, start + 2, end, memo) + nums[start],
                dp(nums, start + 1, end, memo)
        );

        memo[start] = res;
        return res;
    }
}
```

**类似题目**：
  - [198. 打家劫舍 🟠](/problems/house-robber)
  - [337. 打家劫舍 III 🟠](/problems/house-robber-iii)
  - [剑指 Offer II 089. 房屋偷盗 🟠](/problems/Gu0c2T)
  - [剑指 Offer II 090. 环形房屋偷盗 🟠](/problems/PzWKhm)

</details>
</div>





