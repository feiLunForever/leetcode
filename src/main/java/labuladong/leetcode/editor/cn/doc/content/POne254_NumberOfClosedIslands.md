<p>Given a 2D&nbsp;<code>grid</code> consists of <code>0s</code> (land)&nbsp;and <code>1s</code> (water).&nbsp; An <em>island</em> is a maximal 4-directionally connected group of <code><font face="monospace">0</font>s</code> and a <em>closed island</em>&nbsp;is an island <strong>totally</strong>&nbsp;(all left, top, right, bottom) surrounded by <code>1s.</code></p>

<p>Return the number of <em>closed islands</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="width: 240px; height: 120px;" /></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
Islands in gray are closed because they are completely surrounded by water (group of 1s).</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png" style="width: 160px; height: 80px;" /></p>

<pre>
<strong>Input:</strong> grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1,1,1,1,1],
&nbsp;              [1,0,0,0,0,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,1,0,1,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li> 
 <li><code>0 &lt;= grid[i][j] &lt;=1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 248, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-closed-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

如何判断「封闭岛屿」呢？其实很简单，把 [200. 岛屿数量](/problems/number-of-islands) 中那些靠边的岛屿排除掉，剩下的不就是「封闭岛屿」了吗？

有了这个思路，就可以直接写出代码了，注意这题规定 `0` 表示陆地，用 `1` 表示海水。

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
    // 主函数：计算封闭岛屿的数量
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
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
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
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
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for j in range(n):
            # 把靠上边的岛屿淹掉
            self.dfs(grid, 0, j)
            # 把靠下边的岛屿淹掉
            self.dfs(grid, m - 1, j)
        for i in range(m):
            # 把靠左边的岛屿淹掉
            self.dfs(grid, i, 0)
            # 把靠右边的岛屿淹掉
            self.dfs(grid, i, n - 1)
        # 遍历 grid，剩下的岛屿都是封闭岛屿
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    res += 1
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if grid[i][j] == 1:
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = 1
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
     // 主函数：计算封闭岛屿的数量
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
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
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
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

// 计算封闭岛屿的数量
func closedIsland(grid [][]int) int {
    m, n := len(grid), len(grid[0])
    for j := 0; j < n; j++ {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j)
        // 把靠下边的岛屿淹掉
        dfs(grid, m-1, j)
    }
    for i := 0; i < m; i++ {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0)
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n-1)
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    res := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 0 {
                res++
                dfs(grid, i, j)
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
    if grid[i][j] == 1 {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1
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

var closedIsland = function(grid) {
    var m = grid.length, n = grid[0].length;
    for (var j = 0; j < n; j++) {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j);
        // 把靠下边的岛屿淹掉
        dfs(grid, m - 1, j);
    }
    for (var i = 0; i < m; i++) {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0);
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n - 1);
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    var res = 0;
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] === 0) {
                res++;
                dfs(grid, i, j);
            }
        }
    }
    return res;
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        return;
    }
    if (grid[i][j] === 1) {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1;
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
    style="overflow: auto;" id="iframe_number-of-closed-islands"></iframe>
</div>
<div id="data_number-of-closed-islands" data="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"></div></details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [130. 被围绕的区域 🟠](/problems/surrounded-regions)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



