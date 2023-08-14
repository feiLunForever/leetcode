<p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>

<p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>

<p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>

<p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
<strong>Output:</strong> [-1,3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
<strong>Output:</strong> [3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li> 
 <li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li> 
 <li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li> 
</ul>

<p>&nbsp;</p> 
<strong>Follow up:</strong> Could you find an 
<code>O(nums1.length + nums2.length)</code> solution?

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 单调栈</details><br>

<div>👍 1062, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=next-greater-element-i" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

[单调栈模板](https://labuladong.github.io/article/fname.html?fname=单调栈) 实现了一个计算下一个更大元素的函数，这里可以直接复用。因为题目说 `nums1` 是 `nums2` 的子集，那么我们先把 `nums2` 中每个元素的下一个更大元素算出来存到一个映射里，然后再让 `nums1` 中的元素去查表即可。

**详细题解：[单调栈结构解决三道算法题](https://labuladong.github.io/article/fname.html?fname=单调栈)**

**标签：单调栈，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        vector<int> greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        map<int, int> greaterMap;
        for (int i = 0; i < nums2.size(); i++) {
            greaterMap[nums2[i]] = greater[i];
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        vector<int> res(nums1.size());
        for (int i = 0; i < nums1.size(); i++) {
            res[i] = greaterMap[nums1[i]];
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    vector<int> nextGreaterElement(vector<int>& nums) {
        int n = nums.size();
        // 存放答案的数组
        vector<int> res(n);
        stack<int> s;
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.top() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.empty() ? -1 : s.top();
            s.push(nums[i]);
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
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 记录 nums2 中每个元素的下一个更大元素
        greater = self.nextGreater(nums2)
        # 转化成映射：元素 x -> x 的下一个最大元素
        greaterMap = {}
        for i in range(len(nums2)):
            greaterMap[nums2[i]] = greater[i]
        # nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        res = []
        for num in nums1:
            res.append(greaterMap[num])
        return res

    # 计算 nums 中每个元素的下一个更大元素
    def nextGreater(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 存放答案的数组
        res = [-1] * n
        s = []
        # 倒着往栈里放
        for i in range(n - 1, -1, -1):
            # 判定个子高矮
            while s and s[-1] <= nums[i]:
                # 矮个起开，反正也被挡着了。。。
                s.pop()
            # nums[i] 身后的下一个更大元素
            if s:
                res[i] = s[-1]
            s.append(nums[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
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

import "fmt"

func nextGreaterElement(nums1 []int, nums2 []int) []int {
    // 记录 nums2 中每个元素的下一个更大元素
    greater := nextGreater(nums2)
    // 转化成映射：元素 x -> x 的下一个最大元素
    greaterMap := make(map[int]int)
    for i, v := range nums2 {
        greaterMap[v] = greater[i]
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    res := make([]int, len(nums1))
    for i, v := range nums1 {
        res[i] = greaterMap[v]
    }
    return res
}

// 计算 nums 中每个元素的下一个更大元素
func nextGreater(nums []int) []int {
    n := len(nums)
    // 存放答案的数组
    res := make([]int, n)
    s := []int{}
    // 倒着往栈里放
    for i := n - 1; i >= 0; i-- {
        // 判定个子高矮
        for len(s) != 0 && s[len(s)-1] <= nums[i] {
            // 矮个起开，反正也被挡着了。。。
            s = s[:len(s)-1]
        }
        // nums[i] 身后的下一个更大元素
        if len(s) == 0 {
            res[i] = -1
        } else {
            res[i] = s[len(s)-1]
        }
        s = append(s, nums[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var nextGreaterElement = function(nums1, nums2) {
    // 记录 nums2 中每个元素的下一个更大元素
    var greater = nextGreater(nums2);
    // 转化成映射：元素 x -> x 的下一个最大元素
    var greaterMap = new Map();
    for (var i = 0; i < nums2.length; i++) {
        greaterMap.set(nums2[i], greater[i]);
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    var res = new Array(nums1.length);
    for (var i = 0; i < nums1.length; i++) {
        res[i] = greaterMap.get(nums1[i]);
    }
    return res;
};

// 计算 nums 中每个元素的下一个更大元素
var nextGreater = function(nums) {
    var n = nums.length;
    // 存放答案的数组
    var res = new Array(n);
    var s = [];
    // 倒着往栈里放
    for (var i = n - 1; i >= 0; i--) {
        // 判定个子高矮
        while (s.length && s[s.length-1] <= nums[i]) {
            // 矮个起开，反正也被挡着了。。。
            s.pop();
        }
        // nums[i] 身后的下一个更大元素
        res[i] = s.length == 0 ? -1 : s[s.length-1];
        s.push(nums[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_next-greater-element-i" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_next-greater-element-i"></div></div>
</details><hr /><br />

**类似题目**：
  - [503. 下一个更大元素 II 🟠](/problems/next-greater-element-ii)
  - [739. 每日温度 🟠](/problems/daily-temperatures)
  - [剑指 Offer II 038. 每日温度 🟠](/problems/iIQa4I)

</details>
</div>



