<p>Given an integer <code>n</code>, return <em>the number of trailing zeroes in </em><code>n!</code>.</p>

<p>Note that <code>n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> 3! = 6, no trailing zero.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> 1
<strong>Explanation:</strong> 5! = 120, one trailing zero.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you write a solution that works in logarithmic time complexity?</p>

<details><summary><strong>Related Topics</strong></summary>数学</details><br>

<div>👍 766, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=factorial-trailing-zeroes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

首先，两个数相乘结果末尾有 0，一定是因为两个数中有因子 2 和 5，也就是说，问题转化为：`n!` 最多可以分解出多少个因子 2 和 5？

最多可以分解出多少个因子 2 和 5，主要取决于能分解出几个因子 5，因为每个偶数都能分解出因子 2，因子 2 肯定比因子 5 多得多。

那么，问题转化为：`n!` 最多可以分解出多少个因子 5？难点在于像 25，50，125 这样的数，可以提供不止一个因子 5，不能漏数了。

这样，我们假设 `n = 125`，来算一算 `125!` 的结果末尾有几个 0：

首先，125 / 5 = 25，这一步就是计算有多少个像 5，15，20，25 这些 5 的倍数，它们一定可以提供一个因子 5。

但是，这些足够吗？刚才说了，像 25，50，75 这些 25 的倍数，可以提供两个因子 5，那么我们再计算出 `125!` 中有 125 / 25 = 5 个 25 的倍数，它们每人可以额外再提供一个因子 5。

够了吗？我们发现 125 = 5 x 5 x 5，像 125，250 这些 125 的倍数，可以提供 3 个因子 5，那么我们还得再计算出 `125!` 中有 125 / 125 = 1 个 125 的倍数，它还可以额外再提供一个因子 5。

这下应该够了，`125!` 最多可以分解出 25 + 5 + 1 = 31 个因子 5，也就是说阶乘结果的末尾有 31 个 0。

**详细题解：[讲两道常考的阶乘算法题](https://labuladong.github.io/article/fname.html?fname=阶乘题目)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int trailingZeroes(int n) {
        int res = 0;
        long long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
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
    def trailingZeroes(self, n: int) -> int:
        res = 0
        divisor = 5
        while divisor <= n:
            res += n // divisor
            divisor *= 5
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
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

func trailingZeroes(n int) int {
    res := 0
    divisor := int64(5)
    for divisor <= int64(n) {
        res += n / int(divisor)
        divisor *= 5
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
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    let res = 0;
    let divisor = 5;
    while (divisor <= n) {
        res += Math.floor(n / divisor);
        divisor *= 5;
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_factorial-trailing-zeroes" data="G9MQIByHsXvkgFmEMmv6LbvWrF5fy9duNoDhQoybEBtohAadkG1uFAtz3PFJymJKznCyaL9XQIXggCZodBSxBhfh8nf33oSxjLJ8r4CkotrI2gptKr/vMtwEnlaMjwzrYPomNbv9V+m9cxCNiNDlSX9g4FGScqa6IXzU0Of1vqq4lO/aLRoMKb7ZQa7/TMSKZWMpJmNVsLqqDSRdkeulYCaIqifG2aitSYnt6oSdZcnioltZcKWR7diJuTTq+c6rn8+XDRUsP6cWJKXmuCy/faHUzdLg69RbwbU2KZGb0ZTHdOcHkgypDWKo1w9Dqs+2viZTwT7bBLN5SPOs43YNQSf2ry1Ml99B2zOgmh8qDFY/8bJn/GgIjcPPl+iu+3zNipMySrcyzznlfHsuA0Cx/lMsvXizXT1C4pIPDu3BkpGsiZpbLTz9/kGjf/jx5Q/1hNso4u/8qP12iGKkdDdq+5/CMN8vjMU5arGL6tpFB0aGJ+EH+42g/5GggnpEC+EJ527eIEdiZGfM5jGV52thfWjoGnaiqOmet+C1vOAiD5F5+X156/mSSW8XA7FBVEacdDW3oDAR2l6GURHj1ifxacBI3MH8W0KwhfPNCJ3nQt/nHBa5nlwSB3Ox2AwpZozrdu8v3C4giyK66NoNuLKq3GJYyVj3VSGDateEAmzBmdYU5wIjm7q0+CFHbOtWdxrl/uqVC0IsoK40Y3vQZKyYp+rXz0JwIEjmRRbI4vrJ6K1rtfU9SQqvHC+ljjgnkPRErs9OrtDOOG3dkJJiUlBXWr2cA0zw2LCFgocP5iy0XlooeMAQEmPQ6u6eEbIPecWEF6kpvIy5Gr9Dc7E+w0HJjETJPRM2mDl6z89vbwfgUDsvaRFCIIvIrLSLSIbzmWoq3tLcwcccK7Uu7lunXG83SkdWwg4/keaNjYJuUOb3fwsu2ZIuddvn5NVY0xVgdAj8rDERskMLZVETWtbzEIJNyLBXW+w9DQrIOttCxbAUMgyq3t08d8JH6Llh3XZFufEM9erFc2aBFTA+D3g7IMg876SBgyTaCIUgTbj3o4gAzHNnreHkBcoD5E99B4ouRuLS1OQGXGd77akD3rDZmUWJtXRmd6/NsSQKLlwPy2RA51V35BWSSNS6Horv2oha0aONb30DRYohMws9JPT2/vz2dh7GDWowbAFDfpjbsnHPBcKBAYu2bRsQNl2BxlLIXLDOnFTPWxAUhJl1koVBCKhgvd3A2augIA1OKzZwoBqmuDMiK8i4XAfOWNdYltazbqjLRGBDbKTt016UM4JpsGrY8xu6FjzCgWlQAc/8DzVm771P4N6r9BCSagueIDQVTdQN/3J5cnJ1RclJ8iRfeGqXVt8+JASxDAyOOv3B5dUVLcWUxElurNh3gI6THe9LkiRxME8mDk9n91910bAIJJXbv0sbrG89eJhgklXJ06cPKybuoeSSzBwTOQTnu09EmD48NEUJPgFWHe7PFTmZri/cfPWo7eRRqcf3tdxlccTra42nBc3Rw4b/FA=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_factorial-trailing-zeroes"></div></div>
</details><hr /><br />

**类似题目**：
  - [793. 阶乘函数后 K 个零 🔴](/problems/preimage-size-of-factorial-zeroes-function)

</details>
</div>



