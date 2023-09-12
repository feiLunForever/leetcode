<p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "babad"
<strong>Output:</strong> "bab"
<strong>Explanation:</strong> "aba" is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "cbbd"
<strong>Output:</strong> "bb"
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> consist of only digits and English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 6800, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=longest-palindromic-substring" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 373 页。

**寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串**，对于最长回文子串，就是这个意思：

```python
for 0 <= i < len(s):
    找到以 s[i] 为中心的回文串
    更新答案
```

找回文串的关键技巧是传入两个指针 `l` 和 `r` 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。

```python
for 0 <= i < len(s):
    # 找到以 s[i] 为中心的回文串
    palindrome(s, i, i)
    # 找到以 s[i] 和 s[i+1] 为中心的回文串
    palindrome(s, i, i + 1)
    更新答案
```

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：中心向两端的双指针，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            string s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            string s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    string palindrome(string s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s[l] == s[r]) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substr(l + 1, r - l - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        for i in range(len(s)):
            # 以 s[i] 为中心的最长回文子串
            s1 = self.palindrome(s, i, i)
            # 以 s[i] 和 s[i+1] 为中心的最长回文子串
            s2 = self.palindrome(s, i, i + 1)
            # res = longest(res, s1, s2)
            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2
        return res

    def palindrome(self, s: str, l: int, r: int) -> str:
        # 防止索引越界
        while l >= 0 and r < len(s) and s[l] == s[r]:
            # 向两边展开
            l -= 1
            r += 1
        # 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s[l+1:r]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func longestPalindrome(s string) string {
    res := ""
    for i := 0; i < len(s); i++ {
        // 以 s[i] 为中心的最长回文子串
        s1 := palindrome(s, i, i)
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        s2 := palindrome(s, i, i+1)
        // res = longest(res, s1, s2)
        if len(s1) > len(res) {
            res = s1
        }
        if len(s2) > len(res) {
            res = s2
        }
    }
    return res
}

func palindrome(s string, l, r int) string {
    // 防止索引越界
    for l >= 0 && r < len(s) && s[l] == s[r] {
        // 向两边展开
        l--
        r++
    }
    // 返回以 s[l] 和 s[r] 为中心的最长回文串
    return s[l+1 : r]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var longestPalindrome = function(s) {
    let res = "";
    for (let i = 0; i < s.length; i++) {
        // 以 s[i] 为中心的最长回文子串
        let s1 = palindrome(s, i, i);
        // 以 s[i] 和 s[i+1] 为中心的最长回文子串
        let s2 = palindrome(s, i, i + 1);
        // res = longest(res, s1, s2)
        res = res.length > s1.length ? res : s1;
        res = res.length > s2.length ? res : s2;
    }
    return res;

    function palindrome(s, l, r) {
        // 防止索引越界
        while (l >= 0 && r < s.length
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_longest-palindromic-substring" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-palindromic-substring"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [658. 找到 K 个最接近的元素 🟠](/problems/find-k-closest-elements)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



