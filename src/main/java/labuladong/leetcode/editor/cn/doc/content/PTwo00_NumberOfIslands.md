<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>'1'</code>s (land) and <code>'0'</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 300</code></li> 
 <li><code>grid[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 2208, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

岛屿系列问题可以用 DFS/BFS 算法或者 [Union-Find 并查集算法](https://labuladong.github.io/article/fname.html?fname=UnionFind算法详解) 来解决。

用 DFS 算法解决岛屿题目是最常见的，每次遇到一个岛屿中的陆地，就用 DFS 算法吧这个岛屿「淹掉」。

如何使用 DFS 算法遍历二维数组？你把二维数组中的每个格子看做「图」中的一个节点，这个节点和周围的四个节点连通，这样二维矩阵就被抽象成了一幅网状的「图」。

为什么每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」呢？主要是为了省事，避免维护 `visited` 数组。

[图算法遍历基础](https://labuladong.github.io/article/fname.html?fname=图) 说了，遍历图是需要 `visited` 数组记录遍历过的节点防止走回头路。

因为 `dfs` 函数遍历到值为 `0` 的位置会直接返回，所以只要把经过的位置都设置为 `0`，就可以起到不走回头路的作用。

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
    // 主函数，计算岛屿数量
public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        int m = grid.size(), n = grid[0].size();
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

private:
    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<char>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
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
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        m = len(grid)
        n = len(grid[0])
        # 遍历 grid
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    # 每发现一个岛屿，岛屿数量加一
                    res += 1
                    # 然后使用 DFS 将岛屿淹了
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:
        m = len(grid)
        n = len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            # 超出索引边界
            return
        if grid[i][j] == '0':
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = '0'
        # 淹没上下左右的陆地
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数，计算岛屿数量
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
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

func numIslands(grid [][]byte) int {
    res := 0
    m, n := len(grid), len(grid[0])
    // 遍历 grid
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == '1' {
                // 每发现一个岛屿，岛屿数量加一
                res++
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]byte, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        // 超出索引边界
        return
    }
    if grid[i][j] == '0' {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0'
    // 淹没上下左右的陆地
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

var numIslands = function(grid) {
    var res = 0;
    var m = grid.length, n = grid[0].length;
    // 遍历 grid
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                // 每发现一个岛屿，岛屿数量加一
                res++;
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j);
            }
        }
    }
    return res;
};

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        // 超出索引边界
        return;
    }
    if (grid[i][j] == '0') {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0';
    // 淹没上下左右的陆地
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
    style="overflow: auto;" id="iframe_number-of-islands"></iframe>
</div>
<div id="data_number-of-islands" data="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"></div></details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



