<p>There is an <strong>undirected</strong> graph with <code>n</code> nodes, where each node is numbered between <code>0</code> and <code>n - 1</code>. You are given a 2D array <code>graph</code>, where <code>graph[u]</code> is an array of nodes that node <code>u</code> is adjacent to. More formally, for each <code>v</code> in <code>graph[u]</code>, there is an undirected edge between node <code>u</code> and node <code>v</code>. The graph has the following properties:</p>

<ul> 
 <li>There are no self-edges (<code>graph[u]</code> does not contain <code>u</code>).</li> 
 <li>There are no parallel edges (<code>graph[u]</code> does not contain duplicate values).</li> 
 <li>If <code>v</code> is in <code>graph[u]</code>, then <code>u</code> is in <code>graph[v]</code> (the graph is undirected).</li> 
 <li>The graph may not be connected, meaning there may be two nodes <code>u</code> and <code>v</code> such that there is no path between them.</li> 
</ul>

<p>A graph is <strong>bipartite</strong> if the nodes can be partitioned into two independent sets <code>A</code> and <code>B</code> such that <strong>every</strong> edge in the graph connects a node in set <code>A</code> and a node in set <code>B</code>.</p>

<p>Return <code>true</code><em> if and only if it is <strong>bipartite</strong></em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg" style="width: 222px; height: 222px;" /> 
<pre>
<strong>Input:</strong> graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg" style="width: 222px; height: 222px;" /> 
<pre>
<strong>Input:</strong> graph = [[1,3],[0,2],[1,3],[0,2]]
<strong>Output:</strong> true
<strong>Explanation:</strong> We can partition the nodes into two sets: {0, 2} and {1, 3}.</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>graph.length == n</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>0 &lt;= graph[u].length &lt; n</code></li> 
 <li><code>0 &lt;= graph[u][i] &lt;= n - 1</code></li> 
 <li><code>graph[u]</code>&nbsp;does not contain&nbsp;<code>u</code>.</li> 
 <li>All the values of <code>graph[u]</code> are <strong>unique</strong>.</li> 
 <li>If <code>graph[u]</code> contains <code>v</code>, then <code>graph[v]</code> contains <code>u</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 图</details><br>

<div>👍 470, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=is-graph-bipartite" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分图判定算法及应用](https://www.bilibili.com/video/BV18N4y1L7aa)

二分图判定问题等同于图论的「双色问题」：

**给你一幅「图」，请你用两种颜色将图中的所有顶点着色，且使得任意一条边的两个端点的颜色都不相同，你能做到吗**？

如果能成功对整幅图染色，则说明这是一幅二分图，否则就不是二分图。

思路也很简单，遍历一遍图，一边遍历一边染色，看看能不能用两种颜色给所有节点染色，且相邻节点的颜色都不相同。

**详细题解：[二分图判定算法](https://labuladong.github.io/article/fname.html?fname=二分图)**

**标签：二分图，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)**

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
    // 记录图是否符合二分图性质
    bool ok = true;
    // 记录图中节点的颜色，false 和 true 代表两种不同颜色
    vector<bool> color;
    // 记录图中节点是否被访问过
    vector<bool> visited;

    // 主函数，输入邻接表，判断是否是二分图
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        color.resize(n);
        visited.resize(n);
        // 因为图不一定是联通的，可能存在多个子图
        // 所以要把每个节点都作为起点进行一次遍历
        // 如果发现任何一个子图不是二分图，整幅图都不算二分图
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // DFS 遍历框架
    void traverse(vector<vector<int>>& graph, int v) {
        // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if (!ok) return;

        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v];
                // 继续遍历 w
                traverse(graph, w);
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜色判断是否是二分图
                if (color[w] == color[v]) {
                    // 若相同，则此图不是二分图
                    ok = false;
                }
            }
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        # 记录图是否符合二分图性质
        self.ok = True
        # 记录图中节点的颜色，false 和 true 代表两种不同颜色
        self.color = None
        # 记录图中节点是否被访问过
        self.visited = None

    # 主函数，输入邻接表，判断是否是二分图
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        self.color = [False] * n
        self.visited = [False] * n
        # 因为图不一定是联通的，可能存在多个子图
        # 所以要把每个节点都作为起点进行一次遍历
        # 如果发现任何一个子图不是二分图，整幅图都不算二分图
        for v in range(n):
            if not self.visited[v]:
                self.traverse(graph, v)
        return self.ok

    # DFS 遍历框架
    def traverse(self, graph: List[List[int]], v: int) -> None:
        # 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if not self.ok:
            return

        self.visited[v] = True
        for w in graph[v]:
            if not self.visited[w]:
                # 相邻节点 w 没有被访问过
                # 那么应该给节点 w 涂上和节点 v 不同的颜色
                self.color[w] = not self.color[v]
                # 继续遍历 w
                self.traverse(graph, w)
            else:
                # 相邻节点 w 已经被访问过
                # 根据 v 和 w 的颜色判断是否是二分图
                if self.color[w] == self.color[v]:
                    # 若相同，则此图不是二分图
                    self.ok = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    // 记录图是否符合二分图性质
    private boolean ok = true;
    // 记录图中节点的颜色，false 和 true 代表两种不同颜色
    private boolean[] color;
    // 记录图中节点是否被访问过
    private boolean[] visited;

    // 主函数，输入邻接表，判断是否是二分图
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        // 因为图不一定是联通的，可能存在多个子图
        // 所以要把每个节点都作为起点进行一次遍历
        // 如果发现任何一个子图不是二分图，整幅图都不算二分图
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // DFS 遍历框架
    private void traverse(int[][] graph, int v) {
        // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if (!ok) return;

        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v];
                // 继续遍历 w
                traverse(graph, w);
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜色判断是否是二分图
                if (color[w] == color[v]) {
                    // 若相同，则此图不是二分图
                    ok = false;
                }
            }
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func isBipartite(graph [][]int) bool {
    n := len(graph)
    // 记录图是否符合二分图性质
    ok := true
    // 记录图中节点的颜色，false 和 true 代表两种不同颜色
    color := make([]bool, n)
    // 记录图中节点是否被访问过
    visited := make([]bool, n)

    traverse := func(v int) {
        // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if !ok {
            return
        }

        visited[v] = true
        for _, w := range graph[v] {
            if !visited[w] {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v]
                // 继续遍历 w
                traverse(w)
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜色判断是否是二分图
                if color[w] == color[v] {
                    // 若相同，则此图不是二分图
                    ok = false
                }
            }
        }
    }

    // 因为图不一定是联通的，可能存在多个子图
    // 所以要把每个节点都作为起点进行一次遍历
    // 如果发现任何一个子图不是二分图，整幅图都不算二分图
    for v := 0; v < n; v++ {
        if !visited[v] {
            traverse(v)
        }
    }
    return ok
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} graph 邻接表
 * @return {boolean} 是否是二分图
 */
var isBipartite = function(graph) {
    // 记录图是否符合二分图性质
    let ok = true;
    // 记录图中节点的颜色，false 和 true 代表两种不同颜色
    const color = new Array(graph.length).fill(false);
    // 记录图中节点是否被访问过
    const visited = new Array(graph.length).fill(false);

    /**
     * DFS 遍历框架
     * @param {number} v 节点
     */
    const traverse = function(v) {
        // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
        if (!ok) {
            return;
        }

        visited[v] = true;
        for (const w of graph[v]) {
            if (!visited[w]) {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v];
                // 继续遍历 w
                traverse(w);
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜色判断是否是二分图
                if (color[w] === color[v]) {
                    // 若相同，则此图不是二分图
                    ok = false;
                }
            }
        }
    }

    // 因为图不一定是联通的，可能存在多个子图
    // 所以要把每个节点都作为起点进行一次遍历
    // 如果发现任何一个子图不是二分图，整幅图都不算二分图
    for (let v = 0; v < graph.length; v++) {
        if (!visited[v]) {
            traverse(v);
        }
    }

    return ok;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_is-graph-bipartite" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_is-graph-bipartite"></div></div>
</details><hr /><br />

**类似题目**：
  - [886. 可能的二分法 🟠](/problems/possible-bipartition)
  - [剑指 Offer II 106. 二分图 🟠](/problems/vEAB3K)

</details>
</div>



