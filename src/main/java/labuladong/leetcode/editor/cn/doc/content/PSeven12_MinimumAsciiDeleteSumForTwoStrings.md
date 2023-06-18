<p>Given two strings <code>s1</code> and&nbsp;<code>s2</code>, return <em>the lowest <strong>ASCII</strong> sum of deleted characters to make two strings equal</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s1 = "sea", s2 = "eat"
<strong>Output:</strong> 231
<strong>Explanation:</strong> Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s1 = "delete", s2 = "leet"
<strong>Output:</strong> 403
<strong>Explanation:</strong> Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s1.length, s2.length &lt;= 1000</code></li> 
 <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 329, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-ascii-delete-sum-for-two-strings" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题本质上是考察最长公共子序列问题的解法，把 [1143. 最长公共子序列问题](/problems/longest-common-subsequence) 的解法代码稍微改一下就 OK 了。

**详细题解：[经典动态规划：最长公共子序列](https://labuladong.github.io/article/fname.html?fname=LCS)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    // 备忘录
    int memo[1001][1001];

    /* 主函数 */
    int minimumDeleteSum(string s1, string s2) {
        int m = s1.size(), n = s2.size();
        // 备忘录值为 -1 代表未曾计算
        memset(memo, -1, sizeof(memo));
        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(string s1, int i, string s2, int j) {
        int res = 0;
        // base case
        if (i == s1.size()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.size(); j++)
                res += s2[j];
            return res;
        }
        if (j == s2.size()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.size(); i++)
                res += s1[i];
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1[i] == s2[j]) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                    s1[i] + dp(s1, i + 1, s2, j),
                    s2[j] + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        # 备忘录值为 -1 代表未曾计算
        memo = [[-1] * n for _ in range(m)]

        def dp(i: int, j: int) -> int:
            res = 0
            # base case
            if i == m:
                # 如果 s1 到头了，那么 s2 剩下的都得删除
                for k in range(j, n):
                    res += ord(s2[k])
                return res
            if j == n:
                # 如果 s2 到头了，那么 s1 剩下的都得删除
                for k in range(i, m):
                    res += ord(s1[k])
                return res

            if memo[i][j] != -1:
                return memo[i][j]

            if s1[i] == s2[j]:
                # s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
                memo[i][j] = dp(i + 1, j + 1)
            else:
                # s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
                memo[i][j] = min(
                    ord(s1[i]) + dp(i + 1, j),
                    ord(s2[j]) + dp(i, j + 1)
                )
            return memo[i][j]

        return dp(0, 0)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    // 备忘录
    int memo[][];

    /* 主函数 */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minimumDeleteSum(s1 string, s2 string) int {
    m, n := len(s1), len(s2)
    // 备忘录值为 -1 代表未曾计算
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }

    var dp func(s1 string, i int, s2 string, j int) int
    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    dp = func(s1 string, i int, s2 string, j int) int {
        res := 0
        // base case
        if i == len(s1) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for ; j < len(s2); j++ {
                res += int(s2[j])
            }
            return res
        }
        if j == len(s2) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for ; i < len(s1); i++ {
                res += int(s1[i])
            }
            return res
        }

        if memo[i][j] != -1 {
            return memo[i][j]
        }

        if s1[i] == s2[j] {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1)
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                int(s1[i]) + dp(s1, i + 1, s2, j),
                int(s2[j]) + dp(s1, i, s2, j + 1),
            )
        }
        return memo[i][j]
    }

    return dp(s1, 0, s2, 0)
}

func min(a, b int) int {
    if a < b {
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

var minimumDeleteSum = function(s1, s2) {
    var m = s1.length, n = s2.length;
    // memo[i][j] 存储将s1[i...]和s2[j...]删除成相同字符串的最小ASCII码之和
    var memo = new Array(m);
    for(var i=0; i<memo.length; i++) memo[i] = new Array(n).fill(-1);

    // dp函数定义，计算删除成相同字符所需的最小ASCII码之和
    function dp(i, j) {
        var res = 0;
        // 如果 s1 到头了，那么 s2 剩下的都得删除
        if (i == s1.length) {
            for (; j < s2.length; j++)
                res += s2.charCodeAt(j);
            return res;
        }
        // 如果 s2 到头了，那么 s1 剩下的都得删除
        if (j == s2.length) {
            for (; i < s1.length; i++)
                res += s1.charCodeAt(i);
            return res;
        }

        // 如果memo数组已有记录则直接返回
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 如果s1[i]和s2[j]都在LCS中，则不需要删除
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(i + 1, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，需要删掉一个
            memo[i][j] = Math.min(
                    s1.charCodeAt(i) + dp(i + 1, j),
                    s2.charCodeAt(j) + dp(i, j + 1)
            );
        }
        return memo[i][j];
    }

    // 返回将s1和s2删除成相同字符串的最小ASCII码之和
    return dp(0, 0);
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_minimum-ascii-delete-sum-for-two-strings"></iframe>
</div>
<div id="data_minimum-ascii-delete-sum-for-two-strings" data="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"></div></details><hr /><br />

**类似题目**：
  - [1143. 最长公共子序列 🟠](/problems/longest-common-subsequence)
  - [583. 两个字符串的删除操作 🟠](/problems/delete-operation-for-two-strings)
  - [剑指 Offer II 095. 最长公共子序列 🟠](/problems/qJnOS7)

</details>
</div>



