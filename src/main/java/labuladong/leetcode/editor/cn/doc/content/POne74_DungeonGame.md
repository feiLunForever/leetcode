<p>The demons had captured the princess and imprisoned her in <strong>the bottom-right corner</strong> of a <code>dungeon</code>. The <code>dungeon</code> consists of <code>m x n</code> rooms laid out in a 2D grid. Our valiant knight was initially positioned in <strong>the top-left room</strong> and must fight his way through <code>dungeon</code> to rescue the princess.</p>

<p>The knight has an initial health point represented by a positive integer. If at any point his health point drops to <code>0</code> or below, he dies immediately.</p>

<p>Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).</p>

<p>To reach the princess as quickly as possible, the knight decides to move only <strong>rightward</strong> or <strong>downward</strong> in each step.</p>

<p>Return <em>the knight's minimum initial health so that he can rescue the princess</em>.</p>

<p><strong>Note</strong> that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/13/dungeon-grid-1.jpg" style="width: 253px; height: 253px;" /> 
<pre>
<strong>Input:</strong> dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-&gt; RIGHT -&gt; DOWN -&gt; DOWN.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> dungeon = [[0]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == dungeon.length</code></li> 
 <li><code>n == dungeon[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 200</code></li> 
 <li><code>-1000 &lt;= dungeon[i][j] &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>

<div>👍 742, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=dungeon-game" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

`dp` 函数的定义：**从 `grid[i][j]` 到达终点（右下角）所需的最少生命值是 `dp(grid, i, j)`**。

我们想求 `dp(0, 0)`，那就应该试图通过 `dp(i, j+1)` 和 `dp(i+1, j)` 推导出 `dp(i, j)`，这样才能不断逼近 base case，正确进行状态转移。

状态转移方程：

```java
int res = min(
    dp(i + 1, j),
    dp(i, j + 1)
) - grid[i][j];

dp(i, j) = res <= 0 ? 1 : res;
```

**详细题解：[动态规划帮我通关了《魔塔》](https://labuladong.github.io/article/fname.html?fname=魔塔)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，二维矩阵，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    int calculateMinimumHP(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        // 备忘录中都初始化为 -1
        memo = vector<vector<int>>(m, vector<int>(n, -1));

        return dp(grid, 0, 0);
    }

    // 备忘录，消除重叠子问题
    vector<vector<int>> memo;

    /* 定义：从 (i, j) 到达右下角，需要的初始血量至少是多少 */
    int dp(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size();
        int n = grid[0].size();
        // base case
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return INT_MAX;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        int res = min(
                dp(grid, i, j + 1),
                dp(grid, i + 1, j)
        ) - grid[i][j];
        // 骑士的生命值至少为 1
        memo[i][j] = res <= 0 ? 1 : res;

        return memo[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def calculateMinimumHP(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        # 备忘录中都初始化为 -1
        memo = [[-1 for _ in range(n)] for _ in range(m)]

        return self.dp(grid, 0, 0, memo)

    def dp(self, grid: List[List[int]], i: int, j: int, memo: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        # base case
        if i == m - 1 and j == n - 1:
            return 1 if grid[i][j] >= 0 else -grid[i][j] + 1
        if i == m or j == n:
            return float('inf')
        # 避免重复计算
        if memo[i][j] != -1:
            return memo[i][j]
        # 状态转移逻辑
        res = min(
                self.dp(grid, i, j + 1, memo),
                self.dp(grid, i + 1, j, memo)
        ) - grid[i][j]
        # 骑士的生命值至少为 1
        memo[i][j] = 1 if res <= 0 else res

        return memo[i][j]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 备忘录中都初始化为 -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(grid, 0, 0);
    }

    // 备忘录，消除重叠子问题
    int[][] memo;

    /* 定义：从 (i, j) 到达右下角，需要的初始血量至少是多少 */
    int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // base case
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        int res = Math.min(
                dp(grid, i, j + 1),
                dp(grid, i + 1, j)
        ) - grid[i][j];
        // 骑士的生命值至少为 1
        memo[i][j] = res <= 0 ? 1 : res;

        return memo[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import "math"

func calculateMinimumHP(grid [][]int) int {
    m := len(grid)
    n := len(grid[0])
    // 备忘录中都初始化为 -1
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }

    return dp(grid, 0, 0, memo)
}

/* 定义：从 (i, j) 到达右下角，需要的初始血量至少是多少 */
func dp(grid [][]int, i, j int, memo [][]int) int {
    m := len(grid)
    n := len(grid[0])
    // base case
    if i == m-1 && j == n-1 {
        if grid[i][j] >= 0 {
            return 1
        } else {
            return -grid[i][j] + 1
        }
    }
    if i == m || j == n {
        return math.MaxInt32
    }
    // 避免重复计算
    if memo[i][j] != -1 {
        return memo[i][j]
    }
    // 状态转移逻辑
    res := int(math.Min(
        float64(dp(grid, i, j+1, memo)),
        float64(dp(grid, i+1, j, memo)),
    )) - grid[i][j]
    // 骑士的生命值至少为 1
    if res <= 0 {
        memo[i][j] = 1
    } else {
        memo[i][j] = res
    }

    return memo[i][j]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var calculateMinimumHP = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    // 备忘录中都初始化为 -1
    const memo = new Array(m).fill().map(() => new Array(n).fill(-1));

    function dp(i, j) {
        // base case
        if (i === m - 1 && j === n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i === m || j === n) {
            return Number.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        const res = Math.min(dp(i, j + 1), dp(i + 1, j)) - grid[i][j];
        // 骑士的生命值至少为 1
        memo[i][j] = res <= 0 ? 1 : res;

        return memo[i][j];
    }

    return dp(0, 0);
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_dungeon-game" data="iwGAbnVsbAM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_dungeon-game"></div></div>
</details><hr /><br />

</details>
</div>



