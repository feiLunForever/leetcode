<p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>'.'</code> and <code>'*'</code> where:</p>

<ul> 
 <li><code>'.'</code> Matches any single character.​​​​</li> 
 <li><code>'*'</code> Matches zero or more of the preceding element.</li> 
</ul>

<p>The matching should cover the <strong>entire</strong> input string (not partial).</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "aa", p = "a"
<strong>Output:</strong> false
<strong>Explanation:</strong> "a" does not match the entire string "aa".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "aa", p = "a*"
<strong>Output:</strong> true
<strong>Explanation:</strong> '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "ab", p = ".*"
<strong>Output:</strong> true
<strong>Explanation:</strong> ".*" means "zero or more (*) of any character (.)".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li> 
 <li><code>1 &lt;= p.length&nbsp;&lt;= 20</code></li> 
 <li><code>s</code> contains only lowercase English letters.</li> 
 <li><code>p</code> contains only lowercase English letters, <code>'.'</code>, and&nbsp;<code>'*'</code>.</li> 
 <li>It is guaranteed for each appearance of the character <code>'*'</code>, there will be a previous valid character to match.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 字符串 | 动态规划</details><br>

<div>👍 3621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=regular-expression-matching" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

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
    # 备忘录
    memo = []

    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        self.memo = [[-1] * n for _ in range(m)]
        # 指针 i，j 从索引 0 开始移动
        return self.dp(s, 0, p, 0)

    # 计算 p[j..] 是否匹配 s[i..]
    def dp(self, s: str, i: int, p: str, j: int) -> bool:
        m, n = len(s), len(p)
        # base case
        if j == n:
            return i == m
        if i == m:
            if (n - j) % 2 == 1:
                return False
            for k in range(j + 1, n, 2):
                if p[k] != '*':
                    return False
            return True

        # 查备忘录，防止重复计算
        if self.memo[i][j] != -1:
            return self.memo[i][j]

        res = False

        if s[i] == p[j] or p[j] == '.':
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2) or self.dp(s, i + 1, p, j)
            else:
                res = self.dp(s, i + 1, p, j + 1)
        else:
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2)
            else:
                res = False
        # 将当前结果记入备忘录
        self.memo[i][j] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    // 备忘录
    int[][] memo;

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
        } else {
            res = false
        }
    }
    // 将当前结果记入备忘录
    memo[i][j] = 0
    if res {
        memo[i][j] = 1
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isMatch = function(s, p) {
    let m = s.length, n = p.length;
    // 备忘录
    let memo = new Array(m + 1);
    for (let i = 0; i < memo.length; i++) {
        memo[i] = new Array(n + 1).fill(-1);
    }

    return dp(0, 0);

    /* 计算 p[j..] 是否匹配 s[i..] */
    function dp(i, j) {
        // 查备忘录，防止重复计算
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        let res = false;
        // base case
        if (j === n) {
            res = i === m;
        } else {
            let firstMatch = i < m && (p[j] === s[i] || p[j] === '.');
            if (j + 1 < n && p[j + 1] === '*') {
                res = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
            } else {
                res = firstMatch && dp(i + 1, j + 1);
            }
        }
        // 将当前结果记入备忘录
        memo[i][j] = res;
        return res;
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_regular-expression-matching" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_regular-expression-matching"></div></div>
</details><hr /><br />

**类似题目**：
  - [44. 通配符匹配 🔴](/problems/wildcard-matching)
  - [剑指 Offer 19. 正则表达式匹配 🔴](/problems/zheng-ze-biao-da-shi-pi-pei-lcof)

</details>
</div>



