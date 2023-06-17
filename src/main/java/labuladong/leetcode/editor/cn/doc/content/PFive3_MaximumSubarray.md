<p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty">subarray</span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>

<div>👍 6115, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=maximum-subarray" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 108 页。

这题类似 [300. 最长递增子序列](/problems/longest-increasing-subsequence)，`dp` 数组的含义：

**以 `nums[i]` 为结尾的「最大子数组和」为 `dp[i]`**。

`dp[i]` 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么不与前面的子数组连接，自成一派，自己作为一个子数组。

在这两种选择中择优，就可以计算出最大子数组，而且空间复杂度还有优化空间，见详细题解。

**详细题解：[动态规划设计：最大子数组](https://labuladong.github.io/article/fname.html?fname=最大子数组)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;
        vector<int> dp(n);
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = INT_MIN;
        for (int i = 0; i < n; i++) {
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
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        dp = [0] * n
        # base case
        # 第一个元素前面没有子数组
        dp[0] = nums[0]
        # 状态转移方程
        for i in range(1, n):
            dp[i] = max(nums[i], nums[i] + dp[i - 1])
        # 得到 nums 的最大子数组
        res = float('-inf')
        for i in range(n):
            res = max(res, dp[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
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

func maxSubArray(nums []int) int {
    n := len(nums)
    if n == 0 {
        return 0
    }
    dp := make([]int, n)
    // base case
    // 第一个元素前面没有子数组
    dp[0] = nums[0]
    // 状态转移方程
    for i := 1; i < n; i++ {
        dp[i] = max(nums[i], nums[i] + dp[i - 1])
    }
    // 得到 nums 的最大子数组
    res := math.MinInt32
    for i := 0; i < n; i++ {
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

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    const n = nums.length;
    if (n === 0) return 0;
    const dp = new Array(n);
    // base case
    // 第一个元素前面没有子数组
    dp[0] = nums[0];
    // 状态转移方程
    for (let i = 1; i < n; i++) {
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    // 得到 nums 的最大子数组
    let res = -Infinity;
    for (let i = 0; i < n; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_maximum-subarray" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-subarray"></div></div>
</details><hr /><br />

**类似题目**：
  - [152. 乘积最大子数组 🟠](/problems/maximum-product-subarray)
  - [209. 长度最小的子数组 🟠](/problems/minimum-size-subarray-sum)
  - [918. 环形子数组的最大和 🟠](/problems/maximum-sum-circular-subarray)
  - [剑指 Offer 42. 连续子数组的最大和 🟢](/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof)
  - [剑指 Offer II 008. 和大于等于 target 的最短子数组 🟠](/problems/2VG8Kg)

</details>
</div>



