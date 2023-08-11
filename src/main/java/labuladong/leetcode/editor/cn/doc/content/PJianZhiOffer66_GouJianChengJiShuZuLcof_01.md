English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>

<div>👍 343, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [238. 除自身以外数组的乘积](/problems/product-of-array-except-self) 一模一样，可以看下 238 的思路或者直接看解法代码吧。

**标签：前缀和，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> constructArr(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) {
            return vector<int>();
        }
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        vector<int> prefix(n);
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        vector<int> suffix(n);
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // 结果数组
        vector<int> res(n);
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1];
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
    def constructArr(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if n == 0:
            return []
        # 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        prefix = [0] * n
        prefix[0] = nums[0]
        for i in range(1, n):
            prefix[i] = prefix[i - 1] * nums[i]
        # 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        suffix = [0] * n
        suffix[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]
        # 结果数组
        res = [0] * n
        res[0] = suffix[1]
        res[n - 1] = prefix[n - 2]
        for i in range(1, n - 1):
            # 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] constructArr(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // 结果数组
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1];
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

func constructArr(nums []int) []int {
    n := len(nums)
    if n == 0 {
        return []int{}
    }
    // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
    prefix := make([]int, n)
    prefix[0] = nums[0]
    for i := 1; i < n; i++ {
        prefix[i] = prefix[i-1] * nums[i]
    }
    // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
    suffix := make([]int, n)
    suffix[n-1] = nums[n-1]
    for i := n - 2; i >= 0; i-- {
        suffix[i] = suffix[i+1] * nums[i]
    }
    // 结果数组
    res := make([]int, n)
    res[0] = suffix[1]
    res[n-1] = prefix[n-2]
    for i := 1; i < n-1; i++ {
        // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
        res[i] = prefix[i-1] * suffix[i+1]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var constructArr = function(nums) {
    var n = nums.length;
    if (n == 0) {
        return new Array(0);
    }
    // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
    var prefix = new Array(n);
    prefix[0] = nums[0];
    for (var i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] * nums[i];
    }
    // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
    var suffix = new Array(n);
    suffix[n - 1] = nums[n - 1];
    for (var i = n - 2; i >= 0; i--) {
        suffix[i] = suffix[i + 1] * nums[i];
    }
    // 结果数组
    var res = new Array(n);
    res[0] = suffix[1];
    res[n - 1] = prefix[n - 2];
    for (var i = 1; i < n - 1; i++) {
        // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
        res[i] = prefix[i - 1] * suffix[i + 1];
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_gou-jian-cheng-ji-shu-zu-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_gou-jian-cheng-ji-shu-zu-lcof"></div></div>
</details><hr /><br />

</details>
</div>



