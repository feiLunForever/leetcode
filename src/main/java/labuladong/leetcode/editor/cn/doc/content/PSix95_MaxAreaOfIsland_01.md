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

<div>👍 1025, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



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

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_max-area-of-island" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_max-area-of-island"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



