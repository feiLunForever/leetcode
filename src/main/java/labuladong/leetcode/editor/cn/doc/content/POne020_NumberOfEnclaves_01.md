<p>You are given an <code>m x n</code> binary matrix <code>grid</code>, where <code>0</code> represents a sea cell and <code>1</code> represents a land cell.</p>

<p>A <strong>move</strong> consists of walking from one land cell to another adjacent (<strong>4-directionally</strong>) land cell or walking off the boundary of the <code>grid</code>.</p>

<p>Return <em>the number of land cells in</em> <code>grid</code> <em>for which we cannot walk off the boundary of the grid in any number of <strong>moves</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves1.jpg" style="width: 333px; height: 333px;" /> 
<pre>
<strong>Input:</strong> grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves2.jpg" style="width: 333px; height: 333px;" /> 
<pre>
<strong>Input:</strong> grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All 1s are either on the boundary or can reach the boundary.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 500</code></li> 
 <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 243, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-enclaves" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

这道题和 [1254. 统计封闭岛屿的数目](/problems/number-of-closed-islands) 基本一样，只是后者让你算封闭岛屿的数量，这题让你算这些封闭岛屿的陆地总数，稍微改改代码就行了。

注意这题中 `1` 代表陆地，`0` 代表海水。

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
    int numEnclaves(vector<vector<int>>& grid) {

        int m = grid.size(), n = grid[0].size();
        
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
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
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        for i in range(m):
            self.dfs(grid, i, 0)
            self.dfs(grid, i, n - 1)

        for j in range(n):
            self.dfs(grid, 0, j)
            self.dfs(grid, m - 1, j)

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res += 1
        return res

    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
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
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
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

// LeetCode 题目链接 https://leetcode-cn.com/problems/number-of-enclaves/
func numEnclaves(grid [][]int) int {
    m, n := len(grid), len(grid[0])

    for i := 0; i < m; i++ {
        dfs(grid, i, 0)
        dfs(grid, i, n-1)
    }

    for j := 0; j < n; j++ {
        dfs(grid, 0, j)
        dfs(grid, m-1, j)
    }

    var res int
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 1 {
                res += 1
            }
        }
    }
    return res
}

func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
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
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function(grid) {
    var m = grid.length, n = grid[0].length;

    for (var i = 0; i < m; i++) {
        dfs(grid, i, 0);
        dfs(grid, i, n - 1);
    }

    for (var j = 0; j < n; j++) {
        dfs(grid, 0, j);
        dfs(grid, m - 1, j);
    }

    var res = 0;
    for (var row = 0; row < m; row++) {
        for (var col = 0; col < n; col++) {
            if (grid[row][col] === 1) {
                res += 1;
            }
        }
    }
    return res;
};

function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] === 0) {
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

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_number-of-enclaves" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-enclaves"></div></div>
</details><hr /><br />

**类似题目**：
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



