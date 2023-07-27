English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数学 | 动态规划</details><br>

<div>👍 607, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [343. 整数拆分](/problems/integer-break) 一样，按照 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 的流程来就行了。

详细的思路看第 343 题吧，只要改个函数名就能解决这道题。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    vector<int> memo;

public:
    int cuttingRope(int n) {
        memo = vector<int>(n + 1);
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
        int res = INT_MIN;
        for (int i = 1; i <= n; i++) {
            res = max(res, i * max(dp(n - i), n - i));
        }
        memo[n] = res;
        return res;
    }

};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def cuttingRope(self, n: int) -> int:
        memo = [0] * (n+1)
        return self.dp(n, memo)

    # 定义：拆分 n 获得的最大乘积为 dp(n)
    def dp(self, n: int, memo: List[int]) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        if memo[n] > 0:
            return memo[n]

        # 状态转移方程
        res = float('-inf')
        for i in range(1, n+1):
            res = max(res, i * max(self.dp(n - i, memo), n - i))

        memo[n] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

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

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func cuttingRope(n int) int {
    memo := make([]int, n+1)
    return dp(n, memo)
}

// 定义：拆分 n 获得的最大乘积为 dp(n)
func dp(n int, memo []int) int {
    if n == 0 {
        return 0
    }
    if n == 1 {
        return 1
    }
    if memo[n] > 0 {
        return memo[n]
    }

    // 状态转移方程
    res := math.MinInt32
    for i := 1; i <= n; i++ {
        res = max(res, i*max(dp(n-i, memo), n-i))
    }
    memo[n] = res
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var cuttingRope = function(n) {
    var memo = new Array(n + 1).fill(0);
    return dp(n);

    function dp(n) {
        if (n === 0) {
            return 0;
        }
        if (n === 1) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }

        // 状态转移方程
        var res = Number.MIN_SAFE_INTEGER;
        for (var i = 1; i <= n; i++) {
            res = Math.max(res, i * Math.max(dp(n - i), n - i));
        }
        memo[n] = res;
        return res;
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_jian-sheng-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_jian-sheng-zi-lcof"></div></div>
</details><hr /><br />

</details>
</div>



