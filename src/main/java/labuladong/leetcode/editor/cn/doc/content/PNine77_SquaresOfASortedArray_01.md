<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order, return <em>an array of <strong>the squares of each number</strong> sorted in non-decreasing order</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-4,-1,0,3,10]
<strong>Output:</strong> [0,1,9,16,100]
<strong>Explanation:</strong> After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-7,-3,2,3,11]
<strong>Output:</strong> [4,9,9,49,121]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code><span>1 &lt;= nums.length &lt;= </span>10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Squaring each element and sorting the new array is very trivial, could you find an 
<code>O(n)</code> solution using a different approach?

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 882, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

平方的特点是会把负数变成正数，所以一个负数和一个正数平方后的大小要根据绝对值来比较。

可以把元素 0 作为分界线，0 左侧的负数是一个有序数组 `nums1`，0 右侧的正数是另一个有序数组 `nums2`，那么这道题就和 [88. 合并两个有序数组](/problems/merge-sorted-array) 差不多，在进一步就是前文 [链表的双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 讲过的 [21. 合并两个有序链表](/problems/merge-two-sorted-lists) 的变体。

所以，我们可以去寻找正负数的分界点，然后向左右扩展，执行合并有序数组的逻辑。不过还有个更好的办法，不用找正负分界点，而是直接将双指针分别初始化在 `nums` 的开头和结尾，相当于合并两个从大到小排序的数组，和 88 题类似。有了思路，直接看代码吧。

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
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        vector<int> res(n);
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (abs(nums[i]) > abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
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
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 两个指针分别初始化在正负子数组绝对值最大的元素索引
        i, j = 0, n - 1
        # 得到的有序结果是降序的
        p = n - 1
        res = [0] * n
        # 执行双指针合并有序数组的逻辑
        while i <= j:
            if abs(nums[i]) > abs(nums[j]):
                res[p] = nums[i] * nums[i]
                i += 1
            else:
                res[p] = nums[j] * nums[j]
                j -= 1
            p -= 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        int[] res = new int[n];
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
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

func sortedSquares(nums []int) []int {
    n := len(nums)
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    i, j := 0, n-1
    // 得到的有序结果是降序的
    p := n - 1
    res := make([]int, n)
    // 执行双指针合并有序数组的逻辑
    for i <= j {
        if math.Abs(float64(nums[i])) > math.Abs(float64(nums[j])) {
            res[p] = nums[i] * nums[i]
            i++
        } else {
            res[p] = nums[j] * nums[j]
            j--
        }
        p--
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let n = nums.length;
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    let i = 0, j = n - 1;
    // 得到的有序结果是降序的
    let p = n - 1;
    let res = new Array(n);
    // 执行双指针合并有序数组的逻辑
    while (i <= j) {
        if (Math.abs(nums[i]) > Math.abs(nums[j])) {
            res[p] = nums[i] * nums[i];
            i++;
        } else {
            res[p] = nums[j] * nums[j];
            j--;
        }
        p--;
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_squares-of-a-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_squares-of-a-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [360. 有序转化数组 🟠](/problems/sort-transformed-array)

</details>
</div>



