<p>You are given an <code>m x n</code> binary matrix <code>grid</code>. An island is a group of <code>1</code>'s (representing land) connected <strong>4-directionally</strong> (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.</p>

<p>The <strong>area</strong> of an island is the number of cells with a value <code>1</code> in the island.</p>

<p>Return <em>the maximum <strong>area</strong> of an island in </em><code>grid</code>. If there is no island, return <code>0</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg" style="width: 500px; height: 310px;" /> 
<pre>
<strong>Input:</strong> grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The answer is not 11, because the island must be connected 4-directionally.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[0,0,0,0,0,0,0,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 50</code></li> 
 <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 975, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=max-area-of-island" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

这题的大体思路和 [200. 岛屿数量](/problems/number-of-islands) 完全一样，只不过 `dfs` 函数淹没岛屿的同时，还应该想办法记录这个岛屿的面积。

我们可以给 `dfs` 函数设置返回值，记录每次淹没的陆地的个数，直接看解法吧。

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
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        // 记录岛屿的最大面积
        int res = 0;
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    res = max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    int dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0;
        }
        if (grid[i][j] == 0) {
            // 已经是海水了
            return 0;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;

        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # 记录岛屿的最大面积
        res = 0
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    # 淹没岛屿，并更新最大岛屿面积
                    res = max(res, self.dfs(grid, i, j))
        return res
    
    # 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    def dfs(self, grid: List[List[int]], i: int, j: int) -> int:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            # 超出索引边界
            return 0
        if grid[i][j] == 0:
            # 已经是海水了
            return 0
        # 将 (i, j) 变成海水
        grid[i][j] = 0

        return self.dfs(grid, i + 1, j) 
               + self.dfs(grid, i - 1, j) 
               + self.dfs(grid, i, j + 1) 
               + self.dfs(grid, i, j - 1) 
               + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // 记录岛屿的最大面积
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0;
        }
        if (grid[i][j] == 0) {
            // 已经是海水了
            return 0;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;

        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxAreaOfIsland(grid [][]int) int {
    // 记录岛屿的最大面积
    res := 0
    m, n := len(grid), len(grid[0])
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 1 {
                // 淹没岛屿，并更新最大岛屿面积
                res = Max(res, dfs(grid, i, j))
            }
        }
    }
    return res
}

// 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
func dfs(grid [][]int, i int, j int) int {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        // 超出索引边界
        return 0
    }
    if grid[i][j] == 0 {
        // 已经是海水了
        return 0
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 0

    return dfs(grid, i+1, j) +
           dfs(grid, i, j+1) +
           dfs(grid, i-1, j) +
           dfs(grid, i, j-1) + 1
}

// Max 获取两个数的最大值
func Max(x int, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var maxAreaOfIsland = function(grid) {
    // 记录岛屿的最大面积
    let res = 0;
    const m = grid.length, n = grid[0].length;
    
    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    const dfs = (grid, i, j) => {
        const m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0;
        }
        if (grid[i][j] === 0) {
            // 已经是海水了
            return 0;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;

        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + 1;
    };
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                // 淹没岛屿，并更新最大岛屿面积
                res = Math.max(res, dfs(grid, i, j));
            }
        }
    }
    
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👉 算法可视化 👈</strong></summary><div class="resizable aspect-ratio-container" style="height: 70vh;">
    <iframe src="https://labuladong.github.io/algo-visualize/" width="100%"
    height="100%" scrolling="auto" frameborder="0"
    style="overflow: auto;" id="iframe_max-area-of-island"></iframe>
</div>
<div id="data_max-area-of-island" data="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"></div></details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



