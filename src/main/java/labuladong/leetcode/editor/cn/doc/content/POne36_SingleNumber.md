<p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [2,2,1]
<strong>Output:</strong> 1
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [4,1,2,1,2]
<strong>Output:</strong> 4
</pre>
<p><strong class="example">Example 3:</strong></p> 
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li> 
 <li>Each element in the array appears twice except for one element which appears only once.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>

<div>👍 2888, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=single-number" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这里就可以运用异或运算的性质：

一个数和它本身做异或运算结果为 0，即 `a ^ a = 0`；一个数和 0 做异或运算的结果为它本身，即 `a ^ 0 = a`。

对于这道题目，我们只要把所有数字进行异或，成对儿的数字就会变成 0，落单的数字和 0 做异或还是它本身，所以最后异或的结果就是只出现一次的元素。

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
    int singleNumber(vector<int>& nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for n in nums:
            res ^= n
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param nums: List[int]
 * @return: int
 */
func singleNumber(nums []int) int {
    res := 0
    for _, n := range nums {
        res ^= n
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let res = 0;
    for (let n of nums) {
        res ^= n;
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_single-number" data="G8MTERWaiyB0JMbGMp9a4263CKWvpFR5U4j8LZd/umb2VEmnWIR+04oICw8LgayZG9s8DiEqWltdK3tY+0Uzb95sSIHmJVAJkXlv/2CWlo+ce1w9cW2Qr11O1xuyjDlF0F9/ML5nNTqHfvfi7sDLQU0MiDMvB937g4FLynILDeqxSF/MedZwmd7/eLcN1ullExji34nYsIRTMYxWA3twejDmssJ8UxKkp2L3ovk/1nZ+3XDJ+yCWfauy0cldsS9RTCm022XSnGDdJe8TTwzS/Me+GEsbSF/4e3v2qw8z0H+jnkTpX2pYOfxtzSGVfOgVXZz+SvfipB29BPUDmo6oMl2pEGZqiUuYuU9WUNwgm1/cEOQWzzkS1/eUwW5fcjlFvSOCafLGG04P5dV/f25qz9gZKcQzuDtdGB+UvPGxGSu+0z2Y97QViHIQd3eQbUs/rr9s9FdP/5zdODc7yoW/Tngo8RsfqH2xp6Lasaj6Y/flnspqx7Lqj7s/Xcm0P87+U1X+DYv/wdU3f5ckuea+v9cdK34x9RSXj/lQThQ3KAZ8NzVz1zB3TNQZN7mS65XamKxu+wufmEUhOotz7ixpZulT1cz3p22l27SJAsrDCgrrcB022OApz2B0vT+NOdfcFs/EmURXEx0XDyOCohsvFKTomniHPdj45ZSQtK3Bvi8vgSlY6Dbu3LIHFNib4GBFE3xTOerHFxJwHanrAtOBOoxIVyLjk1CP1HREKnF5A5Ggae2A85O/IQm7IChDlbihS2Hakolrf6YUQMQOExsk9yPdUtjSNdRLXpXAmHHWkENCLWxVpRSUWKsBY2Vx5YXwSsBrX2hjrpBEFNxi8eek6IGsGobJn5MChg2lUMbskaIgqSRIZIcUcQY4l5XHvxDHYn7CqBEIeECa0mKmeZJvuL06lOicqxyPxAVBAE9rcgWVwhBHZOdhHAeMy6KwllyC31wTTxtIZRXQH25dHNcpCkArVd35EHxurJxszT4Bl6p3mKzHGfBzWntRTkNQ0tsXphMZNaaYGsxUnL6MWuAKuaFK9glXvvDvdn4F0XagtGGpvKbhT2eGVDxntXMl6LnLoQSIViOy95BkIegZI3hp4m6+kxhE6irHqQULiMg8cg0ADEpNCjJaJXCdM9YiD0wYOzuNobXZ7Ja5cyHbVpKgfHE10KQo+dG/LgqSTlA+dwzHOSXAa1vbr0CjzwMWUQUyKbi9OgRjIi01peL/koANWLMhIaKpy6IeGcTWIUinD8UzXTNtyydNIhSx8KUiAS8GafGlCd3o76agFs4kS4IUvk3xEzRwJQKamzqYPvXKy5XOzJmQuPQtOf82nBzVaIMCuc7voc+/xlE0GILnnrca8SI3Zl/1afOr7cf8ZhttbG2+XWXKuK2MTL3qZHib6X/s7+y8vMRsJ/v+AsrMiqh16Hk2GcHDwU7uK6jpDWByX5C4l9gJSr4JlhjC7Ww1dGRZFg5kQxjpWUGfnrVfZU7Q7zFLOjPBweqJN1UTZzd33T1ESODUZhqvictfkrv9i7Mu3irlyHmz+rr9KfwCkp5Jey4cTiL1jscfS5se"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_single-number"></div></div>
</details><hr /><br />

**类似题目**：
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [231. 2 的幂 🟢](/problems/power-of-two)
  - [268. 丢失的数字 🟢](/problems/missing-number)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



