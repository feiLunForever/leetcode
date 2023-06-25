<p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of two. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of two, if there exists an integer <code>x</code> such that <code>n == 2<sup>x</sup></code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>0</sup> = 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 16
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>4</sup> = 16
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you solve it without loops/recursion?

<details><summary><strong>Related Topics</strong></summary>位运算 | 递归 | 数学</details><br>

<div>👍 613, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=power-of-two" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

一个数如果是 2 的指数，那么它的二进制表示一定只含有一个 1。

位运算 `n&(n-1)` 在算法中挺常见的，作用是消除数字 `n` 的二进制表示中的最后一个 1，用这个技巧可以判断 2 的指数。

**详细题解：[常用的位操作](https://labuladong.github.io/article/fname.html?fname=常用的位操作)**

**标签：[位运算](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    bool isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        return (n & (n - 1)) == 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// Solution to LeetCode problem: Power of Two
// https://leetcode.com/problems/power-of-two/
import "fmt"

func isPowerOfTwo(n int) bool {
    if n <= 0 {
        return false
    }
    return (n & (n - 1)) == 0
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n <= 0) return false;
    return (n & (n - 1)) == 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_power-of-two" data="G2wMAJwHtnuUBRYY1oaZek8KkQR54frbu+zrtydeQfRElU4HCJrwyO1mW48U///3+yXaxGyTCkk8RCiNf869bEQlmacnmKe/SDAzSTTUyWke4rRupET8p7aVM3NZ85bM3X+9qEQgGzOXf2Hg9jRmW5VDGKmuD6H9w4pMGf/HgRulnM3FNgrnSxGPmHNWVx9tq0fKWvu+61P8ftT5UOmEWAM1ay4Dgr/6x9m2EII4c9DczLg59ZN28Vk6n3j54+OzZhpt4+YL4wa8yITF6Jvn3KwASmNFhZXxe8xlMCrySPv1nSBAqoLoqLNoI9W21F2MMx8M5Nzx5shSEFVrjbe1NIp9+ej+hCnaxpTXT0CRxRNeRVQHimGpjDhU0t+MmB8H+eprL17VJPibcQpA3uvZQwJxAtcpxSUZKWPRL2C5qCjkOY6TurmSg9bxCNRjZxfC1wMHzeWDoygSz3Q4tTVWQYHCvTmOgTGtZj/ajwXGkYxs6A1gmC3LSYn/LjZ0yw4wsFitjDT0xjVjhqGDd8E/y2mTGTRY55o9/vM6F+PCMgMMDekOskvWKCFRr5SibOAz58n4D8ywTLVr9XLfvZy65QzREqp5PVg0TrOe4fjT3qdgocamW4mNXx+NRiwazL3nmAFaT0VoRFkBouXK3rOPLSZs3WRuQ8gMJy5moeSlLJBFJY0Uyh6MMGKMrFAoe8CxcNGJkrt6lAgaFcyAl0e27nvoMv8ELPZ4wirImMVL9qhQc+n4jR9f3xQIkbJZwiIEIUzcK6GLjoYdG4+lb2CZsIiIsZoX+9UZTsOBdYdBfuVHgUUZKRzS0Mrtb+DbXethPvkVLMrKhWcNPgy2Ydau9XVQUmk9wsgnRZZCVTHG3mOr9TgOQ7JglHCLGtvfPJtsm8PADo2KwU0/Lan1RrSuSyWM7nhTIGkaqRA4S6CNYFibXQv+YGcDEiwiRcoJR7w3/exbgCCjMI1Cau5Ctu1AjRLqOm/LijEWe3b9WCMLI3ajvcMqc8weD2H9ZQEbqLV3KHUg2T5C0DK3uV9DxCZkmIeHENBb+PH1DRxepTlEkwKeGRZRQ6gzABrlETcsAOo0B29CyGywxkzw1zYARnNWN4nCEISF6qqny/qlXxAbNlfNQc6CPtqPXaHuONtYBztUnrEyd9b0tZo49j5iufZhofh1un4iETMC/Y6CX1gwFCrw/n/ehvOi4439L194pUrB3+Gdiirqmf/Yu33bGNi67fHfhXrPwupzFwBkozGjZ85D6LlIlzMG4iuuwImbrmcZbjljPLyFXupvYOv+AyjyZNmY48Ku+3qetwN3PThFGHVdbIhgZqew/Bfx5gOOV26yW/dUw0Y+wvXg9GoD8YzQaXJxGQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_power-of-two"></div></div>
</details><hr /><br />

**类似题目**：
  - [136. 只出现一次的数字 🟢](/problems/single-number)
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [268. 丢失的数字 🟢](/problems/missing-number)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



