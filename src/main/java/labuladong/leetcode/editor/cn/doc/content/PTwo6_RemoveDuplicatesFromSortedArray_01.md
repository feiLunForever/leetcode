<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears only <strong>once</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>. Then return <em>the number of unique elements in </em><code>nums</code>.</p>

<p>Consider the number of unique elements of <code>nums</code> to be <code>k</code>, to get accepted, you need to do the following things:</p>

<ul> 
 <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the unique elements in the order they were present in <code>nums</code> initially. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li> 
 <li>Return <code>k</code>.</li> 
</ul>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> 2, nums = [1,2,_]
<strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,1,2,2,3,3,4]
<strong>Output:</strong> 5, nums = [0,1,2,3,4,_,_,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-100 &lt;= nums[i] &lt;= 100</code></li> 
 <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 3301, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicates-from-sorted-array" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

有序序列去重的通用解法就是我们前文 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中的快慢指针技巧。

我们让慢指针 `slow` 走在后面，快指针 `fast` 走在前面探路，找到一个不重复的元素就告诉 `slow` 并让 `slow` 前进一步。这样当 `fast` 指针遍历完整个数组 `nums` 后，**`nums[0..slow]` 就是不重复元素**。

![](https://labuladong.github.io/pictures/数组去重/1.gif)

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
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        slow, fast = 0, 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                # 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast]
            fast += 1
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func removeDuplicates(nums []int) int {
    // 如果数组为空，直接返回 0
    if len(nums) == 0 {
        return 0
    }
    // 定义快慢指针，初始化都指向数组头部
    slow, fast := 0, 0
    // 快指针向后遍历数组，直到末尾
    for fast < len(nums) {
        // 如果两个指针指向的元素不相同
        if nums[fast] != nums[slow] {
            // 慢指针向后移动，并且将慢指针位置上的值设为快指针位置上的值
            slow++
            nums[slow] = nums[fast]
        }
        // 快指针继续向后移动
        fast++
    }
    // slow 指向数组的最后一个不重复元素的位置
    // 数组长度为索引 + 1
    return slow + 1
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
var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    let slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [80. 删除有序数组中的重复项 II 🟠](/problems/remove-duplicates-from-sorted-array-ii)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



