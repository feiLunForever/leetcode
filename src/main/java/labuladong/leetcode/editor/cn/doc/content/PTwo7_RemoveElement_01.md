<p>Given an integer array <code>nums</code> and an integer <code>val</code>, remove all occurrences of <code>val</code> in <code>nums</code> <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>. The order of the elements may be changed. Then return <em>the number of elements in </em><code>nums</code><em> which are not equal to </em><code>val</code>.</p>

<p>Consider the number of elements in <code>nums</code> which are not equal to <code>val</code> be <code>k</code>, to get accepted, you need to do the following things:</p>

<ul> 
 <li>Change the array <code>nums</code> such that the first <code>k</code> elements of <code>nums</code> contain the elements which are not equal to <code>val</code>. The remaining elements of <code>nums</code> are not important as well as the size of <code>nums</code>.</li> 
 <li>Return <code>k</code>.</li> 
</ul>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i &lt; actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,2,3], val = 3
<strong>Output:</strong> 2, nums = [2,2,_,_]
<strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,2,2,3,0,4,2], val = 2
<strong>Output:</strong> 5, nums = [0,1,4,0,3,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 100</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 50</code></li> 
 <li><code>0 &lt;= val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 1946, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-element" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

类似 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)，需要使用 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中的快慢指针：

如果 `fast` 遇到需要去除的元素，则直接跳过，否则就告诉 `slow` 指针，并让 `slow` 前进一步。

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
    def removeElement(self, nums: List[int], val: int) -> int:
        fast, slow = 0, 0
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
    public int removeElement(int[] nums, int val) {
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

// 双指针法
func removeElement(nums []int, val int) int {
    var fast, slow int
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

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let fast = 0, slow = 0;
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

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-element" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-element"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 🟢](/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



