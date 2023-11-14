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

<div>👍 2348, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



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

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_number-of-islands" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



