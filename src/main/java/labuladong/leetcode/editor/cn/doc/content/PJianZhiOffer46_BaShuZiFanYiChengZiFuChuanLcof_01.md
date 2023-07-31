English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 588, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题考察 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)，和 [91. 解码方法](/problems/decode-ways) 几乎一模一样。唯一的区别是，91 题让 `a->1, b->2...`，这道题让 `a->0, b->1...`。

所以只要把第 91 题的代码稍微改一下就可以解决这道题了，我直接贴代码了，详细的解题思路可以去 91 题的「思路」按钮查看。

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
public:
    int translateNum(int num) {
        string s = to_string(num);
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
        vector<int> dp(n + 1);
        // base case: s 为空或者 s 只有一个字符的情况
        dp[0] = 1;
        dp[1] = 1;

        // 注意 dp 数组和 s 之间的索引偏移一位
        for (int i = 2; i <= n; i++) {
            char c = s[i - 1], d = s[i - 2];
            if ('0' <= c && c <= '9') {
                // 1. s[i] 本身可以作为一个字母
                dp[i] += dp[i - 1];
            }
            if (d == '1' || d == '2' && c <= '5') {
                // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def translateNum(self, num: int) -> int:
        s = str(num)
        n = len(s)
        if n < 1:
            return 0
        # 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
        dp = [0] * (n + 1)
        # base case: s 为空或者 s 只有一个字符的情况
        dp[0] = 1
        dp[1] = 1

        # 注意 dp 数组和 s 之间的索引偏移一位
        for i in range(2, n + 1):
            c = s[i - 1]
            d = s[i - 2]
            if '0' <= c <= '9':
                # 1. s[i] 本身可以作为一个字母
                dp[i] += dp[i - 1]
            if d == '1' or (d == '2' and c <= '5'):
                # 2. s[i] 和 s[i - 1] 结合起来表示一个字母
                dp[i] += dp[i - 2]
        return dp[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int translateNum(int num) {
        String s = num + "";
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
        int[] dp = new int[n + 1];
        // base case: s 为空或者 s 只有一个字符的情况
        dp[0] = 1;
        dp[1] = 1;

        // 注意 dp 数组和 s 之间的索引偏移一位
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1), d = s.charAt(i - 2);
            if ('0' <= c && c <= '9') {
                // 1. s[i] 本身可以作为一个字母
                dp[i] += dp[i - 1];
            }
            if (d == '1' || d == '2' && c <= '5') {
                // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func translateNum(num int) int {
    s := strconv.Itoa(num)
    n := len(s)
    if n < 1 {
        return 0
    }
    // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
    dp := make([]int, n+1)
    // base case: s 为空或者 s 只有一个字符的情况
    dp[0] = 1
    dp[1] = 1

    // 注意 dp 数组和 s 之间的索引偏移一位
    for i := 2; i <= n; i++ {
        c, d := s[i-1], s[i-2]
        if '0' <= c && c <= '9' {
            // 1. s[i] 本身可以作为一个字母
            dp[i] += dp[i-1]
        }
        if (d == '1' || (d == '2' && c <= '5')) {
            // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
            dp[i] += dp[i-2]
        }
    }
    return dp[n]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var translateNum = function(num) {
    var s = num.toString();
    var n = s.length;
    if (n < 1) {
        return 0;
    }
    // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
    var dp = new Array(n + 1).fill(0);
    // base case: s 为空或者 s 只有一个字符的情况
    dp[0] = 1;
    dp[1] = 1;

    // 注意 dp 数组和 s 之间的索引偏移一位
    for (var i = 2; i <= n; i++) {
        var c = s.charAt(i - 1), d = s.charAt(i - 2);
        if ('0' <= c && c <= '9') {
            // 1. s[i] 本身可以作为一个字母
            dp[i] += dp[i - 1];
        }
        if (d == '1' || d == '2' && c <= '5') {
            // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
            dp[i] += dp[i - 2];
        }
    }
    return dp[n];
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof"></div></div>
</details><hr /><br />

</details>
</div>



