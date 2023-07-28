English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>

<div>👍 713, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=lian-xu-zi-shu-zu-de-zui-da-he-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [53. 最大子序和](/problems/maximum-subarray) 相同。

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
    dp[0] = nums[0]

    // 状态转移方程
    for i := 1; i < n; i++ {
        dp[i] = func() int {
            if nums[i] > nums[i]+dp[i-1] {
                return nums[i]
            }
            return nums[i] + dp[i-1]
        }()
    }

    // 得到 nums 的最大子数组
    res := math.MinInt32
    for i := 0; i < n; i++ {
        res = func() int {
            if res > dp[i] {
                return res
            }
            return dp[i]
        }()
    }

    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var maxSubArray = function(nums) {
    const n = nums.length;
    if (n == 0) return 0;
    const dp = new Array(n).fill(0);
    // base case
    // 第一个元素前面没有子数组
    dp[0] = nums[0];
    // 状态转移方程
    for (let i = 1; i < n; i++) {
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    // 得到 nums 的最大子数组
    let res = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < n; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_maximum-subarray" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
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



