<p>English description is not available for the problem. Please switch to Chinese.</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 二分查找</details><br>

<div>👍 269, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=he-wei-sde-liang-ge-shu-zi-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [1. 两数之和](/problems/two-sum) 基本一样，而且还说了 `nums` 是有序的，所以直接用 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中讲的左右双指针解决即可。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 左右双指针
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return {nums[left], nums[right]};
            }
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 左右双指针
        left, right = 0, len(nums) - 1
        while left < right:
            sum = nums[left] + nums[right]
            if sum < target:
                # 让和大一点
                left += 1
            elif sum > target:
                # 让和小一点
                right -= 1
            else:
                # 找到两个数
                return [nums[left], nums[right]]
        return None
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 左右双指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func twoSum(nums []int, target int) []int {
    // 左右双指针
    left, right := 0, len(nums)-1
    for left < right {
        sum := nums[left] + nums[right]
        if sum < target {
            // 让和大一点
            left++
        } else if sum > target {
            // 让和小一点
            right--
        } else {
            // 找到两个数
            return []int{nums[left], nums[right]}
        }
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var twoSum = function(nums, target) {
    // 左右双指针
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let sum = nums[left] + nums[right];
        if (sum < target) {
            // 让和大一点
            left++;
        } else if (sum > target) {
            // 让和小一点
            right--;
        } else {
            // 找到两个数
            return [nums[left], nums[right]];
        }
    }
    return null;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_he-wei-sde-liang-ge-shu-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_he-wei-sde-liang-ge-shu-zi-lcof"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组](/problems/two-sum-ii-input-array-is-sorted/)
  - [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素](/problems/remove-element)
  - [283. 移动零](/problems/move-zeroes)
  - [344. 反转字符串](/problems/reverse-string/)
  - [5. 最长回文子串](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer II 006. 排序数组中两个数字之和](/problems/kLl5u1/)

</details>
</div>





