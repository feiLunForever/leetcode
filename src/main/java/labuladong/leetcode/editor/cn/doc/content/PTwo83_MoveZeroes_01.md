<p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you minimize the total number of operations done?

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2160, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=move-zeroes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0
            
    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums: List[int], val: int) -> int:
        fast = 0
        slow = 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast := 0
    slow := 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
};

// 双指针技巧，复用 [27. 移除元素] 的解法。
var removeElement = function(nums, val) {
    var fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_move-zeroes" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



