<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at <code>nums[0]</code>.</p>

<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at <code>nums[i]</code>, you can jump to any <code>nums[i + j]</code> where:</p>

<ul> 
 <li><code>0 &lt;= j &lt;= nums[i]</code> and</li> 
 <li><code>i + j &lt; n</code></li> 
</ul>

<p>Return <em>the minimum number of jumps to reach </em><code>nums[n - 1]</code>. The test cases are generated such that you can reach <code>nums[n - 1]</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,0,1,4]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
 <li>It's guaranteed that you can reach <code>nums[n - 1]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>

<div>👍 2141, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=jump-game-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 376 页。

常规的思维就是暴力穷举，把所有可行的跳跃方案都穷举出来，计算步数最少的。穷举的过程会有重叠子问题，用备忘录消除一下，就成了自顶向下的动态规划。

不过直观地想一想，似乎不需要穷举所有方案，只需要判断哪一个选择最具有「潜力」即可，这就是贪心思想来做，比动态规划效率更高。

![](https://labuladong.github.io/pictures/jumpGame/1.jpg)

比如上图这种情况，我们站在索引 0 的位置，可以向前跳 1，2 或 3 步，你说应该选择跳多少呢？

**显然应该跳 2 步调到索引 2，因为 `nums[2]` 的可跳跃区域涵盖了索引区间 `[3..6]`，比其他的都大**。

这就是思路，我们用 `i` 和 `end` 标记了可以选择的跳跃步数，`farthest` 标记了所有选择 `[i..end]` 中能够跳到的最远距离，`jumps` 记录跳跃次数。

**详细题解：[如何运用贪心思想玩跳跃游戏](https://labuladong.github.io/article/fname.html?fname=跳跃游戏)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，贪心算法**

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
    int jump(vector<int>& nums) {
        int n = nums.size();
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        end, farthest, jumps = 0, 0, 0
        for i in range(n - 1):
            farthest = max(nums[i] + i, farthest)
            if end == i:
                jumps += 1
                end = farthest
        return jumps
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func jump(nums []int) int {
    n := len(nums)
    end, farthest, jumps := 0, 0, 0
    for i := 0; i < n-1; i++ {
        farthest = max(nums[i]+i, farthest)
        if end == i {
            jumps++
            end = farthest
        }
    }
    return jumps
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
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
var jump = function(nums) {
    const n = nums.length;
    let end = 0, farthest = 0, jumps = 0;
    for (let i = 0; i < n - 1; i++) {
        farthest = Math.max(nums[i] + i, farthest);
        if (end === i) {
            jumps++;
            end = farthest;
        }
    }
    return jumps;
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_jump-game-ii"></iframe>
</div>
<div id="data_jump-game-ii" data="G+UeAJwFdmP1QIt5b0J/jAPFKFWJrNzbln+68vbUOgHvN62ITAwmJJN0YbVtg7zslFVtMWU/vuLa7rZN6X8cBAQheILV71eeO04OVRA6aBwAaGDhsjPzfod+NoB/N8zlPwYY1WWFjVbRLhV1tAynQMUmFgi+cFL7jvhdo8g79GDnXCQkcmrnNfqFgdfKig0NDtGksb41vn2syFTzXzwjxRYffGygiJ4U8fYHZo6Oj8ANEk6ZcKs3ylxCKj6M6F7SuRspy694DpZR2qXjo4MiZ08sLfGW6iLcOVzxPFaNZbp/yWEQbeh84u/l0a8xWOD4ST0h4VGD7Nj9jf9IH5fPkfEjy6lrRBP3LkvY3pPHwXClOo9BK8kj2qIC1WlhcK2svmbjEiOM79G27J0pksPvyAK1hkm0ChrG2xTdu8HWOuXscEi6uXf9rS7W1LEzJV09QeiE7j0TSne3RryZHV2XMY5kFiaOq72tibXBXvcjkI1NuvvahOQiEFz49+fCtBGIlG8cIxQWj3TjmsSCFLeQZxdOMJFNqpZTzk5AU7d6Oh4a2/bj/BS1P3P45+ginLJmMdrSjVPX2cd1288rFbULY0R2fxOJUdxcd2fM8XR4XfVUve/Zsi/9+5IWrGEGpieB5knoZux/wRbo9g4mc/ZEsFVYTOZo3SEmf3iFxX80LXcwJSZCrYKi42Lx/6dQrZailYboYFpMhDufKNqNECTJ2Rb7Fc6vZ/1JlDzf+WPtTzqhWJMz4a57pL93rQ7tKuqvmJ9pbd2uaaTzj/lSMuBNv6t84se01me500++pf30dWVWGVbZZxUpimexoQWPOye7l7jKSK0Wg7j1IJnflvlKsbIGGYCvLAzOlCs+OOGc/xHVXhCeCZn2IqJYhauTfTkqUGLLPgf3AeLiERy1mNetd1t3CUMRh0WHrgJKb7EJzD2c8Y6Z9m71qlRYxLqmA1e4HIFWl85VHHNBZ0jGVtdLhYVpPHobgHLAa4GV0W1WOWJcW6asppoKUpU818r/D/5aD5aBiwAJ90xTDinr4t7iT++tAmd0D1ViXAcqzLmw3vaCX44GWlvL1qrsYevyod3RAzihh4DGDohABe9rm+qGrmyh44zNbaUTNEGCkiTbSifAoRptjG54m9BhXBA5soAS1LlJ5hz6/BM0wPwGKACEMAcSevCqFeYVl2e7LWSXpSNcEYKgg26NbKFdDilz3QzapcH+QE2OPL24/38rljj6pdW7+MUl0lAlKQyWSN56F96Pcwlq+BGs6AbMta9TNFzQcVv5ZRppMkxnlkKKRI/eaEnGydfFeKlFOo0i++HVS7QeLuWXBReU1AfkXJXBT2ymRETnCdrSabrNbou2Zi8mm1oL+ygS4HWsdpHHFI1nQAoOKRfMoMLkgXMFwUILrmSj9xiyC6rO+wuNmTvPG1+bfPbAfNH3U3n1ccd6YQNwjNTxv0jAXnPHSol6+ISGLLW215nS6EpR2LBUwkt1ebYLX4rN8nfKbfGpEb1Qed6siHJJZXKVpSPpRqUxXh1HiDrR81ETAmNpIeXCTCUIQcpOB9j/pQVjqGOFM4UyomI3dIWXzvE/OaB3rGvsGB+pWROY+NzIXhgOoOglRGN5vP9a8X0JyEy+mMA335ON/M4Ry00jixtxAsISRBzEkkKyZIGAMkr3kyXJO2X+oxikezUwWi7p/abTmVJY8jOAc6TJ7Ywd3WiyNuFssno4m+ySct7w6C5JUOrWP2yvrT08ULTm+8o6m94YqEfuHz8iZpvBjbXsdRs/IOtTwkiWwmx8QysxGqx6m4IoihLG6SEiX1CSUew0jG4/RIrk/hhHjYR9on+ey83p198LQQxFVnQ5RTYxtXu9pTIRndu1Y8HB3Gkt3eOjdWjfg6szKfx2ddGJL18iROpN5qpXrf8EMj94Y0yH/3HzXltAGi7pN3zcc414zFZc2/hFx0Ur98KRPlWzI9lt9VMac0xvbfXDYDwh/raWfrf9Rw=="></div></details><hr /><br />

**类似题目**：
  - [55. 跳跃游戏 🟠](/problems/jump-game)

</details>
</div>



