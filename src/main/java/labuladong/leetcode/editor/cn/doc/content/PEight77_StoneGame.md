<p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>

<p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>

<p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [5,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,7,2,3]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>2 &lt;= piles.length &lt;= 500</code></li> 
 <li><code>piles.length</code> is <strong>even</strong>.</li> 
 <li><code>1 &lt;= piles[i] &lt;= 500</code></li> 
 <li><code>sum(piles[i])</code> is <strong>odd</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 动态规划 | 博弈</details><br>

<div>👍 504, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=stone-game" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 414 页。

**这个条件下先手必胜**。

如果我们把这四堆石头按索引的奇偶分为两组，即第 1、3 堆和第 2、4 堆，那么这两组石头的数量一定不同，也就是说一堆多一堆少。因为石头的总数是奇数，不能被平分。

而作为第一个拿石头的人，你可以控制自己拿到所有偶数堆，或者所有的奇数堆。

你最开始可以选择第 1 堆或第 4 堆。如果你想要偶数堆，你就拿第 4 堆，这样留给对手的选择只有第 1、3 堆，他不管怎么拿，第 2 堆又会暴露出来，你就可以拿。同理，如果你想拿奇数堆，你就拿第 1 堆，留给对手的只有第 2、4 堆，他不管怎么拿，第 3 堆又给你暴露出来了。

也就是说，你可以在第一步就观察好，奇数堆的石头总数多，还是偶数堆的石头总数多，然后步步为营，就一切尽在掌控之中了。知道了这个漏洞，可以整一整不知情的同学了。

当然，「总共有偶数堆石子」和「石子总数为奇数」是先手必胜的前提条件，如果题目更具一般性，没有这两个条件，就属于标准的博弈问题，应该使用动态规划算法来解决了，详见 [动态规划之博弈问题](https://labuladong.github.io/article/fname.html?fname=动态规划之博弈问题)。

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
    bool stoneGame(vector<int>& piles) {
        return true;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        return True
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func stoneGame(piles []int) bool {
    return true
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} piles
 * @return {boolean}
 */
var stoneGame = function(piles) {
    return true;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_stone-game" data="G+gLIBwJdkzkB4rGFQ5KkZS+vzXfTlePSdadQNcttamzA/Jo/4GmFd+m1+/ZeQuBsbWlRqWtlv//+/2CJN7F3kc3lvJflMCitH/OuWxUH2JWL6oznpA2YqGS0zzEaV2JEt1PZZt2M4LZTY7uDb0gIpb1jfADAy+P2hGwIWzU0LvIdFbFUrb/8Z9rCutoa0Xw34m4Z8Rl5viTKbViWoiZjiW+aiXOWaaRESrnfxoUaVWvgB3RjOWlPFI4Ksp7g2IpKOy/Ui5aKni9GAXRlaKgF83pHDH0wqufn543IWlp87o/q7NmDdr79oUc06lXfU6Dkr7mCGtCODkOlm9lqinWEYokgsWm+MUv7WjbKUzYz2p85jVlFpV92DaZqLwO8yFmmczSBEU7JaSZ+ziBtSTiKHEmldEZlXPOzcXqczfotBNNZMqUbRNtmvhuEksSbRxkbliavm2NNwi17DvotZrpVWlr9kRhonA7HXl0nkc+mU8Fyq7MvuttFWAknV6VyFUKecldWGyZsdVSkcz/YAZOS+Djv9J1g62lQOdBsodY64X5acwizJNtIHRkjSPFDpQ2kw08RbDmIzOD+U4oDeSevMLFyIVGiVS8AisBAwqY/c+WBcHUGh2ipxa6JuClcaF2tzcvC3beV6HKZAVRy2LcXfLYYinBwW785+MzKy9MCTpZoRifI2mCD2MTMEQiNMGHgHGTSp0SmB5SIntSZ0Z1DhNgrKxZ4y/UU3PZo0UDQgLBQ8BYWLT72s9vbyUOVtKjhP6EgD2NUiiRE9BXDrTkbT1FTGEFUevivueFbzdwMkvsWz9TPe1sVCCjK5e/Ba/TnGrm+whVZeXWq2OEU9oSq0n3GGe8I33u4xEZKsymiC0+fKzzc29ZFCXgXYlV9fsvz9GUFRwzLOw5CZ+l0B4qztq3ZsPYXPG2gBEQXkiKJZrk6X0MDDU730I/jdqgmOxnNXu0VucAAAcfZyHuPiDWOivGAXiA21pBF5MzO3+J7qBTQbp7mjKfJWozMsdSNdFId09QT4x17SVBWfO+gYcIz3K3g6jV+M9vb8H1OKKPpDlnhqlUpFGhoubdgrWDiqvyoC1OygbKnF4fPavQ/hi5jZ8brDC4iypMJ6+CgnOQF+mYZgtTbIIv2nIXz2cN7aN3di/Lo11mYLvQydUG42k+SUEouzL2GyzNvDBg1E/A7UOo0XHvyVyOHYNdhh8dW9ispPQWror5Xxi4NE8sBd/K+43DEBBrc9A8+aNN601EemaYtiamZXD3SaP3xgYgLRuk6TCTjxSMBB2ku1EBwv3mpn3QNPRAmSPKNlaNIJz+7+7cQ6He3Btky1vRyqn7Gnbxfi30XHh8VqP48SHbAA=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_stone-game"></div></div>
</details><hr /><br />

**类似题目**：
  - [292. Nim 游戏 🟢](/problems/nim-game)
  - [319. 灯泡开关 🟠](/problems/bulb-switcher)

</details>
</div>



