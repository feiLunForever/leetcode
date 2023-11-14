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

<div>👍 109, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



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

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_count-sub-islands" data="W2uCMTIQbBwQ4rFpkQFh45iZNZg2GxHBxgGgMtOAWh5wQyb4ISW4+MOWNx+Ln7nkAYqvQZoV1RPo5P2Zk2afRadyBrjD5Jrus8tFzNN/upCzwBSmS4omUMzLfX5rlep/pBFG24raAWvCqhJaPZjZlOqTAufclNwyGej5YkH6uV6dBQh4YGZuOGNZEEDFFl7+UKbH9bTdIGJEIep/rWWJmwl2iHV8jAEiD2h38AUIZCrC5+/vnk34jh0Ae33abZ0ae3V+ubcJe0eXkp45i3FNqLpg5ZX8hT6ewSj/5udtKLuJQgl4/v0TgZpU+q0p2uTjl1Hz6BgWZ7b4eEnxZ7IL//8cKgYDuNaNUYRyKvhHX8fUTOuYgHthKacULBcsGoZS23tGa3eEDFgFzIz936zc01grtDelFhYYHABNAzAJhKFiTmIKMUfsC9Wl7v39mP8H07c2ikZYf0xuYCAbeXm1WQ2pGDC05ogRjx+jd9jPycTb5yTIjqYmjj8kyImHgSM0aqnDzGRN9TX3oyxhVuY/GN3kdHfgRFERJ/8oYkvMxmMypqvFtxS93ZqxH0pVY41RhGNTAVMHGd/GAkVpFDRk7s+fpN54gWic429hN0Lw/Ll0JxFS4PRSFPHSBiVTMarXjgMRo3Rx5rWVVos2dFs1iF5Lfk6bAP4CR702U0gyyhUTXjnv2Amkh2oge+1u6ikRXNHyaBaGmv+dU/wttY75jOzXamq3uCeI/tkSkn3MybT4Mh2ORm3SSphLmNICjznnnrCOZFrPNCXT2a/p20IsbTXp4eYMi6hnDiuJ5AzQw9rLTiXQ0cdMFq/o+nbNwqpkn1N1m88zbaH2YoXqxOLZi5fIy2z2RWoU04uriUhbqWS5EHBb6nRNp5myYzGoNLzU9QvrD98Okh4zHs33/C5XttH9EfUIzE7RkKFK/RH7SDrVeaKAlvD5Kq/0Y/Zr1Z0/5EqTcKr3QYY6ie76mmpJv/Hp1ycFk8RTqIVK4GkW3WGUlElLngrum1whElgSQsD4w8LfkatWMtW2tfD2hKsYVpoW8TK+INchLyvXKS8n16Vkp+HWE/G4T5/QM9zQJVn6PAVRwyMmcBLsFWae1JNIN9NNUraznPlCxHlLp6rXwtdiAgriiHdidMmBhDjcJsJJwFcYX7U/9U4a/6xH6KrnraYeHjGBk8CtMJwsDYeDk8DBOJJXD8lnj1pIPLJfiNvC9GfoGVN285tUUg291c+aUmt02Xz2tode2jvvGHNlg06sql/DDHVEqr7Sr+keqhaSFgfwoNEnZTgb9RqhJoDiBz8pvcIVD4sTep8A9YB7NodNjbGbaaMohdmJwOnCU6lxfWtBej7v75JLs9EeRYJmRmdP4YvxzjhVlt95pt6MW29eZ7dan0J7TbOvLId29bFVhlvEldI+besvuNVvQepMtS0XJvjj2qXyYQP7NFQuhsLlgndnOS0RChOFUr8W3Bc2CK9fmrBhvPllxBOuW89vf/tSjjc99jdc8a+ApMeqqqtsPitHldTDXMjAEM8Cjob33yFiJqGr73/QJq7m9AFQXlW3oAA++v5WQBgXokf1AdTzduNXQExABNjfCgjjQvSk1i1dWrfui76B8qJR15nUWBLRB/s/3SqEBZzUpvw71P1KG475v7IHier0gf04/IxUCMvTrvCuJmiofP0pql1G4JnF3aSbZkT+m1r/TvKuVhPqL4hRlaNmtpjZOWhdhNCkMdMToS87HtbvXrOcNIZcgnsRp7zrXRJlLon2LEMBdB8AwbUophm1ve67hoy+KuoDTKDDTgmlRWuBaN0yinywqqIYv6txgErLr7xlhru1UIY5rkZFoBUBmlr+5K3UWiTDDCgCrwjQU2t4Kt9JIeDHk6bQUJR370z5rCkJB4+EHHC46tcmt4Tb+uiPAG2IcptEbHHMdFgzs02VY6glo39DxIGkmE7VeDIaOwYRj2aV6dCmTLGjshnT7nGOgIvpudfp/OP4/kTenc3Hac4+X7mZAz7fTfpJQRDoUnaz+nWVm9Ovm5KdzjnXHEGn2ffcjF3OuiBvMCVBAQFuIy7OpBb+UiYScBAJOFhC7KqM48UcDoFIwC1lIgGO6zxBHQZ1Y+0DOGBSXrwpoFA2B9TfWigiDilkhmDN5Jt9AAWOt8osthbJ5NywC9JNHClUg2DNHenvqFz4SaqjGeDmvKBVjqautgCGFiaYnGa8FCIwFOmmfa2enVdsiY9Z7YAEOQYMSwZiS55kSfO2ev2r71eCpjOvIC4kIL/j+j22HwAmWO0LgcheeUPZNLJ+Obd03Y9NYPxXp/5rhGb/zrSInKblz7EqVttXKtFO6ZFLGxX03xe14vfKu9HSarEb14sHEL84RhEnOqYSm8mnLhRzee0oZNUlA6NEhb0QQykL+0gAvxDgRACbeUbUABHjZff40eHfLKxENtw20F1dpGmfGtPnKaohFBVW71JhWR6V28YfRVG6WlQYKJuqL6SebyfacYi9b5NyV87oJkXZ26rePRZTlVEWlNNUTmEMOu0NMWz4cl1UsE/8cC6Uk2wu1xbDhfpFrZnZzn1PGZ6Ok+oVa/otZrWklh+Uj1Md1biUpYI1Va/eP0ooMNdexZfPVfpSE2q3IZVqgZGm6QRhGSu9jt5qW1Kc2jc4fas2FUEqYh5B1XxOVjT5cCrPQwkVaOBMyT1q+1kZ27iq6S6ulK7F9xt11M5FAfVrUoNiRBQto6QKS3BOYTzX7COUvbAkq33iuO1Iu8xYLXHAWZs4pDgz5tuUaXBTmKoME50yVfSkQAEahTPiUTejLSolK0D13AYpGO1M5ZwIVj3aLSpgY6sqkxqmYNcabtSSAn3KDeMOCsiPoUK/26rLJoLywx6hKIWiFVDZnNpmCfKzMjPuq2SkDAqvkErFCVqrOJuxahqgpbak6lXxhaXqbk1M9SWszLOlirNh/Bv1gEJWvebeld6JlIqHuKm7KV41hFZbaSf4KIoypthiLW0eZh4GNNvkXc0CKc4+1jhSudbrUIXq7qlpJGhU20aoWNDtjDTEWco1UCeniMpeWdU00WSWgTKisFV6TTxqOgFNYeMdU7GrelEDYFYF8U5QqMdZKvRFkPJWOnurpMp61Jk9DIU5Ff+/hZBpn2hoU1U1ZQ1O1h3bR/WFyg2+nvITrca0TxbF68xwvBhX8V2ErUa3W2AJ4/7b34m93MjPWEybQ42DNtfwTa8CsRt/Zt3+z47HU4x0vq+O5/vmqT/1rlDzrazwoq/2gA5XLUNroC1xT6cdDQTtAHnsCB8AK+CLzd7dKjz3jA5WxtPHSGH+USBOzvGP5DmLsBms0c0Ofw4rkHqpN/CFKtBcCNZwQNCGE/bYicuU9oQ53AioqRSgPfN2CBEUCTGOKBQarskEQyjZUGi4ho9bNSuHNOGaRNPeVznX+JpwqrJtZsx/4d/wrwv7jq7N7cLXbWreV/yh86kQ0R1uM38Ti0Vpu2Orgr81Yg2ltgr821oQYER7yTUL5LJx4JIK7rjT+TefTYQF0+D5Av+c/BRY+BtpU28bLvWGDHP+bHfso1UvLUvrBmLJ27Wb8bXnAbh+ju+sqbw19pb/8I93uC/lfHRJ0w6Tve4lSDqd3lQzvfAynvH0qpn6GjrmWAPAffhZBS8t2iLNFiqaplV70yPiUBfNanBCXBF2TvOcxL1S7qzMu2I/e/yXvmvZBkoUvTTAme3ay3ZGxyUnCl2XhJyrPDZXW/pkChU6hotzSifT12aBv4QFkFIoRyjwDAbqu2CcmU6LbiC4Os/hBWXtIObovrszm1PlTp8Xf8zt69eXPNz8+mwJUaTTkevZwRc1ySMIHJCeZdaWsxKoQE/rxq7JdtN3w7di1tOvhEtHt2mPIkoTfkgvI/tpS+m3xcb2AywYPUQycn0D4QeE/YBPbAiMUYIpxxtJ3sjy5s5vlHojyBvd3ZzXjYpuxHKjiZvTt1G4jZBt9GpzljbqsxGZjZZsTsZGGTYCsNF5zTnXqLZGnDUarDm1GkXVCKdGHzUy6NegdhpR02iXRqI0l0gjOBpd0ciH5kpoxECj+Rlpz1zwjFBn9Dgju5nrmhHRjFZmJDFz+TICl9GxjFxlrlJGfDIak5GSzMXICENG/zEyj7nmGNHGaDNGgjGXFiOoGN3EyCPmCmLEDqNpGOnCXCiMEGH0BiMrmOuBEQmMFmAYSP7msm8EfKPTGzn+a92imZm4bjR0I5UbRdwcvo2+bWRso1abo7TRno3EbJRkczA2urCRf43Ka465RrM10qxRYM2h1eipRjY16qg5ghqt00iaRrk0B0qjQxq50aiK5nhoNEIjBRrFzxz2jH5nZDqjxpmjGx77/9vo4/+1sgvbXfUptV4THnz/Ne4Pvrt/KMPdCrhbWe5WjruV524VuNtTkof3giixrVWxqGFba7KosG0ZtjWYRS3b2opFHdvakW3Ls6iwrYPZ9oysOjxhTUOIZmEUEEsYZYw6RLsQqzFKGBWMOkQNRi8xajEqiD5ilLCdUYVoAKOIWES0CqOAaDdGDWI1oscY1Yi1iI4wyoi+YNRhO6ML0SBGLUYFsYhoDUYtYhnRXRjVGDWINYheY1QjVjAqiD5hlLGdMYVoEKOEaAajDtEGRhGxGtEDjCKi1xjViBVEnzGqsV2GWowKYgHRXIwKol0YBUS3MCqIHiF6iVGL6BCjFtE32C7bAkYNoiGMMmIRoxbRIkYJ0V6MCmI1ogcYNRi1iA4wioi+xahgO+MK0RiMWsQiojUYtYhlRHdj1CDWIM6u8PTBQtEwkU/BvziGwfkBBuIReB889eXPHr+DCSYUHCT/LbKc9uPF/qR7ivNIDueHx2TgG08N7MqxlvtU2tM6vvvnAaBR+yr2iLQiGJg/PLz6HHO//Z1Qsew/7Tj439vECpr1iTLj+vOP6yv5X9ZCgHZ4ch+CT4aanXfJk/LE4Wo5+wvYLHeL3roRTApESh1QBziOEK//CV5p9q9gvrymR/MpNhRSD+U7qvGrnv9YjTBg8rLbQCbkejg+c1nw8J9Ww7c//09cFmyaIV1ktw3vIP+weaDs4WgLr7aX647XFcgHoTSGR7WJ38T0vjp+RRwVHFT5Phe/H+STt20QjWCfTskfHpRCu7cUxgZlfin+Krdo9jowwTWaf4cJT7lfpYFDDu0oefPWaSuNicn9451uiHT5B5qU19g37+HutjjhnEK513HJT/o2YpbrYegpPfTxkEBPcIzHF99xuZfbJn/D+NNSBA=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_count-sub-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



