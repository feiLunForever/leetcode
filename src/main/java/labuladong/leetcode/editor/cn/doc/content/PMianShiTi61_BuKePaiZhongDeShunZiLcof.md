English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>

<div>👍 321, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 19 期刷题打卡](https://aep.xet.tech/s/32wqt4) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题看起来不难，我想到的最直接的方式是排序，因为排序之后很容易判定顺子（元素递增 1）。

不过我按照这个思路写了下解法，发现大小王的万能匹配稍微有些难处理。所以仔细想了下，这题可以通过计算 5 个元素中的最大值和最小值来判断是否递增。

只要最大值和最小值的差等于 4，就说明是 5 个递增的元素。当然，由于大小王用 0 表示，所以 0 不应该参与最大最小值的选取。另外，顺子中不应该出现重复元素。

如果结合以上思路，就会发现其实不需要排序了，直接遍历一遍 `nums` 数组找最大最小值，然后再用一个 `HashSet` 判断重复元素就行了。具体看代码吧。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    bool isStraight(vector<int>& nums) {
        unordered_set<int> numSet;
        int maxVal = INT_MIN, minVal = INT_MAX;
        for (int num : nums) {
            if (num == 0) {
                // 小王不用管
                continue;
            }
            if (numSet.count(num)) {
                // 出现重复，不可能是顺子
                return false;
            }
            numSet.insert(num);

            maxVal = max(maxVal, num);
            minVal = min(minVal, num);
        }
        // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return maxVal - minVal <= 4;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isStraight(self, nums: List[int]) -> bool:
        numSet = set()
        maximum, minimum = float('-inf'), float('inf')
        for num in nums:
            if num == 0:
                # 小王不用管
                continue
            if num in numSet:
                # 出现重复，不可能是顺子
                return False
            numSet.add(num)
            maximum = max(maximum, num)
            minimum = min(minimum, num)
        # 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return maximum - minimum <= 4
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                // 小王不用管
                continue;
            }
            if (numSet.contains(num)) {
                // 出现重复，不可能是顺子
                return false;
            }
            numSet.add(num);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
        return max - min <= 4;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isStraight(nums []int) bool {
    numSet := make(map[int]bool)
    max, min := math.MinInt32, math.MaxInt32
    for _, num := range nums {
        if num == 0 {
            // 小王不用管
            continue
        }
        if numSet[num] {
            // 出现重复，不可能是顺子
            return false
        }
        numSet[num] = true

        max = int(math.Max(float64(max), float64(num)))
        min = int(math.Min(float64(min), float64(num)))
    }
    // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
    return max - min <= 4
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isStraight = function(nums) {
    let numSet = new Set();
    let max = -Infinity, min = Infinity;
    for (let num of nums) {
        if (num === 0) {
            // 小王不用管
            continue;
        }
        if (numSet.has(num)) {
            // 出现重复，不可能是顺子
            return false;
        }
        numSet.add(num);

        max = Math.max(max, num);
        min = Math.min(min, num);
    }
    // 考虑到大小王，只要差小于 4 就一定可以凑出顺子
    return max - min <= 4;
};
```

</div></div>
</div></div>

</details>
</div>



