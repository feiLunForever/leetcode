English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>

<div>👍 550, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=zheng-ze-biao-da-shi-pi-pei-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [10. 正则表达式匹配](/problems/regular-expression-matching) 相同。

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 155 页。

`s` 和 `p` 相互匹配的过程大致是，两个指针 `i, j` 分别在 `s` 和 `p` 上移动，如果最后两个指针都能移动到字符串的末尾，那么就匹配成功，反之则匹配失败。

正则表达算法问题只需要把住一个基本点：看 `s[i]` 和 `p[j]` 两个字符是否匹配，一切逻辑围绕匹配/不匹配两种情况展开即可。

动态规划算法的核心就是「状态」和「选择」，**「状态」无非就是 `i` 和 `j` 两个指针的位置，「选择」就是模式串的 `p[j]` 选择匹配几个字符**。

`dp` 函数的定义如下：

**若 `dp(s, i, p, j) = true`，则表示 `s[i..]` 可以匹配 `p[j..]`；若 `dp(s, i, p, j) = false`，则表示 `s[i..]` 无法匹配 `p[j..]`**。

**详细题解：[经典动态规划：正则表达式](https://labuladong.github.io/article/fname.html?fname=动态规划之正则表达)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，字符串**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
class Solution {
    public:
    // 备忘录
    vector<vector<int>> memo;

    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();
        memo = vector<vector<int>>(m, vector<int>(n, -1));
        // 指针 i，j 从索引 0 开始移动
        return dp(s, 0, p, 0);
    }

    /* 计算 p[j..] 是否匹配 s[i..] */
    bool dp(string& s, int i, string& p, int j) {
        int m = s.size(), n = p.size();
        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }

        // 查备忘录，防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        bool res = false;

        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2)
                        || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo[i][j] = res;
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # 备忘录
        memo = []
        # 创建大小为m*n的备忘录，初始值为-1
        m = len(s)
        n = len(p)
        for i in range(m):
            memo.append([-1] * n)
        # 索引指针 i,j 从 0 开始移动
        return self.dp(s, 0, p, 0, memo)

    # 计算 p[j..] 是否匹配 s[i..]
    def dp(self, s, i, p, j, memo):
        m = len(s)
        n = len(p)
        # 如果 j 达到结尾，判断 i 是否也到结尾
        if j == n:
            return i == m
        # 如果 i 达到结尾，判断 j 接下来的字符能否匹配空串
        if i == m:
            if (n - j) % 2 == 1:
                return False
            for k in range(j + 1, n, 2):
                if p[k] != '*':
                    return False
            return True

        # 查备忘录，防止重复计算
        if memo[i][j] != -1:
            return memo[i][j]

        res = False
        if s[i] == p[j] or p[j] == '.':
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2, memo) or self.dp(s, i + 1, p, j, memo)
            else:
                res = self.dp(s, i + 1, p, j + 1, memo)
        else:
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2, memo)
            else:
                res = False

        # 记入当前结果到备忘录
        memo[i][j] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    // 备忘录
    private int[][] memo;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        // 指针 i，j 从索引 0 开始移动
        return dp(s, 0, p, 0);
    }

    /* 计算 p[j..] 是否匹配 s[i..] */
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 查备忘录，防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2)
                        || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isMatch(s string, p string) bool {
    // 备忘录
    memo := make([][]int, len(s))
    for i := range memo {
        memo[i] = make([]int, len(p))
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }
    // 指针 i，j 从索引 0 开始移动
    return dp(s, 0, p, 0, memo)
}

/* 计算 p[j..] 是否匹配 s[i..] */
func dp(s string, i int, p string, j int, memo [][]int) bool {
    m, n := len(s), len(p)
    // base case
    if j == n {
        return i == m
    }
    if i == m {
        if (n-j)%2 == 1 {
            return false
        }
        for ; j+1 < n; j += 2 {
            if p[j+1] != '*' {
                return false
            }
        }
        return true
    }
    // 查备忘录，防止重复计算
    if memo[i][j] != -1 {
        return memo[i][j] == 1
    }

    var res bool

    if s[i] == p[j] || p[j] == '.' {
        if j < n-1 && p[j+1] == '*' {
            res = dp(s, i, p, j+2, memo) || dp(s, i+1, p, j, memo)
        } else {
            res = dp(s, i+1, p, j+1, memo)
        }
    } else {
        if j < n-1 && p[j+1] == '*' {
            res = dp(s, i, p, j+2, memo)
        }
    }
    // 将当前结果记入备忘录
    if res {
        memo[i][j] = 1
    } else {
        memo[i][j] = 0
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 cpp 代码对比查看。

var isMatch = function(s, p) {
    var m = s.length,
        n = p.length;
    var memo = new Array(m + 1); // 先构造一个数组
    for (var i = 0; i <= m; i++) {
        memo[i] = new Array(n + 1).fill(false);
    }
    memo[0][0] = true; // 两个字符串为空串时，互相匹配

    for (i = 0; i <= m; i++) {
        for (var j = 1; j <= n; j++) {
            if (p.charAt(j - 1) === '*') {
                // * 号能匹配 0 次或更多次
                memo[i][j] = memo[i][j - 2] // 匹配 0 次
                || (i > 0 && (s.charAt(i - 1) === p.charAt(j - 2) || p.charAt(j - 2) === '.') && memo[i - 1][j]);
            } else {
                if (i > 0 && (s.charAt(i - 1) === p.charAt(j - 1) || p.charAt(j - 1) === '.')) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
            }
        }
    }

    return memo[m][n]; // 返回从两个字符串的尾部开始，是否相互匹配
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_regular-expression-matching" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_regular-expression-matching"></div></div>
</details><hr /><br />

**类似题目**：
  - [44. 通配符匹配 🔴](/problems/wildcard-matching)
  - [剑指 Offer 19. 正则表达式匹配 🔴](/problems/zheng-ze-biao-da-shi-pi-pei-lcof)

</details>
</div>



