<p>Write a function that takes&nbsp;the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">Hamming weight</a>).</p>

<p><strong>Note:</strong></p>

<ul> 
 <li>Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.</li> 
 <li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">2's complement notation</a>. Therefore, in <strong class="example">Example 3</strong>, the input represents the signed integer. <code>-3</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 00000000000000000000000000001011
<strong>Output:</strong> 3
<strong>Explanation:</strong> The input binary string <strong>00000000000000000000000000001011</strong> has a total of three '1' bits.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 00000000000000000000000010000000
<strong>Output:</strong> 1
<strong>Explanation:</strong> The input binary string <strong>00000000000000000000000010000000</strong> has a total of one '1' bit.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 11111111111111111111111111111101
<strong>Output:</strong> 31
<strong>Explanation:</strong> The input binary string <strong>11111111111111111111111111111101</strong> has a total of thirty one '1' bits.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The input must be a <strong>binary string</strong> of length <code>32</code>.</li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> If this function is called many times, how would you optimize it?

<details><summary><strong>Related Topics</strong></summary>位运算 | 分治</details><br>

<div>👍 589, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-1-bits" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

`n & (n-1)` 这个操作是算法中常见的，作用是消除数字 `n` 的二进制表示中的最后一个 1：

![](https://labuladong.github.io/pictures/位操作/1.png)

不断消除数字 `n` 中的 1，直到 `n` 变为 0。

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
    // you need to treat n as an unsigned value
    int hammingWeight(uint32_t n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
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
    # you need to treat n as an unsigned value
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n != 0:
            n = n & (n-1)
            res += 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
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

func hammingWeight(n uint32) int {
    res := 0
    for n != 0 {
        n &= n - 1
        res++
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var hammingWeight = function(n) {
    // you need to treat n as an unsigned value
    var res = 0;
    while (n !== 0) {
        n = n & (n - 1);
        res++;
    }
    return res;
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_number-of-1-bits" data="GyUSIBwHTpmveHBJbRGLprf6UYvsrKS837vs65eaQ4j2TGtnWhvIIAkZsuJvnW3FQgDQ16XsTMl7///3+yWe8JDE9iIl0+SJRSPEf869bFQfItrwi4xrUg916tQwuU1EFvGcmXp9oWvS681nN37r/IwiEL6ipzd/YODFW8e9KRqCRh96B+9dJUvR/sMDlZBlt9Yg4eBnIlZSvCkMH6uCtzroOk82+aJj0aHc8bMSaqg3iYBPnQEtNmx6UHnqDVmfVDDWjjeveP/z05vOI9S9qZmQZpig6L54S82k6SrXUGBl/pLepFsicptue0NiIAVBnujB6iPXcZg/Jomylx7iqHUL+EfF40p9UxRn/fjJjvqlBQuPGy2JO/Bhl4VMsudDiR9LAlB4TodRZWCk9EYiU+YZ8kmIhIXLjFJibniF8Tc+fLp59+kHv46WUyS+JF0ZRUOwHkdKkbbImeaZ1SWFj/tMVHVGd3U+dnVJUXYmVnZGmZ0PZjlvajjHKcwvNv1faN2k9qpIDKepg6t81HIH82up6tjKb1/03UeaBLMOdXrSWhU/VskNa5LztT3vZ7cu23rzYVEUUdBKU6z29jUhMKHa3MZMWu2HPsGnCqBF4B0XRMCQHy9qLJA39jonMN+2OMasCGBjtGQBn1vNR3/5ZYeZ8KW0ZmeOmIJvlTHuskAfkrquCwPPFlprZTTYPju0VYFgDOssMEurhNT+s/o+RBjDoSgnYORclgi1DPYHr2MMCKxA0+amNxYvlhgUDWqTEGgo0KsaJcA+GyxjkMImoMoeFqVUJk1YFqCKA9ew/qyw4CoaRhdxoYm3ZekkuogDjElHbdS4B44atTSVpC3YUSzPXegbjr+CxjBfoHUHidiPXE2879v0OT+/XVSYYK2lWAwJAbiOWomkEoouLylLvqBx+GDhVMKli/0KMFcj3+JdVsZP/PQ0LmUU0HfQX/8CvKqiDQrvfURepw+FK9ANX4WyNnLMRybpoypE5c5h89IFkcXuuVronczyydMPZpDwhr+/8iZA12ONDC7BrvJee9s7yVkZcwsezQ0uqoR5XgaJbSI2aEIx0DrNR2+gB3wIEHVFJmGYhl64u75jgYVuiyjxfg6RtToQwXHgIWwrkVTTv8yungt3vI+Q2uSuWfYuLbtm3nsCFwabXPRVC1qTWy3UU9/QlPEVurC/Rh1r/PntAlzDtESyjI5EdECqFMYhMa/e5W3hjyYD3kleG+cKdphza8v7TQiKXhkN4p5ECKCwuvX86L1WEIHLA6ttKEY/wacOlhQZ6wTEFsrqhptkjo98ZUJzkTiJiDbq9SiHS2rjR36jik4lA50EBNz6X9doO3/TxtHbzbVOqtGp6nRTEUTFKE5Ah00Wh8NK/p0O2Or2lhhj7OyMLeIkpIl6AfyBGIwYEJuQV4/q4BaTEL5riCP2jPHumv/ydpzYxrOe5OvWQGg9YrsIPjhhYnVCUO/Rm5b1qXHlEkoEKABfPxRwHPTjOs94trgvdJCwWTejQL23aTihse8MfN63Bg=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-1-bits"></div></div>
</details><hr /><br />

**类似题目**：
  - [136. 只出现一次的数字 🟢](/problems/single-number)
  - [231. 2 的幂 🟢](/problems/power-of-two)
  - [268. 丢失的数字 🟢](/problems/missing-number)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



