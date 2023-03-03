English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数学 | 动态规划</details><br>

<div>👍 555, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [343. 整数拆分](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 的流程来就行了。

详细的思路看第 343 题吧，只要改个函数名就能解决这道题。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    int[] memo;

    public int cuttingRope(int n) {
        memo = new int[n + 1];
        return dp(n);
    }

    // 定义：拆分 n 获得的最大乘积为 dp(n)
    int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }

        // 状态转移方程
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, i * Math.max(dp(n - i), n - i)
            );
        }
        memo[n] = res;
        return res;
    }

}
```

</details>
</div>



