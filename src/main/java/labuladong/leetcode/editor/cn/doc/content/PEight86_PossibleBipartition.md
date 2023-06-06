<p>We want to split a group of <code>n</code> people (labeled from <code>1</code> to <code>n</code>) into two groups of <strong>any size</strong>. Each person may dislike some other people, and they should not go into the same group.</p>

<p>Given the integer <code>n</code> and the array <code>dislikes</code> where <code>dislikes[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that the person labeled <code>a<sub>i</sub></code> does not like the person labeled <code>b<sub>i</sub></code>, return <code>true</code> <em>if it is possible to split everyone into two groups in this way</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 4, dislikes = [[1,2],[1,3],[2,4]]
<strong>Output:</strong> true
<strong>Explanation:</strong> The first group has [1,4], and the second group has [2,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3, dislikes = [[1,2],[1,3],[2,3]]
<strong>Output:</strong> false
<strong>Explanation:</strong> We need at least 3 groups to divide them. We cannot put them in two groups.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2000</code></li> 
 <li><code>0 &lt;= dislikes.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>dislikes[i].length == 2</code></li> 
 <li><code>1 &lt;= a<sub>i</sub> &lt; b<sub>i</sub> &lt;= n</code></li> 
 <li>All the pairs of <code>dislikes</code> are <strong>unique</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 图</details><br>

<div>👍 376, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=possible-bipartition" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分图判定算法及应用](https://www.bilibili.com/video/BV18N4y1L7aa)

和 [785. 判断二分图](/problems/is-graph-bipartite) 一样，其实这题考察的就是二分图的判定：

如果你把每个人看做图中的节点，相互讨厌的关系看做图中的边，那么 `dislikes` 数组就可以构成一幅图；

又因为题目说互相讨厌的人不能放在同一组里，相当于图中的所有相邻节点都要放进两个不同的组；

那就回到了「双色问题」，如果能够用两种颜色着色所有节点，且相邻节点颜色都不同，那么你按照颜色把这些节点分成两组不就行了嘛。

所以解法就出来了，我们把 `dislikes` 构造成一幅图，然后执行二分图的判定算法即可。

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
private:
    bool ok = true;
    vector<bool> color;
    vector<bool> visited;

public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        // 图节点编号从 1 开始
        color.resize(n + 1);
        visited.resize(n + 1);
        // 转化成邻接表表示图结构
        vector<vector<int>> graph = buildGraph(n, dislikes);

        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // 建图函数
    vector<vector<int>> buildGraph(int n, vector<vector<int>>& dislikes) {
        // 图节点编号为 1...n
        vector<vector<int>> graph(n + 1);
        for (int i = 1; i <= n; i++) {
            graph[i] = vector<int>();
        }
        for (auto& edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].push_back(w);
            // w -> v
            graph[w].push_back(v);
        }
        return graph;
    }

    // 和之前判定二分图的 traverse 函数完全相同
    void traverse(vector<vector<int>>& graph, int v) {
        if (!ok) return;
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
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
        self.ok = True
        self.color = None
        self.visited = None

    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        # 图节点编号从 1 开始
        self.color = [False] * (n + 1)
        self.visited = [False] * (n + 1)
        # 转化成邻接表表示图结构
        graph = self.buildGraph(n, dislikes)

        for v in range(1, n+1):
            if not self.visited[v]:
                self.traverse(graph, v)
        return self.ok

    # 建图函数
    def buildGraph(self, n: int, dislikes: List[List[int]]) -> List[List[int]]:
        # 图节点编号为 1...n
        graph = [[] for _ in range(n + 1)]
        for edge in dislikes:
            v = edge[1]
            w = edge[0]
            # 「无向图」相当于「双向图」
            # v -> w
            graph[v].append(w)
            # w -> v
            graph[w].append(v)
        return graph

    # 和之前判定二分图的 traverse 函数完全相同
    def traverse(self, graph: List[List[int]], v: int) -> None:
        if not self.ok:
            return
        self.visited[v] = True
        for w in graph[v]:
            if not self.visited[w]:
                self.color[w] = not self.color[v]
                self.traverse(graph, w)
            else:
                if self.color[w] == self.color[v]:
                    self.ok = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    private boolean ok = true;
    private boolean[] color;
    private boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 图节点编号从 1 开始
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        // 转化成邻接表表示图结构
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // 建图函数
    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        return graph;
    }

    // 和之前判定二分图的 traverse 函数完全相同
    private void traverse(List<Integer>[] graph, int v) {
        if (!ok) return;
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import "fmt"

func possibleBipartition(n int, dislikes [][]int) bool {
	color := make([]bool, n+1)
	visited := make([]bool, n+1)
	ok := true

	// 转化成邻接表表示图结构
	graph := buildGraph(n, dislikes)

	var traverse func(int)
	traverse = func(v int) {
		if !ok {
			return
		}
		visited[v] = true
		for _, w := range graph[v] {
			if !visited[w] {
				color[w] = !color[v]
				traverse(w)
			} else {
				if color[w] == color[v] {
					ok = false
				}
			}
		}
	}

	// 全图遍历，防止非连通图出现
	for v := 1; v <= n; v++ {
		if !visited[v] {
			traverse(v)
		}
	}

	return ok
}

// 建图函数
func buildGraph(n int, dislikes [][]int) []([]int) {
	graph := make([]([]int), n+1)
	for i := range graph {
		graph[i] = make([]int, 0)
	}
	for _, edge := range dislikes {
		v := edge[1]
		w := edge[0]
		// 「无向图」相当于「双向图」
		// v -> w
		graph[v] = append(graph[v], w)
		// w -> v
		graph[w] = append(graph[w], v)
	}
	return graph
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @param {number[][]} dislikes
 * @return {boolean}
 */
var possibleBipartition = function(n, dislikes) {
    let ok = true;
    let color = new Array(n + 1);
    let visited = new Array(n + 1);
    let graph = buildGraph(n, dislikes);
    // 建图函数
    function buildGraph(n, dislikes) {
        // 图节点编号为 1...n
        let graph = new Array(n + 1);
        for (let i = 1; i <= n; i++) {
            graph[i] = new Array();
        }
        for (let i = 0; i < dislikes.length; i++) {
            let v = dislikes[i][0];
            let w = dislikes[i][1];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].push(w);
            // w -> v
            graph[w].push(v);
        }
        return graph;
    }
    // 和之前判定二分图的 traverse 函数完全相同
    function traverse(graph, v) {
        if (!ok) return;
        visited[v] = true;
        for (let i = 0; i < graph[v].length; i++) {
            let w = graph[v][i];
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    ok = false;
                }
            }
        }
    }
    for (let v = 1; v <= n; v++) {
        if (!visited[v]) {
            traverse(graph, v);
        }
    }
    return ok;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_possible-bipartition" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_possible-bipartition"></div></div>
</details><hr /><br />

**类似题目**：
  - [785. 判断二分图 🟠](/problems/is-graph-bipartite)
  - [剑指 Offer II 106. 二分图 🟠](/problems/vEAB3K)

</details>
</div>



