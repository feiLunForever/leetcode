English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 549, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题考察 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)，和 [91. 解码方法](/problems/decode-ways) 几乎一模一样。唯一的区别是，91 题让 `a->1, b->2...`，这道题让 `a->0, b->1...`。

所以只要把第 91 题的代码稍微改一下就可以解决这道题了，我直接贴代码了，详细的解题思路可以去 91 题的「思路」按钮查看。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

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
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

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
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

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
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

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
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

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

</details>
</div>



