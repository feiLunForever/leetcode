<p>Given an array <code>nums</code> containing <code>n</code> distinct numbers in the range <code>[0, n]</code>, return <em>the only number in the range that is missing from the array.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,0,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [9,6,4,2,3,5,7,0,1]
<strong>Output:</strong> 8
<strong>Explanation:</strong> n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= n</code></li> 
 <li>All the numbers of <code>nums</code> are <strong>unique</strong>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Could you implement a solution using only <code>O(1)</code> extra space complexity and <code>O(n)</code> runtime complexity?</p>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 数学 | 二分查找 | 排序</details><br>

<div>👍 739, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=missing-number" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

假设 `nums = [0,3,1,4]`：

![](https://labuladong.github.io/pictures/缺失元素/1.jpg)

我们先把索引补一位，然后让每个元素和自己相等的索引相对应：

![](https://labuladong.github.io/pictures/缺失元素/2.jpg)

这样做了之后，就可以发现除了缺失元素之外，所有的索引和元素都组成一对儿了，现在如果把这个落单的索引 2 找出来，也就找到了缺失的那个元素。

如何找？只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下。

**详细题解：[常用的位操作](https://labuladong.github.io/article/fname.html?fname=常用的位操作)**

**标签：[位运算](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
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
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        # 先和新补的索引异或一下
        res ^= n
        # 和其他的元素、索引做异或
        for i in range(n):
            res ^= i ^ nums[i]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/*
 * @lc app=leetcode id=268 lang=golang
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (49.34%)
 * Total Accepted:    321.9K
 * Total Submissions: 647.5K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 *
 *
 * Input: [3,0,1]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */

func missingNumber(nums []int) int {
    n := len(nums)
    res := 0
    // 先和新补的索引异或一下
    res ^= n
    // 和其他的元素、索引做异或
    for i := 0; i < n; i++ {
        res ^= i ^ nums[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var missingNumber = function(nums) {
    let n = nums.length;
    let res = 0;
    // 先和新补的索引异或一下
    res ^= n;
    // 和其他的元素、索引做异或
    for (let i = 0; i < n; i++)
        res ^= i ^ nums[i];
    return res;
}
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_missing-number" data="G2gYERWb7QB0HthtyCnc5inReYeOCMHxCcEUXAUi8v+cVdX6prrgPgP5tgoxAYJ+B5FJqeiqTaerLZb9yQY8krKQkm8OQ65eMJgEDaZtsL6wqPW/hiYKwZV44issgUdXFv5292dKCPbD9QoMLjGur8LWmWoXWYLHmoWXjfUKw1kaHd7Y9p9O5G15/u+bJSQytWI6/zDw6ucxaHCIIY311bYAJaaGP+NNhpR0n69Awv9SxEpm7Vj241XxLnotIHNZov4pcSlq/XQ8hfd9AZYjjnnrt2lqdJocHeZ9i2JpSbajch4rs/GYt5HJCDL9XiWHugql5+zenG4NywyEXs6OvPawGVl+sG3RtjllzcAIk3n1dPyObMgT2Jdle6OVdCeDWNJLEBwv1bF7V5TVhQ1TRcZxL1NYdvv6xouTl8V1HluXblx9w+YXneycXlNO207y7dPymEz9kiv16Hd1jugnTCjGzw90827vYZCYgV9lAY3TPoUGZ+Yxk9G6YgJgAgi+fG8ncuwSmzhX7VIrvgncWP+isTo9j3t2/AW/fgliBaSh8RO8oobuSy4LGFV2Zc/6CzJl+DFWLv5Dbh71I8EvIpovNpuvQc33AZuR0B9xMv3HHqT/hpPp7wM1I+GdA75cvb4G1Ix+Z8E8j7L/WrtzlI79kLq0LeXLt6SPlO8bhKtyEiuoVGU3Tcn7lLylq3qxq5TRA0zTknjP+lfbsyBN0QuywuPc/EiJ5QUotu2+znIyJTDFRDMnVkTra64dUaMpPKkElxPG5huz9awqoLFmVs27BRYz35cOrGiJsLag22e7Ia9jiDfrOtoFRZESTbYfNZe5X38qT1vMuszTJQeewnoYzjSMwsSdZw0pLt7Gsc3wdgdNhQHSBDbdwnxA2zQcOxYBZ1SaMWt39VSYCA2iTdSHPaDIcKnSSRygBFIpzyN7YapyQMrmeWrXtdIyjDxWlHUQlGEKRrBTN9vWGel7BMWgMv5SGSRhzll9x1Tw3ggvckneMV1woV090dSY+6IqreprKvTb0lgVaSIgFLw2lIqLGMIUp8iKVFwE36fbIlARq4iGIxIxMvsi6oBMg6p9/hw/lNMNQ4ZUJmygSIdATYvvc3N50KJbQJcL/4so6EpoIrJ4ZZh2Xav7H/ihe0tK5Ul6cb90yE8csOCQfs8N+CFPUiglcdkFDvC7RC2qg6+TUd06Jq0sEgYOWWVRmMeB8tYSs8wkAHUZhNZkHF2nmDfeiHFQ/NbUIKg93LEtJ5tgCnO9kaRmzSaUY5zQwVA5nBu6wEELwByCCNUJo9BD73A6bSPPS9GAClwwopxRWlOUV10ZDIqibVoRbwyIHZqx0JTY4LiDkFqjzrOzp+HdG6UkuFr9+do/5jRLt43gJSPV1YrvETnkqC+Jtd0vjYVpCoaXFoa5uOnm8gCPuag8K6PUJRVCVSo7TuOhraU1IQEAZ9LMuLIcMHBNK6438ug+CuFU2OZEod9gotqBwS54uITtsCXjyjIV21CxPCjH6WaPQVCMWm3uyVMTstFVJfK2m0APACZ1XG8U7oySGrXJOJ+6LHzKNvyKbha8GGQxI8xAWIAIUSwpRIEFAoKf78eB2Tth0ar4o/KrlpfPzYtLgTP3v8TTwQguClWCi8HyLDRdaFDVnAxa8uA098VZkp7UqcLzD0uk4ZvjhY36od/RYp59FEWRM8PIGxEMK3Py0Wv6ZtAvTHd/YvJEX2pf4d/1/u/70/Lzz9fk19C31YMsM65Hz37VQ/pssIdLpau/lGHH+gAkshx7tE1/Mb44wnvUudSvy684U7496yB69cPGJ1gb7fmITLJ3zgqy0XlqzcgNxzCMPvrryQHDGiHb3+ux7x48aKs7j+uP/BCaW6i5HQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_missing-number"></div></div>
</details><hr /><br />

**类似题目**：
  - [136. 只出现一次的数字 🟢](/problems/single-number)
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [231. 2 的幂 🟢](/problems/power-of-two)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



