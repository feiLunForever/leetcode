<p>You are playing the following Nim Game with your friend:</p>

<ul> 
 <li>Initially, there is a heap of stones on the table.</li> 
 <li>You and your friend will alternate taking turns, and <strong>you go first</strong>.</li> 
 <li>On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.</li> 
 <li>The one who removes the last stone is the winner.</li> 
</ul>

<p>Given <code>n</code>, the number of stones in the heap, return <code>true</code><em> if you can win the game assuming both you and your friend play optimally, otherwise return </em><code>false</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> false
<strong>Explanation:</strong> These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>脑筋急转弯 | 数学 | 博弈</details><br>

<div>👍 683, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=nim-game" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 414 页。

**我们解决这种问题的思路一般都是反着思考**：

如果我能赢，那么最后轮到我取石子的时候必须要剩下 1~3 颗石子，这样我才能一把拿完。

如何营造这样的一个局面呢？显然，如果对手拿的时候只剩 4 颗石子，那么无论他怎么拿，总会剩下 1~3 颗石子，我就能赢。

如何逼迫对手面对 4 颗石子呢？要想办法，让我选择的时候还有 5~7 颗石子，这样的话我就有把握让对方不得不面对 4 颗石子。

如何营造 5~7 颗石子的局面呢？让对手面对 8 颗石子，无论他怎么拿，都会给我剩下 5~7 颗，我就能赢。

这样一直循环下去，我们发现只要踩到 4 的倍数，就落入了圈套，永远逃不出 4 的倍数，而且一定会输。

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
    bool canWinNim(int n) {
        // 如果上来就踩到 4 的倍数，那就认输吧
        // 否则，可以把对方控制在 4 的倍数，必胜
        return n % 4 != 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def canWinNim(self, n: int) -> bool:
        # 如果上来就踩到 4 的倍数，那就认输吧
        # 否则，可以把对方控制在 4 的倍数，必胜
        return n % 4 != 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean canWinNim(int n) {
        // 如果上来就踩到 4 的倍数，那就认输吧
        // 否则，可以把对方控制在 4 的倍数，必胜
        return n % 4 != 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func canWinNim(n int) bool {
    // 如果上来就踩到 4 的倍数，那就认输吧
    // 否则，可以把对方控制在 4 的倍数，必胜
    return n % 4 != 0
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var canWinNim = function(n) {
    // 如果上来就踩到 4 的倍数，那就认输吧
    // 否则，可以把对方控制在 4 的倍数，必胜
    return n % 4 !== 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_nim-game" data="G+ILIKwLuEOx4hc6J5t7dfrVbmBiZQwS6MFSRcl9c8ngvJDr4NOJaFC+0PQs6spp/bFlUxznxvIju6A4MkfOEzRLetyeV69/37etYUQsu3UUKbLDlSA7Pfbffj/Rhie1OaRsIZJ+yffu/sEsift7i0okWRLPhESItMYWnjXz4i3VBubFgt71WavLXhRiylpZ+IOBQ2I+qGoIGdX0Zvb7rLKlZP/xl1FHsP5/YMH7TsStFpXB6x2Y659yQKeJdtLMvkolxBqmTgtE+blL9YFL/tehmoqLRfFBuHVRJg/8ON752rSzD7x53N+RE5SBtq1/42Igm+RyKqiMr7FAlkpc0O/6VBIcFUB00ls8Ed0HodMazZebAfLteWNkKcjSF4P+wBkvS0nE9hTyHnTC/P3Gh177eTTqvaspIufy2sx+sTdzUVYozQFpnLFH+zC+VBByHMf7ioWUc9ZuTlmrl/+i1+MNFv5uCq3kdJektQZOYcK7OZ27Z946d2CnwCPqU/M6MdCZbp9K/HOIywkfYRsQ0VUorTWOBVMYDbrvOUnPDZYRbbSuIXvMwpAZB4wZEgd0QaxG1jiykVBETDZYkmEzzi8zFBZMVR/tzo/agC+MAsrwcqtoWOU+rvzSWkWgGhGQqvFKvcJLwZDNrd2YQyFPICiYrHKb8dXeEo8t6ijFbO7yxwxXFW8Ue5MFPPE8EwHYQQbkBzEKArADDFOBe8UmdZQ4HWBiuMaRTT1TBUj8AbqFxwkZ5w7Fx3NRznEyqFuOD9YbmOyJxKsnBJOc9oJ2HA1uQ98XrNNtRUt5bmpc7Edd+MxGjpEdPHOc6NaYKIyez/XkdfCMDxA53Zu4LnN1mdQu8BkaFO/6CqQoearEzp1CBsdQTLF7DOijmacKtIKMekwq3+98rTAvOBHDNcws7V9SaJ3sTH9y4oHMKesFmLeQBH9YwkQe2jlRVOjZhgUAkr5qwyZhsBSZuHKIGW4cZxRMbh9bM6z61gN91Ka7YTpYs6OPapITBZK9gSlzHN+QDf9IBGFGewNQr3qkGKmV14wD9IhNmrRzQtcmPD5YB1eWFq+IYE5yKEkuORmJaWBsopjd2UCDFqMJgLLJXbKpm+4ICiU3CYkheCA5kdLcnm5+eAWxOGVl0C7r2YGdBhSlaDZQzxqOMBhz48pdbSaUhSXLpQU9yd2kkLFT0H2KI4K8dAzoCbjh0tdoXD2Gq8fCf59UEeSDvqkoolKUQD2DF37MlzX0du3lIGtLG9dum2+8/FtRs+05esRW2ZQADIPtH/1QCW1bqg/hvGq39MfsBpEQMrG6zSrFehqeMdLbyDu2lvDT4JwJG0v5dSj9WDbI/+0iu1S8/fXuSFIZeKPfpkQ2xB+u5xZd39FtmsN3NQA="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_nim-game"></div></div>
</details><hr /><br />

**类似题目**：
  - [319. 灯泡开关 🟠](/problems/bulb-switcher)
  - [877. 石子游戏 🟠](/problems/stone-game)

</details>
</div>



