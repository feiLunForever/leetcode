<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of <strong>steps</strong> required to make</em> <code>word1</code> <em>and</em> <code>word2</code> <em>the same</em>.</p>

<p>In one <strong>step</strong>, you can delete exactly one character in either string.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = "sea", word2 = "eat"
<strong>Output:</strong> 2
<strong>Explanation:</strong> You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = "leetcode", word2 = "etco"
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= word1.length, word2.length &lt;= 500</code></li> 
 <li><code>word1</code> and <code>word2</code> consist of only lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 503, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，[第 12 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 报名即将截止，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=583" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

怎么样让两个字符串相同？直接全删成空串，肯定是相等了，但是题目又要求删除次数要尽可能少。

那怎么删？就是删成最长公共子序列嘛，换句话说，只要计算出最长公共子序列的长度，就能算出最少的删除次数了。

前文 [最长公共子序列问题](#1143) 讲了计算最长公共子序列的方法，这里就不展开了。

**详细题解：[经典动态规划：最长公共子序列](https://labuladong.github.io/article/fname.html?fname=LCS)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，子序列**

## 解法代码

```java
class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 复用前文计算 lcs 长度的函数
        int lcs = longestCommonSubsequence(s1, s2);
        return m - lcs + n - lcs;
    }

    // 计算最长公共子序列的长度
    int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 现在 i 和 j 从 1 开始，所以要减一
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
```

**类似题目**：
  - [1143. 最长公共子序列 🟠](/problems/longest-common-subsequence)
  - [712. 两个字符串的最小ASCII删除和 🟠](/problems/minimum-ascii-delete-sum-for-two-strings)
  - [剑指 Offer II 095. 最长公共子序列 🟠](/problems/qJnOS7)

</details>
</div>



