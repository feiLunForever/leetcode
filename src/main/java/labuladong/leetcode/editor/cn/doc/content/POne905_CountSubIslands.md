<p>You are given two <code>m x n</code> binary matrices <code>grid1</code> and <code>grid2</code> containing only <code>0</code>'s (representing water) and <code>1</code>'s (representing land). An <strong>island</strong> is a group of <code>1</code>'s connected <strong>4-directionally</strong> (horizontal or vertical). Any cells outside of the grid are considered water cells.</p>

<p>An island in <code>grid2</code> is considered a <strong>sub-island </strong>if there is an island in <code>grid1</code> that contains <strong>all</strong> the cells that make up <strong>this</strong> island in <code>grid2</code>.</p>

<p>Return the <em><strong>number</strong> of islands in </em><code>grid2</code> <em>that are considered <strong>sub-islands</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/test1.png" style="width: 493px; height: 205px;" /> 
<pre>
<strong>Input:</strong> grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
<strong>Output:</strong> 3
<strong>Explanation: </strong>In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/03/testcasex2.png" style="width: 491px; height: 201px;" /> 
<pre>
<strong>Input:</strong> grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
<strong>Output:</strong> 2 
<strong>Explanation: </strong>In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid1.length == grid2.length</code></li> 
 <li><code>n == grid1[i].length == grid2[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 500</code></li> 
 <li><code>grid1[i][j]</code> and <code>grid2[i][j]</code> are either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 100, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=count-sub-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

**这道题的关键在于，如何快速判断子岛屿**？

什么情况下 `grid2` 中的一个岛屿 `B` 是 `grid1` 中的一个岛屿 `A` 的子岛？

当岛屿 `B` 中所有陆地在岛屿 `A` 中也是陆地的时候，岛屿 `B` 是岛屿 `A` 的子岛。

**反过来说，如果岛屿 `B` 中存在一片陆地，在岛屿 `A` 的对应位置是海水，那么岛屿 `B` 就不是岛屿 `A` 的子岛**。

那么，我们只要遍历 `grid2` 中的所有岛屿，把那些不可能是子岛的岛屿排除掉，剩下的就是子岛。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)**

**标签：[DFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，二维矩阵**

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
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid1.size(), n = grid1[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    // 这个岛屿肯定不是子岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        m, n = len(grid1), len(grid1[0])

        # 遍历 grid2，将非子岛的岛屿淹掉
        for i in range(m):
            for j in range(n):
                if grid1[i][j] == 0 and grid2[i][j] == 1:
                    self.dfs(grid2, i, j)

        # 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        res = 0
        for i in range(m):
            for j in range(n):
                if grid2[i][j] == 1:
                    res += 1
                    self.dfs(grid2, i, j)

        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if grid[i][j] == 0:
            return

        grid[i][j] = 0
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    // 这个岛屿肯定不是子岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func countSubIslands(grid1 [][]int, grid2 [][]int) int {
    m, n := len(grid1), len(grid1[0])
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid1[i][j] == 0 && grid2[i][j] == 1 {
                // 这个岛屿肯定不是子岛，淹掉
                dfs(grid2, i, j)
            }
        }
    }
    // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
    res := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid2[i][j] == 1 {
                res++
                dfs(grid2, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        return
    }
    if grid[i][j] == 0 {
        return
    }

    grid[i][j] = 0
    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} grid1
 * @param {number[][]} grid2
 * @return {number}
 */
var countSubIslands = function(grid1, grid2) {
    const m = grid1.length, n = grid1[0].length;

    // 淹没非子岛屿
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                dfs(grid2, i, j);
            }
        }
    }

    // 计算子岛屿数量
    let res = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid2[i][j] == 1) {
                res++;
                dfs(grid2, i, j);
            }
        }
    }
    return res;
};

// 深度优先遍历
function dfs(grid, i, j) {
    const m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        return;
    }
    if (grid[i][j] == 0) {
        return;
    }

    grid[i][j] = 0;
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_count-sub-islands"></iframe>
</div>
<div id="data_count-sub-islands" data="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"></div></details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



