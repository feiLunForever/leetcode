English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 动态规划</details><br>

<div>👍 621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 19 期刷题打卡](https://aep.xet.tech/s/32wqt4) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

用一个标准的 DFS 遍历就可以了，类似的题目可以参见 [DFS 算法秒杀岛屿系列题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)。

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
    int movingCount(int m, int n, int k) {
        vector<vector<bool>> visited(m, vector<bool>(n, false)); // 初始化 visited 矩阵为 false
        dfs(m, n, k, 0, 0, visited);
        return res;
    }
    
    // 记录合法坐标数
    int res = 0;
    
    void dfs(int m, int n, int k, int i, int j, vector<vector<bool>>& visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        
        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }
        
        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }
        
        // 走到一个合法坐标
        res++;
        visited[i][j] = true;
        
        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        def dfs(i: int, j: int, visited: List[List[bool]]):
            nonlocal res
            if i < 0 or j < 0 or i >= m or j >= n:
                # 超出索引边界
                return

            if i // 10 + i % 10 + j // 10 + j % 10 > k:
                # 坐标和超出 k 的限制
                return

            if visited[i][j]:
                # 之前已经访问过当前坐标
                return

            # 走到一个合法坐标
            res += 1
            visited[i][j] = True

            # DFS 遍历上下左右
            dfs(i + 1, j, visited)
            dfs(i, j + 1, visited)
            dfs(i - 1, j, visited)
            dfs(i, j - 1, visited)

        # 记录合法坐标数
        res = 0
        visited = [[False] * n for _ in range(m)]
        dfs(0, 0, visited)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(m, n, k, 0, 0, visited);
        return res;
    }

    // 记录合法坐标数
    int res = 0;

    public void dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }

        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }

        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }

        // 走到一个合法坐标
        res++;
        visited[i][j] = true;

        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func movingCount(m int, n int, k int) int {
    visited := make([][]bool, m)
    for i := 0; i < m; i++ {
        visited[i] = make([]bool, n)
    }
    res := 0
    dfs(m, n, k, 0, 0, visited, &res)
    return res
}

func dfs(m, n, k, i, j int, visited [][]bool, res *int) {
    if i < 0 || j < 0 || i >= m || j >= n {
        return // 超出索引边界
    }
    if i/10+i%10+j/10+j%10 > k {
        return // 坐标和超出 k 的限制
    }
    if visited[i][j] {
        return // 之前已经访问过当前坐标
    }
    *res++
    visited[i][j] = true
    dfs(m, n, k, i+1, j, visited, res)
    dfs(m, n, k, i, j+1, visited, res)
    dfs(m, n, k, i-1, j, visited, res)
    dfs(m, n, k, i, j-1, visited, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var movingCount = function(m, n, k) {
    let visited = new Array(m).fill(false).map(() => new Array(n).fill(false));
    let res = 0;
    
    function dfs(m, n, k, i, j, visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }

        if (Math.floor(i / 10) + i % 10 + Math.floor(j / 10) + j % 10 > k) {
            // 坐标和超出 k 的限制
            return;
        }

        if (visited[i][j]) {
            // 之前已经访问过当前坐标
            return;
        }

        // 走到一个合法坐标
        res++;
        visited[i][j] = true;

        // DFS 遍历上下左右
        dfs(m, n, k, i + 1, j, visited);
        dfs(m, n, k, i, j + 1, visited);
        dfs(m, n, k, i - 1, j, visited);
        dfs(m, n, k, i, j - 1, visited);
    }
    
    dfs(m, n, k, 0, 0, visited);
    return res;
};
```

</div></div>
</div></div>

</details>
</div>



