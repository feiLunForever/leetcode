<p>Given an integer array <code>nums</code> with possible <strong>duplicates</strong>, randomly output the index of a given <code>target</code> number. You can assume that the given target number must exist in the array.</p>

<p>Implement the <code>Solution</code> class:</p>

<ul> 
 <li><code>Solution(int[] nums)</code> Initializes the object with the array <code>nums</code>.</li> 
 <li><code>int pick(int target)</code> Picks a random index <code>i</code> from <code>nums</code> where <code>nums[i] == target</code>. If there are multiple valid i's, then each index should have an equal probability of returning.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
<strong>Output</strong>
[null, 4, 0, 2]

<strong>Explanation</strong>
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li> 
 <li><code>target</code> is an integer from <code>nums</code>.</li> 
 <li>At most <code>10<sup>4</sup></code> calls will be made to <code>pick</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>水塘抽样 | 哈希表 | 数学 | 随机化</details><br>

<div>👍 267, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=random-pick-index" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题按理说可以使用 HashMap 来做，存储元素到索引列表的映射，然后随机从列表中取出一个元素，但是似乎这题对空间复杂度的要求较高，这个简单直接的方式会超过内存限制。

所以我们只好用时间换空间，每次 `pick` 都遍历一遍 `nums` 数组，用水塘抽样算法从中随机选出一个索引。

水塘抽样算法就是解决如何在长度未知的序列（数据流）中**随机**选择一个元素的数学技巧，类似 [382. 链表随机节点](/problems/linked-list-random-node)。

结论：当你遇到第 `i` 个元素时，应该有 `1/i` 的概率选择该元素，`1 - 1/i` 的概率保持原有的选择。数学证明请看详细题解。

**详细题解：[谈谈游戏中的随机算法](https://labuladong.github.io/article/fname.html?fname=随机算法)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，水塘抽样算法，[随机算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
private:
    vector<int> nums;
public:
    Solution(vector<int>& nums) {
        this->nums = nums;
    }
    
    int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (rand() % count == 0) {
                res = i;
            }
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

import random

class Solution:
    def __init__(self, nums: List[int]):
        self.nums = nums
        self.rand = random.Random()

    def pick(self, target: int) -> int:
        count, res = 0, -1
        for i in range(len(self.nums)):
            if self.nums[i] != target:
                continue
            count += 1
            if self.rand.randint(1, count) == 1:
                res = i
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (rand.nextInt(count) == 0) {
                res = i;
            }
        }

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

// Constructor function that receives a nums array and returns a solution struct
func Constructor(nums []int) Solution {
    randSource := rand.NewSource(time.Now().UnixNano())
    randGen := rand.New(randSource)
    return Solution{nums, randGen}
}

// Pick function receives a target value and returns the index of the element in the nums array
func Pick(s *Solution, target int) int {
    count := 0
    res := -1
    for i := 0; i < len(s.nums); i++ {
        if s.nums[i] != target {
            continue
        }
        count++
        if s.rand.Intn(count) == 0 {
            res = i
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * @param {number[]} nums
 */
var Solution = function(nums) {
    this.nums = nums;
    this.rand = new Random();
};

/**
 * @param {number} target
 * @return {number}
 */
Solution.prototype.pick = function(target) {
    let count = 0;
    let res = -1;
    for (let i = 0; i < this.nums.length; i++) {
        if (this.nums[i] !== target) {
            continue;
        }
        count++;
        if (this.rand.nextInt(count) === 0) {
            res = i;
        }
    }
    return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [382. 链表随机节点 🟠](/problems/linked-list-random-node)
  - [384. 打乱数组 🟠](/problems/shuffle-an-array)

</details>
</div>



