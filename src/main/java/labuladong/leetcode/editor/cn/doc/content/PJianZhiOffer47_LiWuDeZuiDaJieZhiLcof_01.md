English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>

<div>👍 509, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！[第 21 期打卡挑战](https://opedk.xet.tech/s/4ptSo2) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题就是前文 [最小路径和问题](https://labuladong.github.io/article/fname.html?fname=最小路径和) 中讲的 [64. 最小路径和（中等）](/problems/minimum-path-sum)，几乎完全一样，你只需要把那道题解法中的 `min` 改成 `max` 即可解决这道题。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    int maxValue(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));

        /**** base case ****/
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = max(
                    dp[i - 1][j],
                    dp[i][j - 1]
                ) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[0] * n for _ in range(m)]

        # base case
        dp[0][0] = grid[0][0]
        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] + grid[i][0]

        for j in range(1, n):
            dp[0][j] = dp[0][j - 1] + grid[0][j]

        # 状态转移
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = max(
                    dp[i - 1][j],
                    dp[i][j - 1]
                ) + grid[i][j]

        return dp[m - 1][n - 1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        /**** base case ****/
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(
                    dp[i - 1][j],
                    dp[i][j - 1]
                ) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxValue(grid [][]int) int {
    m := len(grid)
    n := len(grid[0])
    dp := make([][]int, m)
    for i := range dp {
        dp[i] = make([]int, n)
    }

    /**** base case ****/
    dp[0][0] = grid[0][0]
    for i := 1; i < m; i++ {
        dp[i][0] = dp[i-1][0] + grid[i][0]
    }

    for j := 1; j < n; j++ {
        dp[0][j] = dp[0][j-1] + grid[0][j]
    }

    // 状态转移
    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            dp[i][j] = max(
                dp[i-1][j],
                dp[i][j-1],
            ) + grid[i][j]
        }
    }
    return dp[m-1][n-1]
}

func max(nums ...int) int {
    res := nums[0]
    for _, num := range nums[1:] {
        if num > res {
            res = num
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var maxValue = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let dp = new Array(m).fill().map(() => new Array(n).fill(0));

    /**** base case ****/
    dp[0][0] = grid[0][0];
    for (let i = 1; i < m; i++)
        dp[i][0] = dp[i - 1][0] + grid[i][0];

    for (let j = 1; j < n; j++)
        dp[0][j] = dp[0][j - 1] + grid[0][j];

    // 状态转移
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[i][j] = Math.max(
                dp[i - 1][j],
                dp[i][j - 1]
            ) + grid[i][j];
        }
    }
    return dp[m - 1][n - 1];
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_li-wu-de-zui-da-jie-zhi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_li-wu-de-zui-da-jie-zhi-lcof"></div></div>
</details><hr /><br />

</details>
</div>



