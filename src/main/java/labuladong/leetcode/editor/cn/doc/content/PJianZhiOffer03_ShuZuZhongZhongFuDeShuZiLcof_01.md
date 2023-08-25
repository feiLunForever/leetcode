<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 排序</details><br>

<div>👍 1212, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [442. 数组中重复的数据](/problems/find-all-duplicates-in-an-array) 几乎一样，可以通过给数字加负号的方式用原数组充当哈希集合的作用，避免额外的空间复杂度，可以先去看看我写的 442 题的思路。

这道题唯一的区别就是不需要做索引偏移了，且 `nums` 数组中可能存在元素 0。不过我在 442 题中提过，存在 0 的话就不能通过给数字加负号的方式来判断重复了，因为 0 加上负号还是 0。

不过我们可以想办法绕开 0 的限制嘛，比如说我先给 `nums` 数组的所有元素都加一，这样就和 442 题的条件一样了，直接使用 442 题的解法思路，最后再把结果减一就行了。

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        for (int num : nums) {
            if (nums[abs(num)] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                return abs(num);
            } else {
                // 把索引 num 的元素置为负数
                nums[abs(num)] *= -1;
            }
        }
        // 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for num in nums:
            if nums[abs(num)] < 0:
                # 之前已经把对应索引的元素变成负数了，
                # 这说明 num 重复出现了两次
                return abs(num)
            else:
                # 把索引 num 的元素置为负数
                nums[abs(num)] *= -1
        # 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 先把 nums 数组中的所有元素都加一，避免 0 的影响
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 1;
        }

        for (int num : nums) {
            // 该元素对应的索引
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                // 注意结果要减一
                return Math.abs(num) - 1;
            } else {
                // 把索引 num 的元素置为负数
                nums[index] *= -1;
            }
        }
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findRepeatNumber(nums []int) int {
    for _, num := range nums {
        if nums[abs(num)] < 0 {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return abs(num)
        } else {
            // 把索引 num 的元素置为负数
            nums[abs(num)] *= -1
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0
}

func abs(num int) int {
    if num < 0 {
        return -num
    }
    return num
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
var findRepeatNumber = function(nums) {
    for (let num of nums) {
        if (nums[Math.abs(num)] < 0) {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return Math.abs(num);
        } else {
            // 把索引 num 的元素置为负数
            nums[Math.abs(num)] *= -1;
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_shu-zu-zhong-zhong-fu-de-shu-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_shu-zu-zhong-zhong-fu-de-shu-zi-lcof"></div></div>
</details><hr /><br />

</details>
</div>



