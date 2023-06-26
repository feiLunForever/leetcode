<p>You have a set of integers <code>s</code>, which originally contains all the numbers from <code>1</code> to <code>n</code>. Unfortunately, due to some error, one of the numbers in <code>s</code> got duplicated to another number in the set, which results in <strong>repetition of one</strong> number and <strong>loss of another</strong> number.</p>

<p>You are given an integer array <code>nums</code> representing the data status of this set after the error.</p>

<p>Find the number that occurs twice and the number that is missing and return <em>them in the form of an array</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [1,2,2,4]
<strong>Output:</strong> [2,3]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [1,2]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 排序</details><br>

<div>👍 332, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=set-mismatch" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题的核心思路是将每个索引对应的元素变成负数，以表示这个索引被对应过一次。

如果出现重复元素 `4`，直观结果就是，索引 `4` 所对应的元素已经是负数了：

![](https://labuladong.github.io/pictures/dupmissing/2.jpg)

对于缺失元素 `3`，直观结果就是，索引 `3` 所对应的元素是正数：

![](https://labuladong.github.io/pictures/dupmissing/3.jpg)

依据这个特点，就能找到缺失和重复的元素了。

**详细题解：[如何同时寻找缺失和重复的元素](https://labuladong.github.io/article/fname.html?fname=缺失和重复的元素)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> findErrorNums(vector<int>& nums) {
        int n=nums.size();
        int dup=-1;
        for(int i=0;i<n;i++){
            // 现在的元素是从1开始的
            int index = abs(nums[i])-1;
            if(nums[index]<0)
                dup = abs(nums[i]);
            else
                nums[index]*=-1;
        }
        int missing=-1;
        for(int i=0;i<n;i++)
            if(nums[i]>0)
                // 将索引转换成元素
                missing=i+1;
        return {dup,missing};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        dup = -1
        for i in range(n):
            # 现在的元素是从 1 开始的
            index = abs(nums[i]) - 1
            if nums[index] < 0:
                dup = abs(nums[i])
            else:
                nums[index] *= -1

        missing = -1
        for i in range(n):
            if nums[i] > 0:
                # 将索引转换成元素
                missing = i + 1

        return [dup, missing]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;

        return new int[]{dup, missing};
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findErrorNums(nums []int) []int {
    n := len(nums)
    dup := -1
    for i := 0; i < n; i++ {
        // 现在的元素是从 1 开始的
        index := abs(nums[i]) - 1
        if nums[index] < 0 {
            dup = abs(nums[i])
        } else {
            nums[index] *= -1
        }
    }

    missing := -1
    for i := 0; i < n; i++ {
        if nums[i] > 0 {
            // 将索引转换成元素
            missing = i + 1
        }
    }

    return []int{dup, missing}
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
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
var findErrorNums = function(nums) {
    var n = nums.length;
    var dup = -1;
    for (var i = 0; i < n; i++) {
        // 现在的元素是从 1 开始的
        var index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0)
            dup = Math.abs(nums[i]);
        else
            nums[index] *= -1;
    }

    var missing = -1;
    for (var i = 0; i < n; i++)
        if (nums[i] > 0)
            // 将索引转换成元素
            missing = i + 1;

    return [dup, missing];
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_set-mismatch" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_set-mismatch"></div></div>
</details><hr /><br />

</details>
</div>



