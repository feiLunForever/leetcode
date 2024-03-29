<p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window</strong></em> <span data-keyword="substring-nonempty"><strong><em>substring</em></strong></span><em> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window</em>. If there is no such substring, return <em>the empty string </em><code>""</code>.</p>

<p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "ADOBECODEBANC", t = "ABC"
<strong>Output:</strong> "BANC"
<strong>Explanation:</strong> The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "a", t = "a"
<strong>Output:</strong> "a"
<strong>Explanation:</strong> The entire string s is the minimum window.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "a", t = "aa"
<strong>Output:</strong> ""
<strong>Explanation:</strong> Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == s.length</code></li> 
 <li><code>n == t.length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 2593, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-window-substring" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 85 页。

这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置***/
        printf("window: [%d, %d)n", left, right);
        /********************/

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

具体的算法原理看详细题解吧，这里写不下。

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
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = INT_MAX;/**<extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/1.png) */
        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c])
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {/**<extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/2.png) */
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d])
                        valid--;
                    window[d]--;
                }
            }/**<extend up -50>![](https://labuladong.github.io/pictures/slidingwindow/4.png) */
        }
        // 返回最小覆盖子串
        return len == INT_MAX ?
                "" : s.substr(start, len);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import Counter
        need = Counter(t)
        window = Counter()

        left, right = 0, 0
        valid = 0
        # 记录最小覆盖子串的起始索引及长度
        start, length = 0, float('inf') # <extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/1.png) #
        while right < len(s):
            # c 是将移入窗口的字符
            c = s[right]
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否要收缩
            while valid == len(need): # <extend down -200>![](https://labuladong.github.io/pictures/slidingwindow/2.png) #
                # 在这里更新最小覆盖子串
                if right - left < length:
                    start = left
                    length = right - left
                # d 是将移出窗口的字符
                d = s[left]
                left += 1
                # 进行窗口内数据的一系列更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1 # <extend up -50>![](https://labuladong.github.io/pictures/slidingwindow/4.png) #
        # 返回最小覆盖子串
        return '' if length == float('inf') else s[start:start+length]
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 采用滑动窗口方法的 Go 解法
func minWindow(s string, t string) string {
    // 将需要匹配的字符及其出现次数存入 need
    // 将滑动窗口中的字符及出现次数存入 window
    need, window := make(map[byte]int), make(map[byte]int)
    for i := range t {
        need[t[i]]++
    }

    left, right := 0, 0 // 定义窗口的左右边界
    valid := 0 // valid 存储满足 need 条件的字符个数
    start, length := 0, math.MaxInt32 // 定义最小覆盖子串的起始位置及长度

    for right < len(s) { // 当右边界小于 s 的长度时
        c := s[right]
        right++

        if _, ok := need[c]; ok { // 如果 c 是需要匹配的字符
            window[c]++
            if window[c] == need[c] {
                valid++
            }
        }

        for valid == len(need) { // 当窗口中已经包含了所有需要的字符时
            if right-left < length { // 更新最小覆盖子串长度及起始位置
                start = left
                length = right - left
            }
            d := s[left]
            left++

            if _, ok := need[d]; ok { // 如果 d 是需要匹配的字符
                if window[d] == need[d] {
                    valid--
                }
                window[d]--
            }
        }
    }

    if length == math.MaxInt32 { // 如果没有符合要求的子串，返回空字符串
        return ""
    }

    return s[start : start+length] // 返回最小覆盖子串
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minWindow = function(s, t) {
    const need = new Map();
    const window = new Map();
    // 统计 t 中每个字符出现的次数
    for (let c of t) {
        need.set(c, need.has(c) ? need.get(c) + 1 : 1)
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录最小覆盖子串的起始索引及长度
    let start = 0, len = Infinity;
    while (right < s.length) {
        // c 是将移入窗口的字符
        let c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, window.has(c) ? window.get(c) + 1 : 1)
            if (window.get(c) === need.get(c))
                valid++;
        }

        // 判断左侧窗口是否要收缩
        while (valid === need.size) {
            // 在这里更新最小覆盖子串
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            // d 是将移出窗口的字符
            let d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d))
                    valid--;
                window.set(d, window.get(d) - 1)
            }
        }
    }
    // 返回最小覆盖子串
    return len === Infinity ?
            "" : s.substr(start, len);
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_minimum-window-substring" data="Gz14EdWjDwFoecAdVj5OFdSFSQj9CkLtQGF1aV4t+Qjn2Pl4eyHyOv+nvXlxeV06ROj98uvnUtk3pxhDuwcAP8WfYoDcTYRzrTakVtlEmCTzVrVr86DHCWIvPtRR4xqx3ir+YpsSLZcAeVFU2ZQz6wOD80Ku0wEkyP5/a30uYdLjQqhejo+MWqAOQf+caAJhUu/13GWYALDKSVdXT30gckFQrGJdhIuUuzzV1VH8GJphxrzdqrhQ8/H60PHk4wGJ9/jH7vOuYuLlj90H/ISBZyzIc3QoQ5zqO9TLpxkZG/4dz2yQ9McEKJJCEe8Sdp76/hJorjjI/4tRJgc4LDNiaqp8BNf2Bz0naA8cSDFmRvaBb/CznEGZYvRhxcvBABdd0AOzr0R79/3AjScf1tIjRtX10AMijZHEHyOkjV7mZiM/Ih5UgiaHD1BBrVi8aCXR8U4ywmvJ8XUXL9hV3WZy0oAHXlBSK3cU94srUFo6fsMSLW//e19lDGsrpZFjcNpqMBbsavZukypdJCNbmy8eYgyOZ8wELBd0yjgiQtn48LQ9zkLmllW8RyX0xagBtXNqikcQEqgW1kotRVMVKiGvtQHhVS6aYBQc2l8fbEklohMr60llIuFJQV/KWpkaXVQZcHMOOUomry8QeCSBLzA4wGAtkcbQbv1wYH3cbyKyjcJFPvy0Ny7kDSHxYf2yC9w3RJKPt5ddMHdDbI6d3XgKLpq84+hPUv1zPo4iWuyyQTdcdS4LzPNto7Pjq/+XUaVVVKPuj0fweKkBJ3cae5ntp18OVwf8wo6tnPPNOQVuftFkIDnEYsBrKCSAJqjur56ojloYg+Gs/vlablCMUrpOhQHCvnQqHD8bj62AvrRufam6FAYOG4izTce+hJdsxv4ZVbpKVyvoHXOVVv8qmLjq0i4RIFxABuq2kB+jFwbVCNR91x062l5OWifd6o6BL9416On8dAxXHrszgBCJdDu+RErurKGQFLhDUDz46DDfCHKCwAsJiiWCO0MoJBPcYSgeqlrPN4acYPBCBscF9XWOJnJjdcNV++q+Rsa42qmR9VcyeJEWZ4FEgMTYrAO/Bs3ux6fjgar6QN/HDTaufbofym7swKpp6RzcKmTUxn47thfb1x4SvbFD2K0PD+7ROF4dGhtc32A30y4Y6nA8uw9XM+8/ZEYQDOZc/z4q8QKHJUzm3ILQ9YOj5C87hb0VT6M4Wypdpc5RJ+/CCxj1G6HAt9K2fzSamdsQmgsFT1vaLVWZ9dQYYqCwo197hztrKCQb3BlAITngzhAKySUldwj84M6xwT9HZFNSQPej+mQPkF3FURN6j1g4WityWrAyhSwfUEvgca533LhjwF9FRsG/shFy1ETAn3L4xuBj27ai/mKMhir9iGnicGYAIRKRdIxCTfl8gzNr8FtBPi84Q+ABbnRdmcJXOMorApD1ERnf5lbQWhGEw1ZReeAqFY577Reu9ia07li2CQpzxiw2nRmC32b9m88NzjB4QEF+8BueCgMGP2EoeBjcWUExya/udofhryLV3uQvDCegfl1SSHPM1EpQVPaZCmcG4LdDTF5VXylZEws1W+AndRbabxe8KrNlTRzUbIKfZFu6dxyEz5B43OB8vp8QNEEOnMmefN+r2fatFGArzNmQzmco3JV0khVMaez4RU+QbFgzFXjyW56sZ5Y/JmclWkwMi7LfS6lrnLJUqQnjJiO/pOy8FHbY4z7fqAcIeURlhka/hemE7u8fqJc/p0bl27L5Fy+lPixKcMtiH0pVwprKj/J5QjHxs7KClwOpf87HjqmLoYI//41kKfZXEwXNhx6eigPJnrCwQkcjDEmPnvD/Qjiseot5dGGnDeexha0WOmp61FKWtQcz4epkWTwgLNRlcxemYOio5k2J+axNuFkCjpFrMhNCwF3hYttNeDeJrAY8k43QtTB4m0+OK2kROBodhYxWlGBAmAi9qZ9YUGus9ET300T2bHS0ZCVkmYIw0OvMK0EspRRDNCtbUWIppeiTW/aVZRxKGy9GjgPc9lK6lzNF9R7yKfgn/L3Rbm5MxYctZSLjCDLEcTcdaEpfSTGgS0TBxUQuKGGYMJAnSGHg1P0Z9RO2QKaX+EeNlSQOkhrH/IDjN/9MJEUkUs6mp/qvco7pzXIXOoyXNXWSNhh4NbZqZr8aay51ymJQFD31k8k4/Xob4/h1dcFNwHNTgL/IpQ20WzVHOVvHg4RjTUX0CpmNxlAz98MrX1kHkvpG4NQHbbp7dP8eXcJWpAhIghSKzE3jO+ybDlGtPSn5ojRkr2ZSOHU1e68cWjvmswZ//UunWv8di9WewPeULa7F5iPIwMkwFks9GSHPuu0OZ89/2zr1Q7neL1uR2j7spvq3UyClb4g9BYPEh192aTESqqeHce0sJsmmJ2GLmFgeMctUGWna9K9WteJbmYzds+tOB79/3NQFp7eX12lK76RSkRttXnPErCYxE849vIhTbsyaFACslcBbj2L5oUjnzPqRc8tiW8km7AdZf+u92th28c0hsUHUraBErYKFxrakTmYBr6Su3VivyzU06r6tqRF3Gx3TvkoYxqi4V+IIRxfx5DeiPOIMHkK4ABBPG2PhUmLulZ+7BEtneiaE0bRp3l0qiWTxUoy/o+XY+5ZaR5Nxaa3wyXfAtXmwxD/P2O+xLcc7PPbLIQDTW4vH8vR7/uMz5PVUMtDms4rl78mhgi4qGcsbktfxqnAzO9WnFJTzLFOVatAzwpy9ocGhEDa08qPevNygvIwW2E+pO6afuucfuu7lgiXqsVL4b/1dGUo+tyJOHrCtMZWPWMpOyN9nj/hnXx8yQGphZ3/sfsdPz3P3QP+8P3dTKevcCp9EZ9K4RN+TCqI72i7MHqq3/Cuz/EaR1GXzXeVyo/CsnVOJphjjvoVPdgC2ucLHN2lR8VpNJg5CUl5jaonTsfwZXOWa5aq5k2J4kKIoRKBbklWSVgskaEOLoF9jk7Pb9mxfHnLhWCw/A9BXzc1TXpF2QjLwhOKzqgcc6HeHBedgiTYDPZkCKnSxuUC1G/s0pKHHCjpTZpvrmRHiA0aTyWYSTzeUNHftmAt0t1gqB7BpUdD1npEeEDTFd/sUaKbCVUszGa1KriQNpHSVQsFE3UslXGimQMlNJdSI17ILK+xspCI8iiV1GygFS1fQtgViY+p5IrqIfm5Am9Ikw0USl9S7k15eUAkpfP8bKHXDUGkhOMeqT27KI99l0Cd2ZXq1VcxLmAf+5KZQotJN+paDJ1R/"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-window-substring"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>



