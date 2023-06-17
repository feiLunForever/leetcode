<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>

<p>You have the following three operations permitted on a word:</p>

<ul> 
 <li>Insert a character</li> 
 <li>Delete a character</li> 
 <li>Replace a character</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = "horse", word2 = "ros"
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
horse -&gt; rorse (replace 'h' with 'r')
rorse -&gt; rose (remove 'r')
rose -&gt; ros (remove 'e')
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = "intention", word2 = "execution"
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
intention -&gt; inention (remove 't')
inention -&gt; enention (replace 'i' with 'e')
enention -&gt; exention (replace 'n' with 'x')
exention -&gt; exection (replace 'n' with 'c')
exection -&gt; execution (insert 'u')
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li> 
 <li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 3003, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=edit-distance" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[编辑距离详解动态规划](https://www.bilibili.com/video/BV1uv411W73P)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 123 页。

解决两个字符串的动态规划问题，一般都是用两个指针 `i, j` 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模。

对于每对儿字符 `s1[i]` 和 `s2[j]`，可以有四种操作：

```python
if s1[i] == s2[j]:
    啥都别做（skip）
    i, j 同时向前移动
else:
    三选一：
        插入（insert）
        删除（delete）
        替换（replace）
```

那么「状态」就是指针 `i, j` 的位置，「选择」就是上述的四种操作。

如果使用自底向上的迭代解法，这样定义 `dp` 数组：`dp[i-1][j-1]` 存储 `s1[0..i]` 和 `s2[0..j]` 的最小编辑距离。`dp` 数组索引至少是 0，所以索引会偏移一位。

然后把上述四种选择用 `dp` 函数表示出来，就可以得出最后答案了。

**详细题解：[经典动态规划：编辑距离](https://labuladong.github.io/article/fname.html?fname=编辑距离)**

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
    int minDistance(string word1, string word2) {
        int m = word1.length(), n = word2.length();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1[i - 1] == word2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/delete.gif) */
                        dp[i][j - 1] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/insert.gif) */
                        dp[i - 1][j - 1] + 1/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/replace.gif) */
                    );
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return std::min(a, std::min(b, c));
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        dp = [[0] * (n+1) for _ in range(m+1)]
        
        # base case
        for i in range(1, m+1):
            dp[i][0] = i
        for j in range(1, n+1):
            dp[0][j] = j
        
        # 自底向上求解
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(
                        dp[i-1][j] + 1, # insert
                        dp[i][j-1] + 1, # delete
                        dp[i-1][j-1] + 1 # replace
                    )
        
        # 储存着整个 word1 和 word2 的最小编辑距离
        return dp[m][n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 自底向上求解
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/delete.gif) */
                        dp[i][j - 1] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/insert.gif) */
                        dp[i - 1][j - 1] + 1/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/replace.gif) */
                    );
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minDistance(s1 string, s2 string) int {
    m, n := len(s1), len(s2)
    dp := make([][]int, m+1)
    for i := range dp {
        dp[i] = make([]int, n+1)
    }
    // base case
    for i := 1; i <= m; i++ {
        dp[i][0] = i
    }
    for j := 1; j <= n; j++ {
        dp[0][j] = j
    }
    // 自底向上求解
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if s1[i-1] == s2[j-1] {
                dp[i][j] = dp[i-1][j-1]
            } else {
                dp[i][j] = min(
                    dp[i-1][j]+1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/delete.gif) */
                    dp[i][j-1]+1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/insert.gif) */
                    dp[i-1][j-1]+1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/replace.gif) */
                )
            }
        }
    }
    // 储存着整个 s1 和 s2 的最小编辑距离
    return dp[m][n]
}

func min(a, b, c int) int {
    if a < b {
        if a < c {
            return a
        }
        return c
    } else if b < c {
        return b
    }
    return c
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minDistance = function(s1, s2) {
    let m = s1.length, n = s2.length;
    let dp = new Array(m + 1).fill().map(() => new Array(n + 1).fill(0));
    // base case
    for (let i = 1; i <= m; i++)
        dp[i][0] = i;
    for (let j = 1; j <= n; j++)
        dp[0][j] = j;
    // 自底向上求解
    for (let i = 1; i <= m; i++)
        for (let j = 1; j <= n; j++)
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else
                dp[i][j] = Math.min(
                    dp[i - 1][j] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/delete.gif) */
                    dp[i][j - 1] + 1,/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/insert.gif) */
                    dp[i - 1][j - 1] + 1/**<extend up -300>![](https://labuladong.github.io/pictures/editDistance/replace.gif) */
                );
    // 储存着整个 s1 和 s2 的最小编辑距离
    return dp[m][n];
}

function min(a, b, c) {
    return Math.min(a, Math.min(b, c));
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_edit-distance" data="iwGAbnVsbAM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_edit-distance"></div></div>
</details><hr /><br />

**类似题目**：
  - [1143. 最长公共子序列 🟠](/problems/longest-common-subsequence)
  - [剑指 Offer II 095. 最长公共子序列 🟠](/problems/qJnOS7)

</details>
</div>



