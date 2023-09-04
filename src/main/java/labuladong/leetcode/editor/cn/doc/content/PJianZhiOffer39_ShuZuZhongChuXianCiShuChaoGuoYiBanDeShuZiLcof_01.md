English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 分治 | 计数 | 排序</details><br>

<div>👍 397, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [169. 多数元素](/problems/majority-element) 相同。

这道题的标准解法肯定是用一个哈希表作为计数器记录每个元素出现的次数，然后寻找出现次数最多的那个元素，时间和空间复杂度都是 `O(N)`。

但是由于题目说了这个目标元素（众数）出现的次数**过半**，这就有意思了，其实我们不需要用哈希表来做计数器就能把这个众数找出来。

你想象一下，比方说一群带正电的粒子和一群带负电的粒子，把它们混合起来，得到的这群混合粒子的带电性质是什么？这取决于正电离子多还是负电离子多，如果正负粒子数量恰好相等，则呈电中性。

回到这道题，题目告诉你一定存在一个众数，它出现的次数过半，那么如果你把这个众数元素想象成正电粒子，其他的所有元素都想象成负电粒子，那么它们混合起来会怎样？

**在正负粒子混合的过程中，整体的带电性可能在正负间波动，但最终的结果一定是正电**。

有了这个类比，你看下解法代码，我们是如何用 `O(1)` 的空间复杂度来计算众数的。

**标签：哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int majorityElement(vector<int>& nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 我们想寻找的那个众数
        target = 0
        # 计数器（类比带电粒子例子中的带电性）
        count = 0
        for i in range(len(nums)):
            if count == 0:
                # 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i]
                # 众数出现了一次
                count = 1
            elif nums[i] == target:
                # 如果遇到的是目标众数，计数器累加
                count += 1
            else:
                # 如果遇到的不是目标众数，计数器递减
                count -= 1
        # 回想带电粒子的例子
        # 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int majorityElement(int[] nums) {
        // 我们想寻找的那个众数
        int target = 0;
        // 计数器（类比带电粒子例子中的带电性）
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                // 当计数器为 0 时，假设 nums[i] 就是众数
                target = nums[i];
                // 众数出现了一次
                count = 1;
            } else if (nums[i] == target) {
                // 如果遇到的是目标众数，计数器累加
                count++;
            } else {
                // 如果遇到的不是目标众数，计数器递减
                count--;
            }
        }
        // 回想带电粒子的例子
        // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
        return target;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func majorityElement(nums []int) int {
    // 我们想寻找的那个众数
    target := 0
    // 计数器（类比带电粒子例子中的带电性）
    count := 0

    for i := 0; i < len(nums); i++ {
        if count == 0 {
            // 当计数器为 0 时，假设 nums[i] 就是众数
            target = nums[i]
            // 众数出现了一次
            count = 1
        } else if nums[i] == target {
            // 如果遇到的是目标众数，计数器累加
            count++
        } else {
            // 如果遇到的不是目标众数，计数器递减
            count--
        }
    }

    // 回想带电粒子的例子
    // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
    return target
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var majorityElement = function(nums) {
    // 我们想寻找的那个众数
    let target = 0;
    // 计数器（类比带电粒子例子中的带电性）
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        if (count == 0) {
            // 当计数器为 0 时，假设 nums[i] 就是众数
            target = nums[i];
            // 众数出现了一次
            count = 1;
        } else if (nums[i] == target) {
            // 如果遇到的是目标众数，计数器累加
            count++;
        } else {
            // 如果遇到的不是目标众数，计数器递减
            count--;
        }
    }
    // 回想带电粒子的例子
    // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
    return target;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_majority-element" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_majority-element"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 39. 数组中出现次数超过一半的数字 🟢](/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof)

</details>
</div>



