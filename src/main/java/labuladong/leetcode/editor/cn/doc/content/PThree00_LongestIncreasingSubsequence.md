<p>Given an integer array <code>nums</code>, return <em>the length of the longest <strong>strictly increasing </strong></em><span data-keyword="subsequence-array"><em><strong>subsequence</strong></em></span>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,9,2,5,3,7,101,18]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,0,3,2,3]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,7,7,7,7,7,7]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 2500</code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<p><b>Follow up:</b>&nbsp;Can you come up with an algorithm that runs in&nbsp;<code>O(n log(n))</code> time complexity?</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 动态规划</details><br>

<div>👍 3234, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=longest-increasing-subsequence" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 96 页。

`dp` 数组的定义：`dp[i]` 表示以 `nums[i]` 这个数结尾的最长递增子序列的长度。

那么 `dp` 数组中最大的那个值就是最长的递增子序列长度。

**详细题解：[动态规划设计：最长递增子序列](https://labuladong.github.io/article/fname.html?fname=动态规划设计：最长递增子序列)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，子序列**

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
    int lengthOfLIS(vector<int>& nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        vector<int> dp(nums.size(), 1);/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
        // base case：dp 数组全都初始化为 1

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.size(); i++) {
            res = max(res, dp[i]);
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
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        dp = [1] * len(nums)

        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
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

func lengthOfLIS(nums []int) int {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    dp := make([]int, len(nums))
    // base case：dp 数组全都初始化为 1
    for i := 0; i < len(dp); i++ {
        dp[i] = 1
    }

    for i := 0; i < len(nums); i++ {
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                dp[i] = max(dp[i], dp[j]+1)
            }
        }
    }

    res := 0
    for i := 0; i < len(dp); i++ {
        res = max(res, dp[i])
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var lengthOfLIS = function(nums) {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    let dp = new Array(nums.length).fill(1);/**<extend down -200>![](https://labuladong.github.io/pictures/最长递增子序列/5.jpeg) */
    // base case：dp 数组全都初始化为 1

    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }

    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_longest-increasing-subsequence" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-increasing-subsequence"></div></div>
</details><hr /><br />

**类似题目**：
  - [354. 俄罗斯套娃信封问题 🔴](/problems/russian-doll-envelopes)
  - [53. 最大子数组和 🟠](/problems/maximum-subarray)
  - [剑指 Offer 42. 连续子数组的最大和 🟢](/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof)

</details>
</div>



