<p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code><em> if </em><code>s2</code><em> contains a permutation of </em><code>s1</code><em>, or </em><code>false</code><em> otherwise</em>.</p>

<p>In other words, return <code>true</code> if one of <code>s1</code>'s permutations is the substring of <code>s2</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s1 = "ab", s2 = "eidbaooo"
<strong>Output:</strong> true
<strong>Explanation:</strong> s2 contains one permutation of s1 ("ba").
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s1 = "ab", s2 = "eidboaoo"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>

<div>👍 944, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=permutation-in-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

和子数组/子字符串相关的题目，很可能就是要考察滑动窗口算法，往这方面思考就行了。

这道题，相当于你一个 `S` 和一个 `T`，请问你 `S` 中是否存在一个子串，包含 `T` 中所有字符且不包含其他字符？

如果这样想的话就和 [76. 最小覆盖子串](/problems/minimum-window-substring) 有些类似了。

一般来说滑动窗口算法难度略高，需要你掌握算法原理以及算法模板辅助，见详细题解吧。

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

    // 判断 s 中是否存在 t 的排列
    bool checkInclusion(string t, string s) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
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
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
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
        // 未找到符合条件的子串
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def checkInclusion(self, t: str, s: str) -> bool:
        # 创建字典，记录字符需要出现的次数
        need, window = Counter(t), Counter()
        left, right, valid = 0, 0, 0
        
        # 右指针前移，更新窗口内数据
        while right < len(s):
            c = s[right]
            right += 1
            # 如果该字符在需要的字典里，更新窗口内字典
            if need[c]:
                window[c] += 1
                # 如果窗口内字典该字符准确次数与需要的次数相同，计数器+1
                if window[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否需要收缩
            while right - left >= len(t):
                # 如果子串合法，返回True
                if valid == len(need):
                    return True
                # 左指针前移了，需要从窗口内字典中减掉一个元素
                d = s[left]
                left += 1
                if need[d]:
                    # 如果窗口内字典该字符准确次数与需要的次数相同，计数器-1
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        # 未找到合法的子串，返回False
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public boolean checkInclusion(String t, String s) {
        //使用哈希表用于记录 t 中每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //初始化窗口的左右边界及合法字符个数
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                //在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;

                //进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //未找到符合条件的子串
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 判断 s 中是否存在 t 的排列
func checkInclusion(t string, s string) bool {
    need, window := make(map[byte]int), make(map[byte]int)
    for i := range t {
        need[t[i]]++
    }

    left, right := 0, 0
    valid := 0
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
        for right-left >= len(t) {
            // 在这里判断是否找到了符合条件的子串
            if valid == len(need) {
                return true
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
    // 未找到符合条件的子串
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var checkInclusion = function(t, s) {
    // 初始化 need 和 window 哈希表
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0;
    let right = 0;
    let valid = 0;
    while (right < s.length) {
        let c = s[right];
        right++;
        // 进行窗口内数据的更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }

        // 判断左侧窗口是否需要收缩
        while (right - left >= t.length) {
            // 更新结果
            if (valid === need.size) {
                return true;
            }
            let d = s[left];
            left++;
            // 进行窗口内数据的更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, (window.get(d) || 0) - 1);
            }
        }
    }
    // 未找到符合条件的子串
    return false;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_permutation-in-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutation-in-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>



