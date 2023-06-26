<p>There are <code>n</code> bulbs that are initially off. You first turn on all the bulbs, then&nbsp;you turn off every second bulb.</p>

<p>On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the <code>i<sup>th</sup></code> round, you toggle every <code>i</code> bulb. For the <code>n<sup>th</sup></code> round, you only toggle the last bulb.</p>

<p>Return <em>the number of bulbs that are on after <code>n</code> rounds</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bulb.jpg" style="width: 421px; height: 321px;" /> 
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off]. 
So you should return 1 because there is only one bulb is on.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>脑筋急转弯 | 数学</details><br>

<div>👍 358, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=bulb-switcher" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 414 页。

因为电灯一开始都是关闭的，所以某一盏灯最后如果是点亮的，必然要被按奇数次开关。

我们假设只有 16 盏灯，对于第十六盏灯会被按几次？

被按的次数就是 16 不同因子的个数，因为 `16 = 1*16 = 2*8 = 4*4`，其中因子 4 重复出现，所以第 16 盏灯会被按 5 次，奇数次。

一个正整数 `n` 的不同因子有几个？就是 `n` 的平方根向下取整，也就是这个问题的答案。

**详细题解：[一行代码就能解决的算法题](https://labuladong.github.io/article/fname.html?fname=一行代码解决的智力题)**

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
    int bulbSwitch(int n) {
        return (int) sqrt(n);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def bulbSwitch(self, n: int) -> int:
        return int(n ** 0.5)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func bulbSwitch(n int) int {
    return int(math.Sqrt(float64(n)))
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
var bulbSwitch = function(n) {
  return Math.floor(Math.sqrt(n));
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_bulb-switcher" data="G6kLABwHdjPXwtW4QrfxUoj8mWt/uu4RPKLLF5UwTETbvgSzpWvkw0OOig+///2aaGPpKndTIVoJUOrMPC6qH7co+vYt5pFkjUMiVHKiFGzEprrMQ/jIDXPh1oDnzZn1/4u4xJZZG1jDwCk5O+ocQqS+3o8Ov1ZmSvyHo1aljeZ+h4U/U8TKJrqwJ/6q+KI7n92Yic4kQS2T4oLTpAHo/Uf/Od0R1AibrLQE3Pqd5Ru0zAevfn56fozQDj5+ns7Bm8vhQ29fCFk4CvSejiq37xgA4xoPdHi4FYxHNxDf9LctJN+RooMKC3OgcJln5Kfm0Y8R2TNMbv9IvCcpQRwpJLlQSkrCt1/pbV16Ju+wtXB8+QdPoLp4OCSdxy1ilNRn/IL8zWLSOcIv/Y9iY4Q2QLR846Lmllnf3htcz4cMHHVridwwWdKTBTYFRbZ9jyc4gSc/2U9biHksrv8tcJisZ9c7lJGYumEXPMQYG4pLdrK0gi0e4sg086veHHEnPyuXGPKCiZjAln4RhJEVeqtSIw/QuPShepg8wjDamaW+BKFDxk4ztDev5m6FwSIUMoe2ysY/5kF3P+t9jhYOcG6CxXLSbIhYINuY3QgiJxmiaGByj8a0w26MeDyhtFKJjeSPIF6d2VDlTW6xUAyM+r8BIgTZxRD93wCOt06yqDJpYFd+sS8s1gS6ra6p0jb/AM7s1R0fLBxJhhfalzU+hVd+fnu7xXFqGZLTE4LKafGidZyNf3Qmqt7C2YybZSYaXtwyXfiBA3H2sn7xs8KZClJYZah481t8J+keVc8vYLGLu2VyNQnBzkudd5cGKIlXNc0hSQuxOLFoMA7emmVrJWlAMPQepFUL/+T5bJcRAx0GbbJEz2o+BRnlzJHgiW55u4UUfSaiPixFIo9/flJu5qMdCEJPkzWmBJE5g/Lke0QQrQ1KFLkTmO2YWHBCE/rb/nUhJJ5dvbJPmcxKuvGXcoPuMKTlVxVskdGN/9O38AorXogt+hYTZGk5nQ7R9xB/fnuLw5DOp2zql5MQ38i9vhiBCQorjDYtAjxjWlj5k0fU1JR76RxgaAVBSAWBEGyYSYjq6au8IDduPYxgC1umYhhKnWC4Mj0P6DNP1MZbmTRq4njfhwxZMFP9aYvt68Knf0enHy9nlvIE7/mfbfSup8I1Y+A+K1X9+NbsVFxR+/xlHyGM62pr9eRXl67bkvDU/Qogqx5wp/v5fYxrZcArkCSqzMzB5uqWyP2N7RfT9ePcOj45I8zbPGi/fyPSJud49ifc1Yes+zcopVjWldzT9cvo5BwK6akRuQc="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_bulb-switcher"></div></div>
</details><hr /><br />

**类似题目**：
  - [292. Nim 游戏 🟢](/problems/nim-game)
  - [877. 石子游戏 🟠](/problems/stone-game)

</details>
</div>



