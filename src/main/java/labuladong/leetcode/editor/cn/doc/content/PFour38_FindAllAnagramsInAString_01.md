<p>Given two strings <code>s</code> and <code>p</code>, return <em>an array of all the start indices of </em><code>p</code><em>'s anagrams in </em><code>s</code>. You may return the answer in <strong>any order</strong>.</p>

<p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "cbaebabacd", p = "abc"
<strong>Output:</strong> [0,6]
<strong>Explanation:</strong>
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "abab", p = "ab"
<strong>Output:</strong> [0,1,2]
<strong>Explanation:</strong>
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s</code> and <code>p</code> consist of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 1238, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=find-all-anagrams-in-a-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

这题和 [567. 字符串的排列](/problems/permutation-in-string) 一样，只不过找到一个合法异位词（排列）之后将它的起始索引加入结果列表即可。

滑动窗口算法难度略高，具体的算法原理以及算法模板见详细题解。

**详细题解：[我写了首诗，把滑动窗口算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=滑动窗口技巧进阶)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> findAnagrams(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        vector<int> res; // 记录结果
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.push_back(left);
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }
        }
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
    def findAnagrams(self, s: str, t: str) -> List[int]:
        need = {}
        window = {}
        for c in t:
            if c in need:
                need[c] += 1
            else:
                need[c] = 1

        left = 0
        right = 0
        valid = 0
        res = []
        
        while right < len(s):
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                if c in window:
                    window[c] += 1
                else:
                    window[c] = 1
                if window[c] == need[c]:
                    valid += 1
            # 判断左侧窗口是否要收缩
            while right - left >= len(t):
                # 当窗口符合条件时，把起始索引加入 res
                if valid == len(need):
                    res.append(left)
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.add(left);
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findAnagrams(s string, t string) []int {
    need := make(map[byte]int)
    window := make(map[byte]int)
    for i := 0; i < len(t); i++ {
        need[t[i]]++
    }

    left, right := 0, 0
    valid := 0
    var res []int
    for right < len(s) {
        c := s[right]
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c]++
            if window[c] == need[c] {
                valid++
            }
        }
        // 判断左侧窗口是否要收缩
        for right - left >= len(t) {
            // 当窗口符合条件时，把起始索引加入 res
            if valid == len(need) {
                res = append(res, left)
            }
            d := s[left]
            left++
            // 进行窗口内数据的一系列更新
            if _, ok := need[d]; ok {
                if window[d] == need[d] {
                    valid--
                }
                window[d]--
            }
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @param {string} t
 * @return {number[]}
 */
var findAnagrams = function(s, t) {
    const need = new Map();
    const window = new Map();
    for (const c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    const res = [];

    while (right < s.length) {
        const c = s[right];
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }
        // 判断左侧窗口是否要收缩
        while (right - left >= t.length) {
            // 当窗口符合条件时，把起始索引加入 res
            if (valid === need.size) {
                res.push(left);
            }
            const d = s[left];
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_find-all-anagrams-in-a-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-anagrams-in-a-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>



