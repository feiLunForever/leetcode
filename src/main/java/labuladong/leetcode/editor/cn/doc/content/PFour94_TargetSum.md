<p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>

<p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>'+'</code> and <code>'-'</code> before each integer in nums and then concatenate all the integers.</p>

<ul> 
 <li>For example, if <code>nums = [2, 1]</code>, you can add a <code>'+'</code> before <code>2</code> and a <code>'-'</code> before <code>1</code> and concatenate them to build the expression <code>"+2-1"</code>.</li> 
</ul>

<p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,1,1], target = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1], target = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 20</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= target &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 回溯</details><br>

<div>👍 1649, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=target-sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 207 页。

这题有多种解法，可以用回溯算法剪枝求解，也可以用转化成背包问题求解，这里用前者吧，容易理解一些，背包问题解法可以查看详细题解。

对于每一个 1，要么加正号，要么加负号，把所有情况穷举出来，即可计算结果。

**详细题解：[动态规划和回溯算法到底谁是谁爹？](https://labuladong.github.io/article/fname.html?fname=targetSum)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[背包问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122018870755491844)**

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
    int findTargetSumWays(vector<int>& nums, int target) {
        if (nums.empty()) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    unordered_map<string, int> memo;

    int dp(vector<int>& nums, int i, int remain) {
        // base case
        if (i == nums.size()) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        string key = to_string(i) + "," + to_string(remain);
        // 避免重复计算
        if (memo.count(key)) {
            return memo[key];
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo[key] = result;
        return result;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        if len(nums) == 0: return 0
        # 调用备忘录函数
        return self.dp(nums, 0, target, {})

    def dp(self, nums, i, remain, memo): 
        # base case
        if i == len(nums):
            if remain == 0: return 1
            return 0
        # 把它俩转成字符串才能作为哈希表的键
        key = str(i) + "," + str(remain)
        # 避免重复计算
        if key in memo:
            return memo[key]
        # 还是穷举
        result = self.dp(nums, i + 1, remain - nums[i], memo) + self.dp(nums, i + 1, remain + nums[i], memo)
        # 记入备忘录
        memo[key] = result
        return result
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();

    int dp(int[] nums, int i, int remain) {
        // base case
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findTargetSumWays(nums []int, target int) int {
    // 如果nums为空，则直接返回0
    if len(nums) == 0 {
        return 0
    }
    // 定义备忘录
    memo := make(map[string]int)
    // 调用DP函数
    return dp(nums, 0, target, memo)
}

func dp(nums []int, i, remain int, memo map[string]int) int {
    // base case
    if i == len(nums) {
        if remain == 0 {
            return 1
        }
        return 0
    }
    // 把它俩转成字符串才能作为哈希表的键
    key := strconv.Itoa(i) + "," + strconv.Itoa(remain)
    // 避免重复计算
    if val, ok := memo[key]; ok {
        return val
    }
    // 还是穷举
    result := dp(nums, i+1, remain-nums[i], memo) + dp(nums, i+1, remain+nums[i], memo)
    // 记入备忘录
    memo[key] = result
    return result
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 传入一个整数数组和目标值target，求有多少种方法使得数组中的元素之和为target，每个元素可以选择加或者减
var findTargetSumWays = function (nums, target) {
  // 数组长度为0直接返回0
  if (nums.length === 0) return 0;

  // 备忘录哈希表，记录已经计算过的子问题的结果，避免重复计算
  const memo = new Map();

  // 递归函数
  const dp = (nums, i, remain) => {
    // 如果已经遍历到了数组的末尾，判断remain是否等于0，如果等于0则返回1，否则返回0
    if (i === nums.length) {
      if (remain === 0) return 1;
      return 0;
    }

    // 用i和remain作为键，判断是否已经计算过这个子问题，如果已经计算，则直接返回结果，否则继续计算
    const key = i + "," + remain;

    if (memo.has(key)) {
      return memo.get(key);
    }

    // 分别递归计算加上和减去当前元素后能够得到目标值的方案数量，相加得到当前子问题的解
    const result =
      dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);

    // 把计算结果存入备忘录
    memo.set(key, result);

    // 返回当前子问题的解
    return result;
  };

  // 从0开始遍历数组，计算从每个索引开始的子问题，最终得到问题的解
  return dp(nums, 0, target);
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_target-sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_target-sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 102. 加减的目标值 🟠](/problems/YaVDxD)

</details>
</div>



