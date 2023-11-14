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

<div>👍 275, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



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

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_number-of-closed-islands" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-closed-islands"></div></div>
</details><hr /><br />

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



